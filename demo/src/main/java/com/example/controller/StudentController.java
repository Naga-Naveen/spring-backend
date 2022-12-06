package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.request.CreateStudentRequest;
import com.example.request.InQueryRequest;
import com.example.request.UpdateStudentRequest;
import com.example.response.StudentResponse;
import com.example.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("allstudents")
	public List<StudentResponse> getAllStudents(){
		List<Student> studentList =  studentService.getAllStudents();
		List<StudentResponse> studentResponse = new ArrayList<StudentResponse>();
		studentList.stream().forEach(student ->{
			studentResponse.add(new StudentResponse(student));
		});
		
		
		return studentResponse;
	}
	
	@PostMapping("create")
	public StudentResponse createStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest) {
		Student student = studentService.CreateStudent(createStudentRequest);
		return new StudentResponse(student);
	}
	
	@PutMapping("update")
	public StudentResponse updateStudent(@Valid @RequestBody UpdateStudentRequest updateStudentRequest) {
		Student student = studentService.updateStudent(updateStudentRequest);
		return new StudentResponse(student);
	}
	
	@DeleteMapping("delete")
	public String deleteStudent(@RequestParam Integer id) {
		return studentService.deleteStudent(id);
	}
	
	@GetMapping("getbyfirstname/{firstName}")
	public List<StudentResponse> getByFirstName(@PathVariable String firstName){
		List<Student> studentList = studentService.getByFirstName(firstName);
		List<StudentResponse> studentResponse = new ArrayList<StudentResponse>();
		studentList.stream().forEach(student ->{
			studentResponse.add(new StudentResponse(student));
		});
		
		
		return studentResponse;
	}
	
	@GetMapping("getbyfirstandlastName/{firstName}/{lastName}")
	public StudentResponse getByFirstandLastname(@PathVariable String firstName, @PathVariable String lastName){
		return new StudentResponse(studentService.getByFirstandLastname(firstName, lastName));
	}
	
	@GetMapping("getbyfirstorlastName/{firstName}/{lastName}")
	public List<StudentResponse> getByFirstorLastName(@PathVariable String firstName, @PathVariable String lastName){
		List<Student> studentList = studentService.getByFirstorlastName(firstName, lastName);
		List<StudentResponse> studentResponse = new ArrayList<StudentResponse>();
		studentList.stream().forEach(student ->{
			studentResponse.add(new StudentResponse(student));
		});
		
		
		return studentResponse;
	}
	
	@GetMapping("getbyfirstNames")
	public List<StudentResponse> getByFirstNames(@RequestBody InQueryRequest inQueryRequest){
		List<Student> studentList = studentService.getByFirstNamein(inQueryRequest);
		List<StudentResponse> studentResponse = new ArrayList<StudentResponse>();
		studentList.stream().forEach(student ->{
			studentResponse.add(new StudentResponse(student));
		});
		
		
		return studentResponse;
	}
	
	@GetMapping("getallwithpagination")
	public List<StudentResponse> getallwithPagination(@RequestParam int pageNo, @RequestParam int pageSize){
		List<Student> studentList = studentService.getAllStudentswithPagination(pageNo, pageSize);
		List<StudentResponse> studentResponse = new ArrayList<StudentResponse>();
		studentList.stream().forEach(student ->{
			studentResponse.add(new StudentResponse(student));
		});
		
		
		return studentResponse;
	}
	
	@GetMapping("getallstudentswithsort")
	public List<StudentResponse> getAllwithSort(){
		List<Student> studentList = studentService.getAllStudentswithsorting();
		List<StudentResponse> studentResponse = new ArrayList<StudentResponse>();
		studentList.stream().forEach(student ->{
			studentResponse.add(new StudentResponse(student));
		});
		
		
		return studentResponse;
	}
	
	@GetMapping("like/{firstName}")
	public List<StudentResponse> like(@PathVariable String firstName){
		List<Student> studentList = studentService.Like(firstName);
		List<StudentResponse> studentResponse = new ArrayList<StudentResponse>();
		studentList.stream().forEach(student ->{
			studentResponse.add(new StudentResponse(student));
		});
		
		
		return studentResponse;
	}
	
	@GetMapping("startswith/{firstName}")
	public List<StudentResponse> startsWith(@PathVariable String firstName){
		List<Student> studentList = studentService.startsWith(firstName);
		List<StudentResponse> studentResponse = new ArrayList<StudentResponse>();
		studentList.stream().forEach(student ->{
			studentResponse.add(new StudentResponse(student));
		});
		
		
		return studentResponse;
	}
	
	@GetMapping("endswith/{firstName}")
	public List<StudentResponse> endsWith(@PathVariable String firstName){
		List<Student> studentList = studentService.endsWith(firstName);
		List<StudentResponse> studentResponse = new ArrayList<StudentResponse>();
		studentList.stream().forEach(student ->{
			studentResponse.add(new StudentResponse(student));
		});
		
		
		return studentResponse;
	}
	
	@DeleteMapping("deletestudent/{firstName}")
	public String DeleteStudent(@PathVariable String firstName) {
		return studentService.deleteStudent(firstName) + " Student Deleted";
	}
	
	@GetMapping("getbyCity/{city}")
    public List<StudentResponse> getByCity(@PathVariable String city){
		List<Student> studentList = studentService.getbyCity(city);
		List<StudentResponse> studentResponse = new ArrayList<StudentResponse>();
		studentList.stream().forEach(student ->{
			studentResponse.add(new StudentResponse(student));
		});
		
		
		return studentResponse;
	}
	
}
