package pl.example.projekt.web;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "meetings")
public class Meeting {
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

    @ManyToMany
    @JoinTable(
            name = "meeting_employee",
            joinColumns = @JoinColumn(name = "meeting_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> attendees;

    @AssertTrue(message = "Start time must be before end time")
    public boolean isStartTimeBeforeEndTime() {
        return startTime.isBefore(endTime);
    }
}