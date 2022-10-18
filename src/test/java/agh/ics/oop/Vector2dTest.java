package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testToString() {
        // given:
        Vector2d vector = new Vector2d(5, -1);

        // when:
        String result = vector.toString();

        // then:
        assertEquals(result, "(5, -1)");
    }

    @Test
    void testShouldKnowIfVectorPrecedes() {
        // given:
        Vector2d vector = new Vector2d(5, -1);
        Vector2d vector2 = new Vector2d(4, -3);
        Vector2d vector3 = new Vector2d(6, 7);

        // when:
        boolean result1 = vector.precedes(vector2);
        boolean result2 = vector.precedes(vector3);

        // then:
        assertFalse(result1);
        assertTrue(result2);
    }

    @Test
    void testShouldKnowIfVectorFollows() {
        // given:
        Vector2d vector = new Vector2d(5, -1);
        Vector2d vector2 = new Vector2d(4, -3);
        Vector2d vector3 = new Vector2d(6, 7);

        // when:
        boolean result1 = vector.follows(vector2);
        boolean result2 = vector.follows(vector3);

        // then:
        assertTrue(result1);
        assertFalse(result2);
    }

    @Test
    void testShouldReturnUpperRight() {
        // given:
        Vector2d vector1 = new Vector2d(5, -1);
        Vector2d vector2 = new Vector2d(4, -3);

        // when:
        Vector2d result1 = vector1.upperRight(vector2);

        // then:
        assertEquals(result1, new Vector2d(5, -1));
    }

    @Test
    void testShouldReturnLowerLeft() {
        // given:
        Vector2d vector1 = new Vector2d(3, 2);
        Vector2d vector2 = new Vector2d(41, -4);

        // when:
        Vector2d result1 = vector1.lowerLeft(vector2);

        // then:
        assertEquals(result1, new Vector2d(3, -4));

    }

    @Test
    void testShouldKnowHowToAddVectors() {
        // given:
        Vector2d vector1 = new Vector2d(7, 9);
        Vector2d vector2 = new Vector2d(-2, 10);

        // when:
        Vector2d result1 = vector1.add(vector2);

        // then:
        assertEquals(result1, new Vector2d(5, 19));

    }

    @Test
    void testShouldKnowHowToSubtractVectors() {
        // given:
        Vector2d vector1 = new Vector2d(82, -5);
        Vector2d vector2 = new Vector2d(10, 6);

        // when:
        Vector2d result1 = vector1.subtract(vector2);

        // then:
        assertEquals(result1, new Vector2d(72, -11));
    }

    @Test
    void testEquals() {
        // given:
        Vector2d vector = new Vector2d(-6, 8);
        Vector2d otherVector = new Vector2d(-6, 7);
        Vector2d theSameValuesVector = new Vector2d(-6, 8);

        // when:
        boolean equalToItself = vector.equals(theSameValuesVector);
        boolean notEqualToOther = vector.equals(otherVector);

        //then:
        assertTrue(equalToItself);
        assertNotEquals(vector, null);
        assertFalse(notEqualToOther);
    }

    @Test
    void testShouldReturnOppositeVector() {
        // given:
        Vector2d vector = new Vector2d(6, -5);

        // when:
        Vector2d result1 = vector.opposite();

        // then:
        assertEquals(result1, new Vector2d(-6, 5));
    }
}