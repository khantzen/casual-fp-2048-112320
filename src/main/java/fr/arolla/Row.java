package fr.arolla;

import java.util.Arrays;

public class Row {

    private int[] values;

    public Row(String row) {
        this.values = Arrays.stream(row.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public int at(int index) {
        return values[index];
    }

    public int size() {
        return values.length;
    }
}
