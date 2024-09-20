//package com.example.attendance_tracker.Repository;
//
//import com.example.attendance_tracker.Entity.Attendance;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Date;
//import java.util.List;
//
//public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
//    List<Attendance> findBySubjectIdAndDate(Long subjectId, Date date);
//}
package com.example.attendance_tracker.Repository;

import com.example.attendance_tracker.Entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    // Find attendance records by subjectId and date
    List<Attendance> findBySubjectIdAndDate(Long subjectId, Date date);

    // Count the number of days present for a given subjectId
    Long countBySubjectIdAndPresentTrue(Long subjectId);

    // Count the number of days absent for a given subjectId
    Long countBySubjectIdAndPresentFalse(Long subjectId);
}
