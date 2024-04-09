package com.springrest.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.springrest.dao.CourseDao;
import com.springrest.entities.Course;
import com.springrest.services.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;

	//List<Course> list;
	
	public CourseServiceImpl() {
//		list =new ArrayList<>();
//		list.add(new Course(111,"Java Core Course", "This course contains basics of java"));
//		list.add(new Course(131,"Spring Boot Course", "This course contains basics of spring"));
	}
	
	@Override
	public List<Course> getCourses() {
		
		return courseDao.findAll();
	}

	@Override
	public Course getCourse( long courseId) {
//		Course c = null;
//		for (Course course : list) {
//			if(course.getId()==courseId) {
//				c=course;
//				break;
//			}
//		}
		return courseDao.getReferenceById(courseId);
		
	}

	@Override
	public Course addCourse(Course course) {
		
		
		return courseDao.save(course);
		
	}

	@Override
	public Course updateCourse(Course c,long id) {
//		Course c=null;
//		for (Course course : list) {
//			if(course.getId()==id) {
//				c=course;
//				c.setTitle("C++");
//				c.setDescription("Hello World");
//				break;
//			}
//		}
		
		List<Course> list = new ArrayList<>();
		Course course=new Course();
		course.setId(c.getId());
		course.setTitle(c.getTitle());;
		course.setDescription(c.getDescription());
		for (Course crs : list) {
			if(crs.getId()==id) {
				c=course;
				break;
			}
		}
		
		return courseDao.save(c);
	}

	@Override
	public void deleteCourse(long id) {
		Course c = courseDao.getReferenceById(id);
		courseDao.delete(c);
	}
	

}
