package fr.arolla;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RowTest {

    @ParameterizedTest
    @CsvSource(delimiter = '|', value =
            {
                    "2,0|0,2",
                    "2,0,0|0,0,2",
                    "0,4,0|0,0,4"
            })
    void move_right(String rowContent, String rowExpectedContent) {
        Row row = new Row(rowContent);
        Row right = row.right();
        Assertions.assertThat(right).isEqualTo(new Row(rowExpectedContent));
    }


}
