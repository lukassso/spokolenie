package pl.spokolenie.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity(name = "groups")
public class Group {

    @Id
    @Column
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String location;

    @Column
    private String photo;

    @ManyToOne
    private User admin;

    @ManyToMany
    private Set<User> members;

    @OneToOne
    private Chat chat;

    public void addMember(User user) {
        members.add(user);
    }
}
