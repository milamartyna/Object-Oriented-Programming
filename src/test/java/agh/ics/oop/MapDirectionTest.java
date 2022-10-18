package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    @Test
    void testShouldReturnNextDirection() {
        assertEquals(MapDirection.EAST.next(), MapDirection.SOUTH);
        assertEquals(MapDirection.SOUTH.next(), MapDirection.WEST);
        assertEquals(MapDirection.WEST.next(), MapDirection.NORTH);
        assertEquals(MapDirection.NORTH.next(), MapDirection.EAST);
    }

    @Test
    void testShouldReturnPreviousDirection() {
        assertEquals(MapDirection.EAST.previous(), MapDirection.NORTH);
        assertEquals(MapDirection.NORTH.previous(), MapDirection.WEST);
        assertEquals(MapDirection.WEST.previous(), MapDirection.SOUTH);
        assertEquals(MapDirection.SOUTH.previous(), MapDirection.EAST);
    }
}