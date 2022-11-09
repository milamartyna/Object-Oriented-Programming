package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testToString() {
        Vector2d vector = new Vector2d(5, -1);

        String result = vector.toString();

        assertEquals(result, "(5, -1)");
    }

    @Test
    void testShouldKnowIfVectorPrecedes() {
        Vector2d vector = new Vector2d(5, -1);
        Vector2d vector2 = new Vector2d(4, -3);
        Vector2d vector3 = new Vector2d(6, 7);

        boolean result1 = vector.precedes(vector2);
        boolean result2 = vector.precedes(vector3);

        assertFalse(result1);
        assertTrue(result2);
    }

    @Test
    void testShouldKnowIfVectorFollows() {
        Vector2d vector = new Vector2d(5, -1);
        Vector2d vector2 = new Vector2d(4, -3);
        Vector2d vector3 = new Vector2d(6, 7);

        boolean result1 = vector.follows(vector2);
        boolean result2 = vector.follows(vector3);

        assertTrue(result1);
        assertFalse(result2);
    }

    @Test
    void testShouldReturnUpperRight() {
        Vector2d vector1 = new Vector2d(5, -1);
        Vector2d vector2 = new Vector2d(4, -3);

        Vector2d result1 = vector1.upperRight(vector2);

        assertEquals(result1, new Vector2d(5, -1));
    }

    @Test
    void testShouldReturnLowerLeft() {
        Vector2d vector1 = new Vector2d(3, 2);
        Vector2d vector2 = new Vector2d(41, -4);

        Vector2d result1 = vector1.lowerLeft(vector2);

        assertEquals(result1, new Vector2d(3, -4));
    }

    @Test
    void testShouldKnowHowToAddVectors() {
        Vector2d vector1 = new Vector2d(7, 9);
        Vector2d vector2 = new Vector2d(-2, 10);

        Vector2d result1 = vector1.add(vector2);

        assertEquals(result1, new Vector2d(5, 19));
    }

    @Test
    void testShouldKnowHowToSubtractVectors() {
        Vector2d vector1 = new Vector2d(82, -5);
        Vector2d vector2 = new Vector2d(10, 6);

        Vector2d result1 = vector1.subtract(vector2);

        assertEquals(result1, new Vector2d(72, -11));
    }

    @Test
    void testEquals() {
        Vector2d vector = new Vector2d(-6, 8);
        Vector2d otherVector = new Vector2d(-6, 7);
        Vector2d theSameValuesVector = new Vector2d(-6, 8);

        boolean equalToItself = vector.equals(theSameValuesVector);
        boolean notEqualToOther = vector.equals(otherVector);

        assertTrue(equalToItself);
        assertNotEquals(vector, null);
        assertFalse(notEqualToOther);
    }

    @Test
    void testShouldReturnOppositeVector() {
        Vector2d vector = new Vector2d(6, -5);

        Vector2d result1 = vector.opposite();

        assertEquals(result1, new Vector2d(-6, 5));
    }

}