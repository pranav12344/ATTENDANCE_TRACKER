package com.example.attendance_tracker.Services;

import com.example.attendance_tracker.Entity.Timetable;
import com.example.attendance_tracker.Repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TimetableService {

    @Autowired
    private TimetableRepository timetableRepository;

    @Transactional(readOnly = true)
    public List<Timetable> getTimetableForDay(String dayOfWeek) {
        return timetableRepository.findByDayOfWeek(dayOfWeek);
    }

    @Transactional
    public void saveTimetable(String dayOfWeek, List<Timetable> timetable) {
        timetableRepository.deleteByDayOfWeek(dayOfWeek);
        for (Timetable t : timetable) {
            t.setDayOfWeek(dayOfWeek);
        }
        timetableRepository.saveAll(timetable);
    }
}
