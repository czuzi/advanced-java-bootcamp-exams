package org.training360.students;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

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
    void saveNewStudent() {
        when(repository.saveNewStudent(any()))
                .thenReturn((student));
        assertEquals("john", service.saveNewStudent(student).getName());
        verify(repository).saveNewStudent(student);
    }

    @Test
    void calculateStudentAverageBySubject() {
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
    void findStudentsWithMoreGradesThan() {

    }
}