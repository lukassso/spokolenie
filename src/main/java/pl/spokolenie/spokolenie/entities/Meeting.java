package pl.spokolenie.spokolenie.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Meeting {
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
    @Column
    private Chat chat;

}
