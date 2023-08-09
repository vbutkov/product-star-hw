package ru.vbutkov.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

public class Homework1 {
    private static final String COORDINATES = "coordinates.txt";

    public static void main(String[] args) {
        Stream<String> stringStream;
        try {
            stringStream = readFile("./src/main/resources/" + COORDINATES);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        findMaxLengthLineSegment(stringStream);
    }

    private static void findMaxLengthLineSegment(Stream<String> stringStream) {
        Optional<Double> maxLength = stringStream.map(Homework1::getLengthLineSegment)
                .max(Double::compare);

        System.out.println(maxLength.orElseGet(() -> 0.0));
    }

    private static Double getLengthLineSegment(String s) {
        return createLineSegment(s).getLength();
    }

    private static LineSegment createLineSegment(String s) {
        String[] coordinates = s.split(";");
        String[] firstCoordinate = coordinates[0].substring(1, coordinates[0].length() - 1).split(",");
        String[] secondCoordinate = coordinates[1].substring(1, coordinates[1].length() - 1).split(",");

        int x1 = Integer.parseInt(firstCoordinate[0]);
        int x2 = Integer.parseInt(secondCoordinate[0]);
        int y1 = Integer.parseInt(firstCoordinate[1]);
        int y2 = Integer.parseInt(secondCoordinate[1]);

        return new LineSegment(x1, y1, x2, y2);
    }

    private static Stream<String> readFile(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        return bufferedReader.lines();
    }

}

class LineSegment {
    int x1, y1, x2, y2;

    public LineSegment(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getLength() {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}


