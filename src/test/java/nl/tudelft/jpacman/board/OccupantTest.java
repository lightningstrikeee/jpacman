package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that Units correctly (de)occupy squares.
 */
class OccupantTest {

    private Unit unit;

    /**
     * Sets up a new BasicUnit before each test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Tests that the occupant is initialized correctly (no starting square).
     */
    @Test
    void noStartSquare() {
        assertThat(unit.hasSquare()).isFalse();
    }

    /**
     * Test that the unit correctly occupies a square.
     */
    @Test
    void testOccupy() {
        Square target = new BasicSquare();
        unit.occupy(target);

        assertThat(unit.getSquare()).isEqualTo(target);
        assertThat(target.getOccupants()).contains(unit);
    }

    /**
     * Test that the unit correctly reoccupies a new square.
     */
    @Test
    void testReoccupy() {
        Square first = new BasicSquare();
        Square second = new BasicSquare();

        unit.occupy(first);
        unit.occupy(second);

        assertThat(unit.getSquare()).isEqualTo(second);
        assertThat(first.getOccupants()).doesNotContain(unit);
        assertThat(second.getOccupants()).contains(unit);
    }
}
