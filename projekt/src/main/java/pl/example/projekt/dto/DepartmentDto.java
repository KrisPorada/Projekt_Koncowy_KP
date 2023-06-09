package pl.example.projekt.dto;

import lombok.Data;
import javax.validation.constraints.Pattern;


@Data
public class DepartmentDto {
    private Long id;
    @Pattern(regexp = "[a-zA-Z]{3,}", message = "Department name must consist of at least 3 letters")
    private String name;

}
