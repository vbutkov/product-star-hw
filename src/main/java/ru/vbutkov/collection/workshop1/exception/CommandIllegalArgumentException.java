package ru.vbutkov.collection.workshop1.exception;

public class CommandIllegalArgumentException extends RuntimeException {
    public CommandIllegalArgumentException(String message) {
        super(message);
    }
}
