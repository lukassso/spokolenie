package pl.spokolenie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.spokolenie.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailAdress(String username);

}
