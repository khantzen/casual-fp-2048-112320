package fr.arolla;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Integer> newValues = Arrays.stream(values)
                .filter(x -> x != 0)
                .boxed()
                .collect(Collectors.toList());

        Collections.reverse(newValues);
        List<Integer> mergedValues = new ArrayList<>();
        if (newValues.size() == 1) {
            mergedValues = newValues;
        } else {
            for (int i = 0; i < newValues.size(); i++) {
                if (i!= newValues.size() - 1 && newValues.get(i).equals(newValues.get(i + 1))) {
                    mergedValues.add(newValues.get(i) * 2);
                    i++;
                } else {
                    mergedValues.add(newValues.get(i));
                }
            }
        }
        int zeroesToAdd = values.length - mergedValues.size();
        for (int i = 0; i < zeroesToAdd; i++) {
            mergedValues.add(0);
        }

        Collections.reverse(mergedValues);

        return new Row(mergedValues.stream().map(String::valueOf).collect(Collectors.joining(",")));
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
