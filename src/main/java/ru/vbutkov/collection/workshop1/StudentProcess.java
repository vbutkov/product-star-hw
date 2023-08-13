package ru.vbutkov.collection.workshop1;

import ru.vbutkov.collection.workshop1.entity.Action;
import ru.vbutkov.collection.workshop1.entity.Command;
import ru.vbutkov.collection.workshop1.exception.CommandIllegalArgumentException;

import java.util.Scanner;

public class StudentProcess {
    private static StudentCommandHandler STUDENT_COMMAND_HANDLER = new StudentCommandHandler();

    public static void main(String[] args) {


        while (true) {
            try {
                printMessage();
                Command command = readCommand();
                if (isCommandExit(command))
                    break;
                else
                    STUDENT_COMMAND_HANDLER.processCommand(command);
            } catch (CommandIllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static boolean isCommandExit(Command command) {
        return command.getAction().equals(Action.EXIT);
    }

    private static Command readCommand() {
        Scanner scanner = new Scanner(System.in);
        try {
            String code = scanner.nextLine();
            Integer actionCode = Integer.valueOf(code);
            Action selectAction = Action.fromCode(actionCode);

            String data = null;
            if (selectAction.isRequiredAdditionData()) {
                selectAction.help(actionCode);
                data = scanner.nextLine();
            }
            return new Command(selectAction, data);

        } catch (Exception ex) {
            System.out.println("Ошибка обработки ввода. " + ex.getMessage());
            return new Command(Action.ERROR);
        }
    }

    private static void printMessage() {
        System.out.println("---------------------------------------");
        System.out.println("0. Выход");
        System.out.println("1. Создание данных");
        System.out.println("2. Обновление данных");
        System.out.println("3. Удаление данных");
        System.out.println("4. Вывод статискики по курсам");
        System.out.println("5. Вывод статискики по городам");
        System.out.println("6. Поиск по фамилии");
        System.out.println("---------------------------------------");
    }

}
