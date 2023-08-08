package ru.vbutkov.map.homework1;

import java.util.*;

public class ResultsBoard {
    TreeMap<Student, Float> studentAverageScores = new TreeMap(new StudentScoreComparator());
    private final int TOP_AVERAGE_SCORES_STUDENT = 3;

    public void addStudent(String name, Float averageScore) {
        Student newStudent = new Student(name, averageScore);
        studentAverageScores.put(newStudent, averageScore);
    }

    List<String> findStudentNameTop3AverageScores() {
        System.out.println(studentAverageScores);
        NavigableMap<Student, Float> descendingStudentAverageScores = studentAverageScores.descendingMap();
        System.out.println(descendingStudentAverageScores);
        int count = 0;
        List<String> top3AverageScoreStudents = new ArrayList<>();
        for (Student student : descendingStudentAverageScores.keySet()) {
            top3AverageScoreStudents.add(student.getName());
            count++;
            if (count >= TOP_AVERAGE_SCORES_STUDENT) break;
        }

        return top3AverageScoreStudents;
    }
}

