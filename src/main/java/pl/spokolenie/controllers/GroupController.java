package pl.spokolenie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.spokolenie.entities.Chat;
import pl.spokolenie.entities.Group;
import pl.spokolenie.entities.User;
import pl.spokolenie.repositories.ChatRepository;
import pl.spokolenie.repositories.GroupRepository;
import pl.spokolenie.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.HashSet;

@RestController
public class GroupController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ChatRepository chatRepository;

    @RequestMapping(name = "/group/create", method = RequestMethod.POST)
    public Group createGroup(@RequestParam("name") String name, @RequestParam("description") String description,
                             @RequestParam("location") String location, @RequestParam("photo") String photo) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserEmail = authentication.getName();
        if (!userRepository.findByEmailAdress(currentUserEmail).isPresent())
            throw new RuntimeException();
        User currentUser = userRepository.findByEmailAdress(currentUserEmail).get();

        Group newGroup = new Group();
        newGroup.setName(name);
        newGroup.setDescription(description);
        Chat chat = new Chat();
        newGroup.setChat(chatRepository.save(chat));
        newGroup.setLocation(location);
        newGroup.setPhoto(photo);
        newGroup.setAdmin(currentUser);
        newGroup.setMembers(new HashSet<>());
        return groupRepository.save(newGroup);
    }
}
