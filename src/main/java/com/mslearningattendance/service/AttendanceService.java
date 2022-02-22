package com.mslearningattendance.service;

import com.mslearningattendance.controller.dto.FullCreateAttendanceDTO;
import com.mslearningattendance.data.AttendanceRepository;
import com.mslearningattendance.data.StudentRepository;
import com.mslearningattendance.domain.Attendance;
import com.mslearningattendance.domain.Student;
import com.mslearningattendance.service.dto.AttendanceDTO;
import com.mslearningattendance.service.dto.AttendanceResponseDTO;
import com.mslearningattendance.service.dto.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private StudentRepository studentRepository;

    public void createAttendance(FullCreateAttendanceDTO aAttendanceDTO){
        RestTemplate restTemplate = new RestTemplate();

        CourseDTO[] courses = restTemplate.getForObject(
                "http://localhost:8081/v1/course?courseId="+aAttendanceDTO.getCourseId(),
                CourseDTO[].class
        );

        if (courses.length == 0) {
            throw new EmptyResultDataAccessException(1);
        }

        Student student = this.studentRepository.findById(aAttendanceDTO.getStudentId().toString()).orElse(null);

        if (student == null) {
            throw new EmptyResultDataAccessException(1);
        }

        this.attendanceRepository.save(
            new Attendance(
                UUID.randomUUID(),
                aAttendanceDTO.getStudentId(),
                aAttendanceDTO.getCourseId(),
                new Date(),
                aAttendanceDTO.getAttendanceStatus()
            )
        );
    }

    public AttendanceResponseDTO findByStudentId(UUID studentId){
        RestTemplate restTemplate = new RestTemplate();

        List<AttendanceDTO> attendanceDTOS = new ArrayList<>();

        Student student = this.studentRepository.findById(studentId.toString()).orElse(null);

        CourseDTO[] courses = restTemplate.getForObject(
                "http://localhost:8081/v1/course?courseId="+student.getCourseId(),
                CourseDTO[].class
        );

        List<Attendance> attendances = this.attendanceRepository.findByStudentId(studentId.toString());

        for (Attendance atendence : attendances) {
            attendanceDTOS.add(
                new AttendanceDTO(
                    atendence.getCourseId(),
                    atendence.getClassDate(),
                    atendence.getAttendanceStatus()
                )
            );
        }

        return new AttendanceResponseDTO(student.getFullName(), courses[0].getCourseName(), attendanceDTOS);
    }
}
