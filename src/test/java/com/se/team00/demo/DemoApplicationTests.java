package com.se.team00.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import  com.se.team00.demo.Repository.StudentRepository;
import  com.se.team00.demo.Entity.Student;

import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
@RunWith(SpringRunner.class)
//@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private TestEntityManager entityManager;

	private Validator validator;

	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testStudentFirstNameCannotBeNull() {
		Student s = new Student();
		s.setFirstName(null);
		s.setLastName("Abcd");
		s.setStudentId("B5900000");

		try {
			entityManager.persist(s);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test(expected=javax.persistence.PersistenceException.class)
	public void testIdMustBeUnique() {
		Student s1 = new Student();
		s1.setFirstName("Abcd");
		s1.setLastName("Abcd");
		s1.setStudentId("B5900000");
		entityManager.persist(s1);
		entityManager.flush();

		Student s2 = new Student();
		s2.setFirstName("Defg");
		s2.setLastName("Defg");
		s2.setStudentId("B5900000");

		entityManager.persist(s2);
		entityManager.flush();

		fail("Should not pass to this line");
	}

	@Test
	public void whenMessageAssigned_thenItIsNotNull() {
		String message = "hello there";
		assertNotNull(message);
	}

}