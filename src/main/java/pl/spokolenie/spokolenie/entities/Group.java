package pl.spokolenie.spokolenie.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;

@Getter
@Setter
@Entity
public class Group {
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private User admin;
    @ManyToMany
    private ArrayList<User> members;

    public void addMember(User user) {
        members.add(user);
    }
}
