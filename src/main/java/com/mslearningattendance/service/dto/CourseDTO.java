package com.mslearningattendance.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter @Getter
public class CourseDTO {
	private UUID courseId;
	private String courseName;
	private Boolean status;
	private Date createdOn;
}
