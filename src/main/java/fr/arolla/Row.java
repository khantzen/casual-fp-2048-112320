package fr.arolla;

import java.util.Arrays;

public class Row {

    private final int[] values;

    public Row(String row) {
        this.values = Arrays.stream(row.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public int at(int index) {
        return values[index];
    }

    public int size() {
        return values.length;
    }

    public Row right() {
        int lineLength = values.length;
        int[] nextValues = new int[lineLength];
        long zeroes = Arrays.stream(values).filter(x -> x == 0).count();
        int counter = 0;
        for (int i = values.length - 1; i >= 0; i--) {
            int value = values[i];
            if (value != 0) {
                nextValues[lineLength - counter - 1] = value;
                ++counter;
            }
        }
        for (int i = 0; i < zeroes; i++) {
            nextValues[i] = 0;
        }
        return new Row(Arrays.toString(nextValues).replaceAll("\\[|]", ""));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Row row = (Row) o;
        return Arrays.equals(values, row.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }

    @Override
    public String toString() {
        return "Row{" +
                "values=" + Arrays.toString(values) +
                '}';
    }
}
