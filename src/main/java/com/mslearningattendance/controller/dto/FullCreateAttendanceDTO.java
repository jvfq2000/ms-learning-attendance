package com.mslearningattendance.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
public class FullCreateAttendanceDTO {
    UUID courseId;
    UUID studentId;
    Boolean attendanceStatus;
}
