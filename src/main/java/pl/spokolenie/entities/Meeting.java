package pl.spokolenie.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.DateTimeException;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Meeting {

    @Id
    @Column
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToOne
    private Group group;

    @Column
    private String startDateTime;

    @Column
    private String finishDateTime;

    @OneToOne
    private Chat chat;

    public Meeting(String name, String description, Group group, Chat chat,
                   String startDateTime, String finishDateTime)
            throws DateTimeException, NullPointerException {

        if (name == null)
            throw new NullPointerException("meeting name is null");
        if (description == null)
            throw new NullPointerException("Meeting's description is null");
        if (group == null)
            throw new NullPointerException("group is null");
        if (chat == null)
            throw new NullPointerException("chat is null");
        if (startDateTime == null)
            throw new DateTimeException("startDateTime is null");
        if (finishDateTime == null)
            throw new DateTimeException("finishDateTime is null");

        this.name = name;
        this.description = description;
        this.group = group;
        this.startDateTime = startDateTime;
        this.finishDateTime = finishDateTime;
        this.chat = chat;
    }

}
