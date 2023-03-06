package org.training360.students;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    StudentRepository repository;

    @InjectMocks
    StudentService service;

    Student student;

    @BeforeEach
    void init() {
        student = new Student("john", LocalDate.of(1989,12,4));
    }

    @Test
    void testSaveNewStudent() {
        when(repository.saveNewStudent(any()))
                .thenReturn((student));
        assertEquals("john", service.saveNewStudent(student).getName());
        verify(repository).saveNewStudent(student);
    }

    @Test
    void testCalculateStudentAverageBySubject() {
        student.addGradeWithSubject("Math", 2);
        student.addGradeWithSubject("Math", 5);
        student.addGradeWithSubject("History", 5);
        when(repository.findStudentByName(anyString()))
                .thenReturn(Optional.of(student));
        when(repository.findStudentByName("not exist")).thenReturn(Optional.empty());
        assertEquals(3.5, service.calculateStudentAverageBySubject("john", "Math"));
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> service.calculateStudentAverageBySubject("not exist", "History"));
        assertEquals("Cannot find student with this name: not exist", iae.getMessage());
        verify(repository).findStudentByName("not exist");
        verify(repository).findStudentByName("john");
    }

    @Test
    void testFindStudentsWithMoreGradesThan() {
        student.addGradeWithSubject("Math", 2);
        student.addGradeWithSubject("Math", 5);
        student.addGradeWithSubject("History", 5);
        Student student2 = new Student("Jane", LocalDate.of(1992, 1,4));
        student2.addGradeWithSubject("Math", 4);
        student2.addGradeWithSubject("Math", 3);
        student2.addGradeWithSubject("History", 5);
        student2.addGradeWithSubject("History", 2);
        when(repository.findAllStudents()).thenReturn(List.of(student, student2));
        List<Student> students = service.findStudentsWithMoreGradesThan(2);
        assertThat(students)
                .hasSize(2)
                .extracting(Student::getName)
                .contains("john", "Jane");
    }
}