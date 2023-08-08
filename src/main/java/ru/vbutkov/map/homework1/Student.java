package ru.vbutkov.map.homework1;

import java.util.UUID;

public class Student {

    private String uuid;
    private String name;
    private float averageScore;

    public Student(String name, float averageScore) {
        this.name = name;
        this.averageScore = averageScore;
        this.uuid = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public float getAverageScore() {
        return averageScore;
    }

    public String getUuid() {
        return uuid;
    }

}
