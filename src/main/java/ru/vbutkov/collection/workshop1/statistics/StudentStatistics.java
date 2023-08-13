package ru.vbutkov.collection.workshop1.statistics;

import ru.vbutkov.collection.workshop1.facade.StudentStorage;
import ru.vbutkov.collection.workshop1.entity.Student;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class StudentStatistics {
    StudentStorage studentStorage;

    public StudentStatistics(StudentStorage studentStorage) {
        this.studentStorage = studentStorage;
    }

    public void printCountStudentsByCourse(Map<String, Long> countStudentByCourse) {
        countStudentByCourse.entrySet().stream()
                .forEach(e ->
                        System.out.println(e.getKey() + ": " + e.getValue())
                );
    }

    public void printCountStudentsByCity(Map<String, Long> countStudentByCourse) {
        printCountStudentsByCourse(countStudentByCourse);
    }


    public Map<String, Long> getCountStudentsByCourse() {
        Map<Long, Student> students = studentStorage.getStudentsStorage();

        return students.values().stream().
                collect(toMap(
                        Student::getCourse,
                        s -> 1L,
                        Long::sum)
                );
    }

    public Map<String, Long> getCountStudentsByCity() {
        Map<Long, Student> students = studentStorage.getStudentsStorage();

        return students.values().stream().
                collect(toMap(
                        Student::getCity,
                        s -> 1L,
                        Long::sum)
                );
    }

}
