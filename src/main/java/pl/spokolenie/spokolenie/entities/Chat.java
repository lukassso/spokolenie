package pl.spokolenie.spokolenie.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
@Setter
@Getter
public class Chat {
    private ArrayList<Message> messages;

    public void addMessage(Message message) {
        messages.add(message);
    }
}
