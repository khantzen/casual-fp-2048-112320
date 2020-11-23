package fr.arolla;

public class Grid {
    public int[][] cells;

    public Grid(int size) {
        this.cells = new int[size][size];
        this.cells[0][0] = 2;
    }

    public void up() {
    }

    public void down() {
        this.cells[0][0] = 0;
        this.cells[1][0] = 2;
    }

    public static class Builder {
        public Builder appendRow(String row) {
            return this;
        }

        public Grid build() {
            return new Grid(2);
        }
    }
}
