package ru.vbutkov.map.homework1;

import java.util.Comparator;
import java.util.Objects;

public class StudentScoreComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAverageScore() == o2.getAverageScore()) {
            if (!Objects.equals(o1.getName(), o2.getName()))
                return o1.getName().compareTo(o2.getName());
            else
                return o1.getUuid().compareTo(o2.getUuid());
        }

        return Float.compare(o1.getAverageScore(), o2.getAverageScore());
    }
}
