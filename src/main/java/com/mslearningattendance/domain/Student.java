package com.mslearningattendance.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.util.UUID;

@Getter @Setter
@RedisHash("Student")
public class Student implements Serializable {
	@Id
	@Indexed
	private UUID studentId;
	private String fullName;
	private UUID courseId;
}
