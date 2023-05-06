package pl.example.projekt.dto;

import pl.example.projekt.web.Room;


import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class MeetingDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @NotNull(message = "Start time must not be null")
    @FutureOrPresent(message = "Start time must be in the future or present")
    private LocalDateTime startTime;

    @Column(nullable = false)
    @NotNull(message = "End time must not be null")
    @FutureOrPresent(message = "End time must be in the future or present")
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

}
