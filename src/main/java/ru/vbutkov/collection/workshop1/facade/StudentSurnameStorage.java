package ru.vbutkov.collection.workshop1.facade;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

import static java.util.stream.Collectors.*;

public class StudentSurnameStorage {
    private TreeMap<String, Set<Long>> studentSurnames = new TreeMap<>();

    public void studentCreated(Long id, String surname) {
        Set<Long> existingStudentsId = studentSurnames.getOrDefault(surname, new HashSet<>());
        existingStudentsId.add(id);
        studentSurnames.put(surname, existingStudentsId);
    }

    public void studentDeleted(Long id, String surname) {
        studentSurnames.get(surname).remove(id);
    }

    public void studentUpdated(Long id, String oldSurname, String newSurname) {
        studentDeleted(id, oldSurname);
        studentCreated(id, newSurname);
    }

    public Set<Long> getStudentsIdBySurnameLessOrEqualThan(String surname) {
        return studentSurnames.headMap(surname, true).values()
                .stream()
                .flatMap(Collection::stream)
                .collect(toSet());
    }

    public Set<Long> getStudentsIdBetweenSurnames(String firstSurname, String secondSurname) {
        return studentSurnames.subMap(firstSurname, true, secondSurname, true).values()
                .stream()
                .flatMap(Collection::stream)
                .collect(toSet());
    }

    public Set<Long> getStudentsIdBySurname(String surname) {
        Set<Long> maybeStudentsID = studentSurnames.get(surname);
        if (maybeStudentsID == null) return Set.of();
        return maybeStudentsID;
    }
}
