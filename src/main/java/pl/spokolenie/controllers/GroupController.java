package pl.spokolenie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.spokolenie.entities.Chat;
import pl.spokolenie.entities.Group;
import pl.spokolenie.entities.User;
import pl.spokolenie.repositories.UserRepository;

import java.util.HashSet;

@Controller
public class GroupController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/createGroup")
    public Group createGroup(@RequestParam("name") String name, @RequestParam("description") String description) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserEmail = authentication.getName();
        if (!userRepository.findByEmailAdress(currentUserEmail).isPresent())
            throw new RuntimeException();
        User currentUser = userRepository.findByEmailAdress(currentUserEmail).get();

        Group newGroup = new Group();
        newGroup.setName(name);
        newGroup.setDescription(description);
        newGroup.setChat(new Chat());
        newGroup.setAdmin(currentUser);
        newGroup.setMembers(new HashSet<>());
        return newGroup;
    }
}
