package ru.vbutkov.intro_algorithm;

public class InsertSort {
    public static void sort(int[] values) {

        for (int i = 0; i < values.length; i++) {
            int saveValue = values[i];
            int j;
            for (j = i; (j > 0 && saveValue < values[j - 1]); j--) {
                values[j] = values[j - 1];
            }
            values[j] = saveValue;
        }
    }
}
