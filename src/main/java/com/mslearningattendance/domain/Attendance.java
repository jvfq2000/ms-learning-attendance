package com.mslearningattendance.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
@RedisHash("Attendance")
public class Attendance implements Serializable {
    @Id
    @Indexed
    private UUID attendanceId;
    @Indexed
    private UUID studentId;
    private UUID courseId;
    private Date classDate;
    private Boolean attendanceStatus;
}
