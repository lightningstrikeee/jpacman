package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Test cases for Direction enum.
 *
 * Using Input Space Partitioning:
 * - Vertical movement (NORTH, SOUTH)
 * - Horizontal movement (EAST, WEST)
 */
public class DirectionTest {

    /**
     * NORTH should move one step up: Δx = 0, Δy = -1.
     */
    @Test
    void testNorth() {
        Direction north = Direction.valueOf("NORTH");
        assertThat(north.getDeltaX()).isEqualTo(0);
        assertThat(north.getDeltaY()).isEqualTo(-1);
    }

    /**
     * SOUTH should move one step down: Δx = 0, Δy = +1.
     */
    @Test
    void testSouth() {
        Direction south = Direction.valueOf("SOUTH");
        assertThat(south.getDeltaX()).isEqualTo(0);
        assertThat(south.getDeltaY()).isEqualTo(1);
    }

    /**
     * EAST should move one step right: Δx = +1, Δy = 0.
     */
    @Test
    void testEast() {
        Direction east = Direction.valueOf("EAST");
        assertThat(east.getDeltaX()).isEqualTo(1);
        assertThat(east.getDeltaY()).isEqualTo(0);
    }

    /**
     * WEST should move one step left: Δx = -1, Δy = 0.
     */
    @Test
    void testWest() {
        Direction west = Direction.valueOf("WEST");
        assertThat(west.getDeltaX()).isEqualTo(-1);
        assertThat(west.getDeltaY()).isEqualTo(0);
    }
}
