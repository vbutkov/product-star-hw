package ru.vbutkov.into_algorithm;

import org.junit.jupiter.api.Test;
import ru.vbutkov.intro_algorithm.InsertSort;

import java.util.Arrays;
import java.util.Random;

import static java.lang.System.currentTimeMillis;
import static org.junit.jupiter.api.Assertions.*;

class InsertSortTest {

    @Test
    void checkSortAndElapsedTime() {
        int[] randomValues = new Random().ints(3_000, 0, 100).toArray();
        int[] copyRandomValues = Arrays.copyOf(randomValues, randomValues.length);

        long startTime = currentTimeMillis();
        InsertSort.sort(copyRandomValues);
        System.out.println("Bubble sort elapsed time: " + (currentTimeMillis() - startTime) + "ms");

        startTime = currentTimeMillis();
        Arrays.sort(randomValues);
        System.out.println("Arrays.sort elapsed time: " + (currentTimeMillis() - startTime) + "ms");

        assertArrayEquals(randomValues, copyRandomValues);
    }
}