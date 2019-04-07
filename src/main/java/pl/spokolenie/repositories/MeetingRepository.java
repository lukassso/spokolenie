package pl.spokolenie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.spokolenie.entities.Meeting;

import java.util.Optional;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {

    Optional<Meeting> findMeetingByName(String name);
}
