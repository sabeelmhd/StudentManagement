package com.example.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
	 
   // Course findCourseByStudentId(int studentid);
    
}
