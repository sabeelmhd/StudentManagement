package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.StudentRepository;
import com.example.model.Course;
import com.example.model.Enrollment;
import com.example.model.Student;
import com.example.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/createStudent")
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@PostMapping("/createStudents")
	public List<Student> createStudents(@RequestBody List<Student> students) {
		return studentService.createStudents(students);
	}
	
	@PostMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		return studentService.deleteStudent(id);
	}
	
	@GetMapping("/all")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@GetMapping("/search/{firstName}")
	public List<Student> searchStudentsByFirstName(@PathVariable String firstName) {
		return studentService.searchStudentsByFirstName(firstName);
	}
	
//	@GetMapping("/{id}/details")
//    public Student getStudentDetails(@PathVariable int id) {
//        return studentService.getStudentDetails(id);
//    }
	
	@GetMapping("/{studentid}/course")
	public Course getCourseDetailsByCourseId(@PathVariable int studentid){
		return studentService.getCourseDetailsByStudentId(studentid);
	}
}

