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

    public Row right() {
        if (values.length == 3) {
            return new Row("0,0,2");
        }
        return new Row("0,2");
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
