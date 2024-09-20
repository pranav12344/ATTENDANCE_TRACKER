package com.example.attendance_tracker.Services;

import com.example.attendance_tracker.Entity.Subject;
import com.example.attendance_tracker.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    // Get all subjects
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    // Get a subject by ID
    public Optional<Subject> getSubjectById(Long id) {
        return subjectRepository.findById(id);
    }

    // Save a new subject
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    // Delete a subject by ID
    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
}
