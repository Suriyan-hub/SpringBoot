package com.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.web.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	List<Student> findBySname(String sname);
	List<Student> findBySidGreaterThan(int sid);
	List<Student> findBySnameStartsWith(char c);
	
	@Query("from Student where course=?1 order by sname")//JPQL query similar to sql we can create our own query by using @query
	List<Student> findByCourseSorted(String course);
}
