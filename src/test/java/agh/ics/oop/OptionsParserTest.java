package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    OptionsParser parser = new OptionsParser();

    @Test
    void shouldParseStringArray() {
        String[] onlyCorrect = {"f", "backward", "r", "l", "l"};
        String[] someIncorrect = {"tt", "l", "forward", "c", "right", "bt"};
        String[] onlyIncorrect = {"t", " ", "*", "p", "pack"};

        MoveDirection[] onlyCorrectDirections = {
                MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.LEFT
        };
        MoveDirection[] someIncorrectDirections = {
                MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.RIGHT
        };
        MoveDirection[] onlyIncorrectDirections = {};

        assertArrayEquals(parser.parse(onlyCorrect).toArray(), onlyCorrectDirections);
        assertArrayEquals(parser.parse(someIncorrect).toArray(), someIncorrectDirections);
        assertArrayEquals(parser.parse(onlyIncorrect).toArray(), onlyIncorrectDirections);
    }

}