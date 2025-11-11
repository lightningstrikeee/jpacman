package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 * Tests for the Board class to verify its invariant and behavior of squareAt().
 */
class BoardTest {

    /**
     * Test case 1: A valid 1x1 board containing a BasicSquare.
     * Should pass and return the correct square.
     */
    @Test
    void testValidBoardSquareAt() {
        // Arrange
        Square[][] grid = new Square[1][1];
        grid[0][0] = new BasicSquare();

        // Act
        Board board = new Board(grid);

        // Assert
        assertThat(board).isNotNull();
        assertThat(board.getWidth()).isEqualTo(1);
        assertThat(board.getHeight()).isEqualTo(1);
        assertThat(board.squareAt(0, 0)).isEqualTo(grid[0][0]);
    }

    /**
     * Test case 2: An invalid board containing a null square.
     * This should fail because of the Board invariant assertion.
     */
   /* @Test
    void testInvalidBoardSquareAt() {
        // Arrange
        Square[][] grid = new Square[1][1];
        grid[0][0] = null; // invalid square

        // Act & Assert
        Board board = new Board(grid); // <-- This line triggers an AssertionError
        // (you’ll never reach here unless assertions are disabled)
        board.squareAt(0, 0);
    }*/
}
