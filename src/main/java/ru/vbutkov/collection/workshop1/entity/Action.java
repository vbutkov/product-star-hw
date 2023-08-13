package ru.vbutkov.collection.workshop1.entity;

import java.util.stream.Stream;

public enum Action {
    EXIT(0, false),
    CREATE(1, true),
    UPDATE(2, true),
    DELETE(3, true),
    STATS_BY_COURSE(4, false),
    STATS_BY_CITY(5, false),
    SEARCH(6, true),
    ERROR(-1, false);

    private Integer code;
    private boolean requiredAdditionData;

    Action(Integer code, boolean requiredAdditionData) {
        this.code = code;
        this.requiredAdditionData = requiredAdditionData;
    }

    public static Action fromCode(Integer actionCode) {
        return Stream.of(values())
                .filter(action -> action.code.equals(actionCode))
                .findFirst()
                .orElseGet(() -> {
                            System.out.println("Неизвестный код действия.");
                            return Action.ERROR;
                        }
                );
    }

    public Integer getCode() {
        return code;
    }

    public boolean isRequiredAdditionData() {
        return requiredAdditionData;
    }

    public void help(Integer actionCode) {
        switch (actionCode) {
            case 1:
                System.out.println("-----------Создание данных------------");
                System.out.println("Введите данные о студенте. Данные вводятся в одну строку через символ разделителя: ','." +
                        "\n Первый параметр - Фамилия; - далее ','" +
                        "\n Второй параметр - Имя; - далее ','" +
                        "\n Третий параметр - Курс; - далее ','" +
                        "\n Четвертый параметр - Город; - далее ','" +
                        "\n Пятый параметр - Возраст; - далее 'Enter'");
                System.out.println("---------------------------------------");
                break;
            case 2:
                System.out.println("---------Обновление данных------------");
                System.out.println("Введите новые данные о студенте. " +
                        "\n Данные вводятся в одну строку через символ разделителя: ','." +
                        "\n Первый параметр - id студента; - далее ','" +
                        "\n Второй параметр - Фамилия; - далее ','" +
                        "\n Третий параметр - Имя; - далее ','" +
                        "\n Четвертый параметр - Курс; - далее ','" +
                        "\n Пятый параметр - Город; - далее ','" +
                        "\n Шестой параметр - Возраст; - далее 'Enter'");
                System.out.println("---------------------------------------");
                break;
            case 3:
                System.out.println("---------Удаление данных------------");
                System.out.println("Введите id студента. " +
                        "\n Параметр - id студента; - далее 'Enter'");
                System.out.println("---------------------------------------");
                break;
            case 6:
                System.out.println("---------Поиск по фамилии------------");
                System.out.println("\n Доступно несколько вариантов поиска. " +
                        "\n 1. Нет параметров. Результат: список всех студентов." +
                        "\n 2. Введите фамилию студента. Результат: точное совпадение по фамилии." +
                        "\n 3. Введите две фамилии, в одну строку через символ разделителя: ','. " +
                        "\n Результат: точное совпадение по фамилии.");
                System.out.println("---------------------------------------");
                break;

        }
    }
}
