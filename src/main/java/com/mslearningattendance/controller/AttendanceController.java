package com.mslearningattendance.controller;

import com.mslearningattendance.controller.dto.CreateAttendanceDTO;
import com.mslearningattendance.controller.dto.FullCreateAttendanceDTO;
import com.mslearningattendance.service.AttendanceService;
import com.mslearningattendance.service.dto.AttendanceResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/course/{courseId}/student/{studentId}/attendance")
    public void create(@PathVariable UUID courseId, @PathVariable UUID studentId, @RequestBody CreateAttendanceDTO createAttendanceDTO) {
        FullCreateAttendanceDTO attendanceDTO = new FullCreateAttendanceDTO(
                courseId,
                studentId,
                createAttendanceDTO.getAttendanceStatus()
        );

        this.attendanceService.createAttendance(attendanceDTO);
    }

    @GetMapping("/student/{studentId}/attendance")
    public AttendanceResponseDTO findByStudentId(@PathVariable UUID studentId) {
        return this.attendanceService.findByStudentId(studentId);
    }
}
