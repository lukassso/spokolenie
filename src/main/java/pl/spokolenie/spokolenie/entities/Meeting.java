package pl.spokolenie.spokolenie.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.DateTimeException;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
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
    private LocalDateTime startDateTime;

    @Column
    private LocalDateTime finishDateTime;

    @OneToOne
    private Chat chat;

    public Meeting(String name, String description, Group group, Chat chat,
                   LocalDateTime startDateTime, LocalDateTime finishDateTime)
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

        if (startDateTime.isBefore(LocalDateTime.now()))
            throw new DateTimeException("startTimeDate is before now");
        if (!startDateTime.isBefore(finishDateTime))
            throw new DateTimeException("finishDateTime must be later than startDateTime");

        this.name = name;
        this.description = description;
        this.group = group;
        this.startDateTime = startDateTime;
        this.finishDateTime = finishDateTime;
        this.chat = chat;
    }

}
