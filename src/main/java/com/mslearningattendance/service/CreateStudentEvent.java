package com.mslearningattendance.service;

import com.mslearningattendance.data.StudentRepository;
import com.mslearningattendance.domain.Student;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CreateStudentEvent {
	@Autowired
	private StudentRepository studentRepository;

    @KafkaListener(
    	topics = "${topic.name}",
    	groupId = "${spring.kafka.consumer.group-id}",
    	containerFactory = "createStudentKafkaListenerContainerFactory"
    )

    public void listenTopcCreateStudent(ConsumerRecord<String, Student> record) {
		this.studentRepository.save(record.value());
    }
}
