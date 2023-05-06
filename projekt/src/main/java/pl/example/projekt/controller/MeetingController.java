package pl.example.projekt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.example.projekt.service.MeetingService;
import pl.example.projekt.web.Meeting;

import java.util.List;

@RestController
@RequestMapping("/api/meetings")
public class MeetingController {

    private final MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping
    public ResponseEntity<List<Meeting>> findAll() {
        return ResponseEntity.ok(meetingService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meeting> findById(@PathVariable Long id) {
        return ResponseEntity.ok(meetingService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Meeting> create(@RequestBody Meeting meeting) {
        return ResponseEntity.status(HttpStatus.CREATED).body(meetingService.save(meeting));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Meeting> update(@PathVariable Long id, @RequestBody Meeting meeting) {
        meeting.setId(id);
        return ResponseEntity.ok(meetingService.save(meeting));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        meetingService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
