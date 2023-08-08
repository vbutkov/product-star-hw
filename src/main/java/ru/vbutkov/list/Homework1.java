package ru.vbutkov.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Homework1 {

    public static void main(String[] args) {
        ArrayList<Integer> listIntegers = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 10));
        int k = 3;

        List<Double> rollingAverage = getRollingAverage(listIntegers, k);
        System.out.println(rollingAverage);
    }

    public static List<Double> getRollingAverage(ArrayList<Integer> listIntegers, int k) {
        List<List<Integer>> listSubLists = getSubList(listIntegers, k);
        List<Double> listAverageValues = new ArrayList<>();

        for (List<Integer> list : listSubLists) {
            double summa = 0.0;
            for (int i = 0; i < list.size(); i++) {
                summa += list.get(i);
            }
            double average = summa / list.size();
            listAverageValues.add(average);
        }
        return listAverageValues;
    }

    private static List<List<Integer>> getSubList(ArrayList<Integer> listIntegers, int k) {
        List<List<Integer>> listSubLists = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            list.add(listIntegers.get(i));
        }
        listSubLists.add(new LinkedList<>(list));

        for (int i = k; i < listIntegers.size(); i++) {
            list.add(listIntegers.get(i));
            list.remove();
            listSubLists.add(new LinkedList<>(list));
        }

        return listSubLists;
    }


    public static void myFunc() {
        int a = 5;
        int b = 10;


    }


}
