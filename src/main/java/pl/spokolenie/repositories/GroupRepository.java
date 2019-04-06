package pl.spokolenie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.spokolenie.entities.Group;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {

    Optional<Group> findGroupByName(String name);
}
