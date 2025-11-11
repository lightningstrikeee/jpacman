package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.PacmanConfigurationException;
import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.npc.ghost.Blinky;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * This is a test class for MapParser.
 */
@ExtendWith(MockitoExtension.class)
public class MapParserTest {

    @Mock
    private BoardFactory boardFactory;

    @Mock
    private LevelFactory levelFactory;

    @Mock
    private Blinky blinky;

    /**
     * Test for the parseMap method (good map).
     */
    @Test
    public void testParseMapGood() {
        MockitoAnnotations.initMocks(this);
        assertNotNull(boardFactory);
        assertNotNull(levelFactory);
        Mockito.when(levelFactory.createGhost()).thenReturn(blinky);
        MapParser mapParser = new MapParser(levelFactory, boardFactory);
        ArrayList<String> map = new ArrayList<>();
        map.add("############");
        map.add("#P        G#");
        map.add("############");
        mapParser.parseMap(map);
        Mockito.verify(levelFactory, Mockito.times(1)).createGhost();
        Mockito.verify(boardFactory, Mockito.atLeastOnce()).createGround();
        Mockito.verify(boardFactory, Mockito.atLeastOnce()).createWall();
        Mockito.verify(levelFactory, Mockito.times(1)).createLevel(Mockito.any(), Mockito.anyList(), Mockito.anyList());
        Mockito.verify(boardFactory, Mockito.times(1)).createBoard(Mockito.any(Square[][].class));
    }

    /**
     * Test for the parseMap method (bad map).
     */
    @Test
    public void testParseMapWrong1() {
        PacmanConfigurationException thrown =
            org.junit.jupiter.api.Assertions.assertThrows(
                PacmanConfigurationException.class, () -> {

                    MockitoAnnotations.initMocks(this);
                    assertNotNull(boardFactory);
                    assertNotNull(levelFactory);

                    MapParser mapParser = new MapParser(levelFactory, boardFactory);

                    ArrayList<String> map = new ArrayList<>();
                    map.add("#####");
                    map.add("###");
                    mapParser.parseMap(map);
                });

        org.junit.jupiter.api.Assertions.assertTrue(
            thrown.getMessage().contains("equal width")
                || thrown.getMessage().contains("Invalid character")
                || thrown.getMessage().contains("Input text"),
            "Unexpected error message: " + thrown.getMessage()
        );
    }
}
