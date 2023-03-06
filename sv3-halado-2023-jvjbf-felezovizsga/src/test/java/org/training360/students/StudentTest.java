package org.training360.students;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student student;
    @BeforeEach
    void init() {
        student = new Student("John Doe", LocalDate.of(1989,12,4));
        student.addGradeWithSubject("Math", 4);
        student.addGradeWithSubject("Math", 5);
        student.addGradeWithSubject("History", 5);
    }
    @Test
    void addGradeWithSubject() {
        assertEquals(2, student.getGradesOfSubject("Math").size());
        assertEquals(2, student.getSubjectAndGrades().size());
    }

    @Test
    void countNumberOfGrades() {
        assertEquals(3, student.countNumberOfGrades());
    }
}