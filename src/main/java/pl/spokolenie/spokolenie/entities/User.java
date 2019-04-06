package pl.spokolenie.spokolenie.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class User {
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
