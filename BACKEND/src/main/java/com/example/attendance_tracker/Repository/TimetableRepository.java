package com.example.attendance_tracker.Repository;

import com.example.attendance_tracker.Entity.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {

    // Find timetables by day of the week
    List<Timetable> findByDayOfWeek(String dayOfWeek);

    // Delete timetables by day of the week
    void deleteByDayOfWeek(String dayOfWeek);
}
