package fr.arolla;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        List<Integer> newValues = IntStream.concat(
                Arrays.stream(values).filter(x -> x == 0),
                Arrays.stream(values).filter(x -> x != 0)
        ).boxed().collect(Collectors.toList());

        for (int i = 0; i < newValues.size(); i++) {

        }

        return new Row(newValues.stream().map(String::valueOf).collect(Collectors.joining(",")));
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
