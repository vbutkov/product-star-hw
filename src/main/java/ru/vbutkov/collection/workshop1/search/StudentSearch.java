package ru.vbutkov.collection.workshop1.search;

import ru.vbutkov.collection.workshop1.facade.StudentStorage;
import ru.vbutkov.collection.workshop1.facade.StudentSurnameStorage;
import ru.vbutkov.collection.workshop1.entity.Student;

import java.util.Map;
import java.util.Set;

public class StudentSearch {
    StudentStorage studentStorage;
    StudentSurnameStorage studentSurnameStorage;

    public StudentSearch(StudentStorage studentStorage) {
        this.studentStorage = studentStorage;
        this.studentSurnameStorage = studentStorage.getStudentsSurnameStorage();
    }

    public void searchBySurnamesBetweenThan(String firstSurname, String secondSurname) {
        Map<Long, Student> students = studentStorage.getStudentsStorage();

        Set<Long> studentsId = studentSurnameStorage.getStudentsIdBetweenSurnames(firstSurname, secondSurname);
        studentsId.stream()
                .forEach(studentId -> {
                    Student student = students.get(studentId);
                    System.out.println(student);
                });

    }

    public void searchBySurname(String surname) {
        Map<Long, Student> students = studentStorage.getStudentsStorage();
        Set<Long> studentsId = studentSurnameStorage.getStudentsIdBySurname(surname);
        studentsId.stream()
                .forEach(studentId -> {
                    Student student = students.get(studentId);
                    System.out.println(student);
                });
    }

    public void searchAllStudents() {
        Map<Long, Student> students = studentStorage.getStudentsStorage();
        students.values().forEach(
                student -> System.out.println(student)
        );
    }
}
