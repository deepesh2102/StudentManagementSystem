package com.StudentsManagementSystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentsManagementSystem.entity.Student;
import com.StudentsManagementSystem.repository.StudentRepository;
import com.StudentsManagementSystem.service.StudentService;
@Service
public class ServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;
	@Override
	public List<Student> getAllStudents()
	{
		List<Student> list = studentRepository.findAll(); // will give all students from all databases
		
		return list;
	}
	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}
	@Override
	public Student getById(int id) {
		return studentRepository.findById(id).get();
	}
	@Override
	public void deleteById(int id) {
		studentRepository.deleteById(id);
	}

}
