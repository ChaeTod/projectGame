import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sample.Field;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    Field field;
    @BeforeEach
    void setUp() {
        field = new Field();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isWinnder() {
        /*
        Field field = new Field();
        Tile[][] testArr = new Tile[][] {{new Tile(), new Tile(), new Tile(), new Tile(),
                new Tile(), new Tile(), new Tile(), new Tile(),
                new Tile(),new Tile(),new Tile(),new Tile(),
                new Tile(),new Tile(),new Tile(),new Tile()}};
    }

         */
        assertTrue(field.isWinner());
        field.getArr()[1][1].setValue(true);
        assertFalse(field.isWinner());

        for (int i = 0; i < field.getArr().length; i++){
            for (int j = 0; j < field.getArr().length; j++){
                field.getArr()[i][j].setValue(true);
            }
        }
        assertTrue(field.isWinner());

        field.getArr()[3][2].setValue(false);
        assertFalse(field.isWinner());
    }
}