package pl.spokolenie.spokolenie.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

}
