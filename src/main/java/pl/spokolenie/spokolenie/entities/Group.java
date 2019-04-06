package pl.spokolenie.spokolenie.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.ArrayList;

@Getter
@Setter
@Entity
public class Group {
    private String name;
    private String description;
    private User admin;
    private ArrayList<User> members;

    public void addMember(User user) {
        members.add(user);
    }
}
