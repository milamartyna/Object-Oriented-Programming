package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    OptionsParser parser = new OptionsParser();

    @Test
    void shouldParseCorrectStringArray(){
        String[] onlyCorrect = {"f", "backward", "r", "l", "l"};

        MoveDirection[] onlyCorrectDirections = {
                MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.LEFT
        };

        assertArrayEquals(parser.parse(onlyCorrect).toArray(), onlyCorrectDirections);
    }

    @Test
    void shouldThrowExceptionWhenIncorrectStringArray(){
        String[] someIncorrect = {"tt", "l", "forward", "c", "right", "bt"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parse(someIncorrect));
    }

}