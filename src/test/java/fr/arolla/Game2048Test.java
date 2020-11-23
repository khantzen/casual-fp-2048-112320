package fr.arolla;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Game2048Test {

    @Test
    void single_cell_grid_with_one_by_default() {
        var grid = new Grid();
        assertThat(grid.cell).isEqualTo(1);
    }

    @Test
    void single_cell_grid_does_not_change() {
        var grid = new Grid();

        grid.up();
        assertThat(grid.cell).isEqualTo(1);
    }
}
