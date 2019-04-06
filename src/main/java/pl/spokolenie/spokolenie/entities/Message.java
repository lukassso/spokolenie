package pl.spokolenie.spokolenie.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Message {

    @Id
    @Column
    @GeneratedValue
    private long id;

    @ManyToOne
    private User user;

    @Column
    private String text;
}
