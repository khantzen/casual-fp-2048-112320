package fr.arolla;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Game2048Test {

    @Test
    void single_cell_grid_with_one_by_default() {
        var grid = new Grid(1);
        assertThat(grid.cells[0][0]).isEqualTo(2);
    }

    @Test
    void single_cell_grid_does_not_change() {
        var grid = new Grid(1);

        grid.up();
        assertThat(grid.cells[0][0]).isEqualTo(2);
    }

    @Test
    void grid_of_size_two() {
        var grid = new Grid(2);

        assertThat(grid.cells.length).isEqualTo(2);
        assertThat(grid.cells[0].length).isEqualTo(2);
    }

    @Test
    void should_be_init_with_a_2_in_top_left_corner() {
        var grid = new Grid(2);

        assertThat(grid.cells[0][0]).isEqualTo(2);
    }

    @Test
    void should_not_change_state_when_number_already_at_the_top() {
        var grid = given_a_grid_with_a_two_in_top_left_corner();

        grid.up();

        assertThat(grid.cells[0][0]).isEqualTo(2);
    }

    @Test
    void should_go_down() {
        var grid = given_a_grid_with_a_two_in_top_left_corner();

        grid.down();

        assertThat(grid.cells[0][0]).isEqualTo(0);
        assertThat(grid.cells[0][1]).isEqualTo(0);
        assertThat(grid.cells[1][0]).isEqualTo(2);
        assertThat(grid.cells[1][1]).isEqualTo(0);
    }

    Grid given_a_grid_with_a_two_in_top_left_corner() {
        return new Grid(2);
    }



}
