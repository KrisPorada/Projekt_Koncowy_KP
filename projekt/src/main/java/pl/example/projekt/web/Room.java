package pl.example.projekt.web;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotNull(message = "Room name cannot be null")  //walidacja czy nie pusta  nazwa
    @Pattern(regexp = "[a-zA-Z0-9 ]{3,}",
            message = "Room name must have at least 3 characters and can contain only letters, digits and spaces")     //walidacja nazwy salki
    private String name;

    @Column(nullable = false)
    @Min(value = 1, message = "Room capacity must be greater than 0")  //walidacja pojemnosci sali
    private int capacity;

    @OneToMany(mappedBy = "room")
    private List<Meeting> meetings;
}