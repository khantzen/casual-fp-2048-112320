package fr.arolla;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GridBuilderTest {

    @Test
    void should_build_a_grid() {
        Grid grid = new Grid
                .Builder()
                .appendRow("1,2")
                .appendRow("3,4")
                .build();

        assertThat(grid.cells[0][0]).isEqualTo(1);
        assertThat(grid.cells[0][1]).isEqualTo(2);
        assertThat(grid.cells[1][0]).isEqualTo(3);
        assertThat(grid.cells[1][1]).isEqualTo(4);
    }
}
