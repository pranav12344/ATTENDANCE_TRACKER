////package com.example.attendance_tracker.Services;
////
////import com.example.attendance_tracker.Entity.Attendance;
////import com.example.attendance_tracker.Entity.Subject;
////import com.example.attendance_tracker.Entity.Timetable;
////import com.example.attendance_tracker.Repository.AttendanceRepository;
////import com.example.attendance_tracker.Repository.SubjectRepository;
////import com.example.attendance_tracker.Repository.TimetableRepository;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////
////import java.util.Date;
////import java.util.List;
////
////@Service
////public class AttendanceService {
////
////    @Autowired
////    private AttendanceRepository attendanceRepository;
////
////    @Autowired
////    private TimetableRepository timetableRepository;
////
////    @Autowired
////    private SubjectRepository subjectRepository;
////
////    public List<Timetable> getTimetableForDay(String dayOfWeek) {
////        return timetableRepository.findByDayOfWeek(dayOfWeek);
////    }
////
////    public List<Attendance> getAttendanceBySubjectAndDate(Long subjectId, Date date) {
////        // Assuming Subject is not used here directly, adjust accordingly if needed.
////        return attendanceRepository.findBySubjectIdAndDate(subjectId, date);
////    }
////
////    public void saveAttendance(List<Attendance> attendances) {
////        attendanceRepository.saveAll(attendances);
////    }
////
////    public void saveTimetable(String dayOfWeek, List<Timetable> timetable) {
////        timetableRepository.deleteByDayOfWeek(dayOfWeek); // Clear existing entries for the day
////        timetableRepository.saveAll(timetable);
////    }
////}
//
//package com.example.attendance_tracker.Services;
//
//import com.example.attendance_tracker.Entity.Attendance;
//import com.example.attendance_tracker.Entity.Subject;
//import com.example.attendance_tracker.Entity.Timetable;
//import com.example.attendance_tracker.Repository.AttendanceRepository;
//import com.example.attendance_tracker.Repository.SubjectRepository;
//import com.example.attendance_tracker.Repository.TimetableRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.List;
//
//@Service
//public class AttendanceService {
//
//    @Autowired
//    private AttendanceRepository attendanceRepository;
//
//    @Autowired
//    private TimetableRepository timetableRepository;
//
//    @Autowired
//    private SubjectRepository subjectRepository;
//
//    public List<Timetable> getTimetableForDay(String dayOfWeek) {
//        return timetableRepository.findByDayOfWeek(dayOfWeek);
//    }
//
//    public List<Attendance> getAttendanceBySubjectAndDate(Long subjectId, Date date) {
//        return attendanceRepository.findBySubjectIdAndDate(subjectId, date);
//    }
//
//    public void saveAttendance(List<Attendance> attendances) {
//        attendanceRepository.saveAll(attendances);
//    }
//
//    public void saveTimetable(String dayOfWeek, List<Timetable> timetable) {
//        // Clear existing entries for the day
//        timetableRepository.deleteByDayOfWeek(dayOfWeek);
//
//        // Ensure each Timetable entry has the correct dayOfWeek
//        for (Timetable t : timetable) {
//            t.setDayOfWeek(dayOfWeek);
//        }
//
//        // Save all timetable entries
//        timetableRepository.saveAll(timetable);
//    }
//}
package com.example.attendance_tracker.Services;

import com.example.attendance_tracker.Entity.Timetable;
import com.example.attendance_tracker.Entity.Attendance;
import com.example.attendance_tracker.Repository.AttendanceRepository;
import com.example.attendance_tracker.Repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

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

    @Transactional
    public void saveAttendance(List<Attendance> attendances) {
        attendanceRepository.saveAll(attendances);
    }

    @Transactional(readOnly = true)
    public Long countPresentDays(Long subjectId) {
        return attendanceRepository.countBySubjectIdAndPresentTrue(subjectId);
    }

    @Transactional(readOnly = true)
    public Long countAbsentDays(Long subjectId) {
        return attendanceRepository.countBySubjectIdAndPresentFalse(subjectId);
    }
}
