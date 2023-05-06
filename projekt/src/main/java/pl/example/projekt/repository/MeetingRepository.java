package pl.example.projekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.example.projekt.web.Meeting;

public interface MeetingRepository extends JpaRepository <Meeting, Long> {
}
