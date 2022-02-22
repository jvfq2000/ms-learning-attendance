package com.mslearningattendance.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class AttendanceResponseDTO {
    private String fullName;
    private String courseName;
    private List<AttendanceDTO> attendances;
}
