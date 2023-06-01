package ru.vbutkov;

import java.util.Arrays;

public class WorkShop {
    public static void main(String[] args) {

        Friend[] friends = {
                new Friend("Vasya", 18, true, 5),
                new Friend("Kate", 19, true, 1),
                new Friend("Dima", 20, true, 7),
                new Friend("Olya", 21, false, 0),
                new Friend("Ira", 22, true, 2),
                new Friend("Natasha", 23, false, 4),
        };

        System.out.println("My friends:" + Arrays.toString(friends));

    }
}