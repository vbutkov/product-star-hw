package ru.vbutkov.collection.workshop1;

import ru.vbutkov.collection.workshop1.entity.Command;
import ru.vbutkov.collection.workshop1.entity.Student;
import ru.vbutkov.collection.workshop1.facade.StudentStorage;
import ru.vbutkov.collection.workshop1.facade.StudentSurnameStorage;
import ru.vbutkov.collection.workshop1.parser.DataParser;
import ru.vbutkov.collection.workshop1.search.StudentSearch;
import ru.vbutkov.collection.workshop1.search.CommandSearch;
import ru.vbutkov.collection.workshop1.statistics.StudentStatistics;

import java.util.Map;


public class StudentCommandHandler {
    private StudentStorage studentStorage = new StudentStorage();
    private StudentStatistics studentStatistics = new StudentStatistics(studentStorage);
    private StudentSearch studentSearch = new StudentSearch(studentStorage);
    DataParser parser = new DataParser();
    private static final String FIELD_SEPARATOR = ",";

    public void processCommand(Command command) {
        System.out.println("Обрабатавается действие: " + command.getAction() +
                ". Данные: " + command.getData());

        switch (command.getAction()) {
            case CREATE:
                processCreateCommand(command);
                break;
            case UPDATE:
                processUpdateCommand(command);
                break;
            case DELETE:
                processDeleteCommand(command);
                break;
            case STATS_BY_COURSE:
                processStatsByCourseCommand();
                break;
            case STATS_BY_CITY:
                processStatsByCityCommand();
                break;
            case SEARCH:
                processSearchCommand(command);
                break;
            default:
                System.out.println("Неизвестное действие. " + command.getAction());
        }

    }

    private void processSearchCommand(Command command) {
        CommandSearch commandSearch = parser.parsingDataToSearch(command.getData());
        switch (commandSearch.getFilterSearch()) {
            case ALL:
                studentSearch.searchAllStudents();
                break;
            case BY_SURNAME:
                studentSearch.searchBySurname(commandSearch.getData());
                break;
            case BETWEEN_SURNAMES:
                String[] surnames = commandSearch.getData().split(FIELD_SEPARATOR);
                String firstSurname = surnames[0];
                String secondSurname = surnames[1];
                if (secondSurname.compareTo(firstSurname) > 0) {
                    studentSearch.searchBySurnamesBetweenThan(firstSurname, secondSurname);
                }
                System.out.println("Вторая фамилия должна быть больше первой.");
                break;
            default:
                System.out.println("Фильтр " + commandSearch.getFilterSearch() + " не поддерживается.");
        }

    }

    private void processStatsByCityCommand() {
        Map<String, Long> countStudentsByCity = studentStatistics.getCountStudentsByCity();
        studentStatistics.printCountStudentsByCity(countStudentsByCity);
    }

    private void processStatsByCourseCommand() {
        Map<String, Long> countStudentsByCourse = studentStatistics.getCountStudentsByCourse();
        studentStatistics.printCountStudentsByCourse(countStudentsByCourse);
    }

    private void processCreateCommand(Command command) {
        Student student = parser.parsingDataToCreate(command.getData());
        studentStorage.createStudent(student);
        studentStorage.printAll();
    }

    private void processUpdateCommand(Command command) {
        Student student = parser.parsingDataToUpdate(command.getData());
        studentStorage.updateStudent(student.getId(), student);
        studentStorage.printAll();
    }

    private void processDeleteCommand(Command command) {
        Long id = parser.parsingDataToDelete(command.getData());
        studentStorage.deleteStudent(id);
        studentStorage.printAll();
    }
}
