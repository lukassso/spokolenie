package pl.spokolenie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.spokolenie.entities.Chat;
import pl.spokolenie.entities.Group;
import pl.spokolenie.entities.Meeting;
import pl.spokolenie.entities.User;
import pl.spokolenie.repositories.ChatRepository;
import pl.spokolenie.repositories.GroupRepository;
import pl.spokolenie.repositories.MeetingRepository;
import pl.spokolenie.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.HashSet;

@RestController
public class MeetingController {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private MeetingRepository meetingRepository;

    @Autowired
    private ChatRepository chatRepository;

    @RequestMapping(value = "group/{groupId}/meeting/create", method = RequestMethod.POST)
    public Meeting createMeeting(@PathVariable("groupId") long groupId, @RequestParam("name") String name, @RequestParam("description") String description,
                                 @RequestParam("startDateTime") String startDateTime,
                                 @RequestParam("finishDateTime") String finishDateTime) {

        Group group = groupRepository.findById(groupId).get();

        Meeting newMeeting = new Meeting(name, description, group, new Chat(), startDateTime, finishDateTime );

        return meetingRepository.save(newMeeting);
    }
}
