package pl.spokolenie.entities;

import lombok.Getter;
import lombok.Setter;
import pl.spokolenie.security.AuthorityType;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "authority")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private AuthorityType name;

    public Authority() {}

    public Authority(AuthorityType name) {
        this.name = name;
    }
}