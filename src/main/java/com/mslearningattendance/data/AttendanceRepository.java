package com.mslearningattendance.data;
import com.mslearningattendance.domain.Attendance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends CrudRepository<Attendance, String> {
    public List<Attendance> findByStudentId(String studentId);
}
