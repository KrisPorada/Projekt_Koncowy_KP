package pl.example.projekt.mapper;

import org.mapstruct.Mapper;
import pl.example.projekt.dto.DepartmentDto;
import pl.example.projekt.web.Department;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentDto toDto(Department department);
    Department toEntity(DepartmentDto dto);
}