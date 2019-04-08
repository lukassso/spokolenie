package pl.spokolenie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.spokolenie.entities.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
