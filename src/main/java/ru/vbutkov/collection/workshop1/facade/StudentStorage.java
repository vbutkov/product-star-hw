package ru.vbutkov.collection.workshop1.facade;

import ru.vbutkov.collection.workshop1.entity.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentStorage {
    private Map<Long, Student> studentsStorage = new HashMap<>();
    private StudentSurnameStorage studentsSurnameStorage = new StudentSurnameStorage();
    private Long id = 1L;

    public Long createStudent(Student student) {
        Long nextId = getNextId();
        studentsStorage.put(nextId, student);
        studentsSurnameStorage.studentCreated(nextId, student.getSurname());
        return nextId;
    }

    public boolean updateStudent(Long id, Student student) {
        if (!studentsStorage.containsKey(id)) {
            return false;
        }
        studentsStorage.put(id, student);
        Student studentUpdated = studentsStorage.get(id);
        studentsSurnameStorage.studentUpdated(id, studentUpdated.getSurname(), student.getSurname());
        return true;
    }

    public boolean deleteStudent(Long id) {
        Student maybeRemoveStudent = studentsStorage.remove(id);
        if (maybeRemoveStudent != null) {
            studentsSurnameStorage.studentDeleted(id, maybeRemoveStudent.getSurname());
            return true;
        }
        return false;
    }

    public StudentSurnameStorage getStudentsSurnameStorage() {
        return studentsSurnameStorage;
    }

    private Long getNextId() {
        return id++;
    }

    public void printAll() {
        System.out.println(studentsStorage);
    }

    public Map<Long, Student> getStudentsStorage() {
        return studentsStorage;
    }
}
