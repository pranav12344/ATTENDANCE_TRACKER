package com.example.attendance_tracker.Controllers;

import com.example.attendance_tracker.Entity.Timetable;
import com.example.attendance_tracker.Services.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timetable")
@CrossOrigin(origins = "*")
public class TimetableController {

    @Autowired
    private TimetableService timetableService;

    @GetMapping("/{day}")
    public List<Timetable> getTimetable(@PathVariable String day) {
        return timetableService.getTimetableForDay(day.toUpperCase());
    }

    @PostMapping("/{day}")
    public String saveTimetable(@PathVariable String day, @RequestBody List<Timetable> timetable) {
        timetableService.saveTimetable(day.toUpperCase(), timetable);
        return "Timetable saved successfully!";
    }
}
