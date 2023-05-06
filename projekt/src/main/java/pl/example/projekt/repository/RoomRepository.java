package pl.example.projekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.example.projekt.web.Room;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository <Room, Long>{
    @Query("SELECT r FROM Room r WHERE r.id NOT IN (SELECT m.room.id FROM Meeting m WHERE m.startTime = m.startTime AND m.endTime = m.endTime)")
    List<Room> findAvailableRooms(LocalDateTime startTime, LocalDateTime endTime);
}
