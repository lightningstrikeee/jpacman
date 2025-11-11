package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that Units correctly (de)occupy squares.
 */
class OccupantTest {

    private Unit unit;

    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Tests that the occupant is initialized correctly.
     */
    @Test
    void noStartSquare() {
        assertThat(unit.hasSquare()).isFalse();
    }

    /**
     * After occupying a square, the unit should be assigned to that square,
     * and the square should list the unit as an occupant.
     */
    @Test
    void testOccupy() {
        Square target = new BasicSquare();
        unit.occupy(target);

        assertThat(unit.getSquare()).isEqualTo(target);
        assertThat(target.getOccupants()).contains(unit);
    }

    /**
     * If the unit moves to a new square, it should no longer occupy the old one.
     * Only the new square should contain the unit.
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
