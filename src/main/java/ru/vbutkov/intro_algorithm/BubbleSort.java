package ru.vbutkov.intro_algorithm;

import java.util.Arrays;

public class BubbleSort {

    public static void sort(int[] elements) {
        boolean isSwap;
        for (int i = 0; i < elements.length; i++) {
            isSwap = false;
            for (int j = 0; j < elements.length - 1 - i; j++) {
                if (elements[j] > elements[j + 1]) {
                    swap(elements, j, j + 1);
                    isSwap = true;
                }
            }
            if (!isSwap) break;
        }
    }
    private static void swap(int[] elements, int large, int small) {
        int saveValueByIndex = elements[large];
        elements[large] = elements[small];
        elements[small] = saveValueByIndex;
    }

}
