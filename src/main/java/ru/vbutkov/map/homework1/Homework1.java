package ru.vbutkov.map.homework1;

import java.util.List;

public class Homework1 {
    public static void main(String[] args) {
        ResultsBoard resultsBoard = new ResultsBoard();

        resultsBoard.addStudent("Anna", 4.9f);
        resultsBoard.addStudent("Masha", 4.9f);
        resultsBoard.addStudent("Sveta", 3.7f);
        resultsBoard.addStudent("Misha", 4.4f);
        resultsBoard.addStudent("Ira", 4.5f);
        resultsBoard.addStudent("Nikita", 4.0f);
        resultsBoard.addStudent("Anna", 4.9f);

        List<String> top3AverageScores = resultsBoard.findStudentNameTop3AverageScores();
        System.out.println(top3AverageScores);
    }
}
