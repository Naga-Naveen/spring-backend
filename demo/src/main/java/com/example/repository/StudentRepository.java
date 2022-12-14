package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	List<Student> findByFirstName(String firstName);
	
	Student findByFirstNameAndLastName(String firstName, String lastName);
	
	List<Student> findByFirstNameOrLastName(String firstName, String lastName);
	
	List<Student> findByFirstNameIn (List<String> firstNames);
	
	List<Student> findByFirstNameContains(String firstName);
	
	List<Student> findByFirstNameStartsWith(String firstName);
	
	List<Student> findByFirstNameEndsWith(String firstName);
	
	@Modifying
	@Transactional
	@Query("Delete From Student where firstName = :firstName")
	Integer deletebyFirstName(String firstName);
	
	List<Student> findByAddressCity(String city);

}

