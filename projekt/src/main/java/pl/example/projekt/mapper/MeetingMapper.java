package pl.example.projekt.mapper;

import org.mapstruct.Mapper;
import pl.example.projekt.dto.MeetingDto;
import pl.example.projekt.web.Meeting;

@Mapper(componentModel = "spring")
public interface MeetingMapper {
    MeetingDto toDto(Meeting meeting);
    Meeting toEntity(MeetingDto dto);
}