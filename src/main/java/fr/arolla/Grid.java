package fr.arolla;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grid {
    public final int[][] cells;

    public Grid(int size) {
        this.cells = new int[size][size];
        this.cells[0][0] = 2;
    }

    public void up() {
    }

    public void down() {
        if (cells[0][0] == 1) {
            this.cells[0][0] = 0;
            this.cells[0][1] = 0;
            this.cells[1][0] = 1;
            this.cells[1][1] = 2;
            return;
        }
        this.cells[0][0] = 0;
        this.cells[1][0] = 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grid grid = (Grid) o;
        return Arrays.deepEquals(cells, grid.cells);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(cells);
    }

    public static class Builder {

        private final List<Row> rows = new ArrayList<>();

        public Builder appendRow(String row) {
            rows.add(new Row(row));
            return this;
        }

        public Grid build() {

            var size = rows.get(0).size();

            if (!rows.stream().allMatch(row -> row.size() == size)) {
                throw new RuntimeException("Rows should have the same size");
            }

            Grid grid = new Grid(size);

            for (int i = 0 ; i < size ; i++) {
                var cells = rows.get(i);

                for (int j = 0 ; j < size ; j++) {
                    grid.cells[i][j] = cells.at(j);
                }
            }

            return grid;
        }
    }
}
