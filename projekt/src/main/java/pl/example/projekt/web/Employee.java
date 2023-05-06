package pl.example.projekt.web;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Pattern(regexp = "[a-zA-Z]{2,}", message = "Name must consist of at least 2 letters")   //walidacja imienia
    private String firstName;

    @Column(nullable = false)
    @Pattern(regexp = "[a-zA-Z]{2,}", message = "Surname must consist of at least 2 letters")  //walidacja nazwiska
    private String lastName;

    @Column(nullable = false, unique = true)
    @Email(message = "Email should be valid")   //walidacja maila
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @Valid
    private Department department;

    @ManyToMany(mappedBy = "attendees")
    private List<Meeting> meetings;
}