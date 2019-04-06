package pl.spokolenie.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
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
