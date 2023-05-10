package pl.example.projekt.mapper;

import org.mapstruct.Mapper;
import pl.example.projekt.dto.EmployeeDto;
import pl.example.projekt.web.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDto toDto(Employee employee);
    Employee toEntity(EmployeeDto dto);
}