package com.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.entities.Course;
import com.springrest.services.CourseService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;
	
	// get the course
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.courseService.getCourses();
		
	}
	
	// get the course by id
	@GetMapping("/courses/{courseId}")
	public Course getCourses(@PathVariable String courseId){
		
		return this.courseService.getCourse(Long.parseLong(courseId));	
	}
	
	// add a new course in the list
	@PostMapping("/addCourse")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	
	// update an existing course
	@PutMapping("updateCourse/{id}")
	public Course updateCourse(@RequestBody Course course,@PathVariable String id) {
		
		
		return this.courseService.updateCourse(course, Long.parseLong(id));
	}
	
	@DeleteMapping("deleteCourse/{id}")
	public ResponseEntity<HttpStatusCode> deleteCourse(@PathVariable String id) {
		try {
			this.courseService.deleteCourse(Long.parseLong(id));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
}
