package pl.example.projekt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.example.projekt.repository.MeetingRepository;
import pl.example.projekt.web.Meeting;
import java.util.List;

@Service
public class MeetingService {
    @Autowired
    private MeetingRepository meetingRepository;

    public List<Meeting> findAll() {
        return meetingRepository.findAll();
    }

    public Meeting findById(Long id) {
        return meetingRepository.findById(id).orElseThrow(() -> new RuntimeException("Meeting not found"));
    }

    public Meeting save(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    public void deleteById(Long id) {
        meetingRepository.deleteById(id);
    }
}

