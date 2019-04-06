package pl.spokolenie.spokolenie.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
@Setter
@Getter
public class Chat {

    @Id
    @Column
    @GeneratedValue
    private long id;

    private ArrayList<Message> messages;

    public void addMessage(Message message) {
        messages.add(message);
    }
}
