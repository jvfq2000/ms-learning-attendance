package com.mslearningattendance.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
public class AttendanceDTO {
    private UUID courseId;
    private Date classDate;
    private Boolean attendanceStatus;
}
