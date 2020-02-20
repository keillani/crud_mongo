package com.student.information.system.repository;

import com.student.information.system.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

// Não há necessidade de implementação, apenas uma interface e você possui CRUD, graças ao Spring Data!
public interface StudentRepository extends MongoRepository<Student, String> {

    Student findByStudentNumber(long studentNumber);

    Student findByEmail(String email);

    List<Student> findAllByOrderByGpa();

}

