package pl.example.projekt.dto;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Data
public class EmployeeDto {
    private Long id;

    @NotBlank(message = "First name cannot be blank")
    @Pattern(regexp = "[a-zA-Z]{2,}", message = "First name must consist of at least 2 letters")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Pattern(regexp = "[a-zA-Z]{2,}", message = "Last name must consist of at least 2 letters")
    private String lastName;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    private String email;


}
