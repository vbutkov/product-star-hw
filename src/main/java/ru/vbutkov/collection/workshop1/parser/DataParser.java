package ru.vbutkov.collection.workshop1.parser;

import ru.vbutkov.collection.workshop1.entity.Student;
import ru.vbutkov.collection.workshop1.exception.CommandIllegalArgumentException;
import ru.vbutkov.collection.workshop1.search.FilterSearch;
import ru.vbutkov.collection.workshop1.search.CommandSearch;

public class DataParser {
    private static final String FIELD_SEPARATOR = ",";
    private static final int COUNT_PARAM_FOR_CREATE = 5;
    private static final int COUNT_PARAM_FOR_UPDATE = 6;
    private static final int COUNT_MAX_PARAM_FOR_SEARCH = 2;
    private static final int COUNT_MIN_PARAM_FOR_SEARCH = 0;

    public Student parsingDataToCreate(String data) {
        emptyData(data);
        String[] params = getParams(data);
        checkCountParam(params, COUNT_PARAM_FOR_CREATE);

        return createStudent(params);
    }

    public Student parsingDataToUpdate(String data) {
        emptyData(data);
        String[] params = getParams(data);
        checkCountParam(params, COUNT_PARAM_FOR_UPDATE);

        Long id = parseId(params[0]);
        String[] paramForUpdate = new String[]{params[1], params[2], params[3], params[4], params[5]};

        Student student = createStudent(paramForUpdate);
        student.setId(id);

        return student;
    }

    public Long parsingDataToDelete(String data) {
        emptyData(data);

        return parseId(data);
    }

    public CommandSearch parsingDataToSearch(String data) {
        if (data.isEmpty() || data.isBlank())
            return new CommandSearch(FilterSearch.ALL);

        String[] params = data.split(FIELD_SEPARATOR);
        String firstSurname = params[0];

        if (params.length == COUNT_MAX_PARAM_FOR_SEARCH) {
            String secondSurname = params[1];
            StringBuilder sb = new StringBuilder(firstSurname)
                    .append(FIELD_SEPARATOR)
                    .append(secondSurname);
            return new CommandSearch(FilterSearch.BETWEEN_SURNAMES, sb.toString());
        }

        return new CommandSearch(FilterSearch.BY_SURNAME, firstSurname);
    }

    private Student createStudent(String[] params) {
        String surname = params[0];
        String name = params[1];
        String course = params[2];
        String city = params[3];
        Integer age = parseAge(params[4]);

        return new Student(surname, name, course, city, age);
    }

    private static void checkCountParam(String[] params, int count) {
        if (params.length < count) {
            throw new CommandIllegalArgumentException("Недостаточно данных. Повторите ввод.");
        } else if (params.length > count) {
            throw new CommandIllegalArgumentException("Данных больше, чем необходимо. Повторите ввод.");
        }
    }

    private String[] getParams(String data) {
        if (!data.contains(FIELD_SEPARATOR)) {
            throw new CommandIllegalArgumentException("Не верный формат разделения данных. Повторите ввод.");
        }

        return data.split(FIELD_SEPARATOR);
    }

    private void emptyData(String data) {
        if (data.isBlank() || data.isEmpty())
            throw new CommandIllegalArgumentException("Нет данных. Повторите ввод.");
    }

    private Long parseId(String s) {
        Long id;
        try {
            id = Long.parseLong(s);
        } catch (Exception ex) {
            throw new CommandIllegalArgumentException("ID студента не может быть строкой. Повторите ввод.");
        }

        return id;
    }

    private Integer parseAge(String s) {
        Integer age;
        try {
            age = Integer.parseInt(s);
        } catch (Exception ex) {
            throw new CommandIllegalArgumentException("Возраст студента не может быть строкой. Повторите ввод.");
        }

        return age;
    }


}
