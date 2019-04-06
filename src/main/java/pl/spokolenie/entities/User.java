package pl.spokolenie.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {

    @Id
    @Column
    @GeneratedValue
    private long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String description;

    @Column
    private String emailAdress;

    @Column
    private String profileImageURLAdress;

}
