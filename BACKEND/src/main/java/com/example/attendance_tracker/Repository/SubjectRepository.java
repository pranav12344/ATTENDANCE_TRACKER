package com.example.attendance_tracker.Repository;

import com.example.attendance_tracker.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
