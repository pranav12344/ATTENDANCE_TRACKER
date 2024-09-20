////package com.example.attendance_tracker.Controllers;
////import com.example.attendance_tracker.Entity.Attendance;
////import com.example.attendance_tracker.Entity.Timetable;
////import com.example.attendance_tracker.Services.AttendanceService;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.web.bind.annotation.*;
////import java.util.List;
////
////@RestController
////@RequestMapping("/api/attendance")
////@CrossOrigin(origins = "*")
////public class AttendanceController {
////
////    @Autowired
////    private AttendanceService attendanceService;
////
////    @GetMapping("/timetable/{day}")
////    public List<Timetable> getTimetable(@PathVariable String day) {
////        return attendanceService.getTimetableForDay(day.toUpperCase());
////    }
////
////    @PostMapping("/save")
////    public String saveAttendance(@RequestBody List<Attendance> attendances) {
////        attendanceService.saveAttendance(attendances);
////        return "Attendance saved successfully!";
////    }
////
////    @GetMapping("/percentage/{subjectId}")
////    public String getAttendancePercentage(@PathVariable Long subjectId) {
////        // Calculate and return attendance percentage logic here.
////        return "85%";  // For demonstration purposes
////    }
////}
//package com.example.attendance_tracker.Controllers;
//
//import com.example.attendance_tracker.Entity.Attendance;
//import com.example.attendance_tracker.Entity.Timetable;
//import com.example.attendance_tracker.Services.AttendanceService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/attendance")
//@CrossOrigin(origins = "*")
//public class AttendanceController {
//
//    @Autowired
//    private AttendanceService attendanceService;
//
//    @GetMapping("/timetable/{day}")
//    public List<Timetable> getTimetable(@PathVariable String day) {
//        return attendanceService.getTimetableForDay(day.toUpperCase());
//    }
//
//    @PostMapping("/timetable/{day}")
//    public String saveTimetable(@PathVariable String day, @RequestBody List<Timetable> timetable) {
//        attendanceService.saveTimetable(day.toUpperCase(), timetable);
//        return "Timetable saved successfully!";
//    }
//
//    @PostMapping("/save")
//    public String saveAttendance(@RequestBody List<Attendance> attendances) {
//        attendanceService.saveAttendance(attendances);
//        return "Attendance saved successfully!";
//    }
//
//    @GetMapping("/percentage/{subjectId}")
//    public String getAttendancePercentage(@PathVariable Long subjectId) {
//        // Calculate and return attendance percentage logic here.
//        return "85%";  // For demonstration purposes
//    }
//}
package com.example.attendance_tracker.Controllers;

import com.example.attendance_tracker.Entity.Attendance;
import com.example.attendance_tracker.Entity.Timetable;
import com.example.attendance_tracker.Services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin(origins = "*")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/timetable/{day}")
    public List<Timetable> getTimetable(@PathVariable String day) {
        return attendanceService.getTimetableForDay(day.toUpperCase());
    }

    @PostMapping("/timetable/{day}")
    public String saveTimetable(@PathVariable String day, @RequestBody List<Timetable> timetable) {
        attendanceService.saveTimetable(day.toUpperCase(), timetable);
        return "Timetable saved successfully!";
    }

    @PostMapping("/save")
    public String saveAttendance(@RequestBody List<Attendance> attendances) {
        attendanceService.saveAttendance(attendances);
        return "Attendance saved successfully!";
    }

    @GetMapping("/percentage/{subjectId}")
    public String getAttendancePercentage(@PathVariable Long subjectId) {
        Long presentDays = attendanceService.countPresentDays(subjectId);
        Long absentDays = attendanceService.countAbsentDays(subjectId);

        if (presentDays + absentDays == 0) {
            return "No attendance data available.";
        }

        double percentage = (presentDays * 100.0) / (presentDays + absentDays);
        return String.format("%.2f%%", percentage);
    }
}
