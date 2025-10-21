import org.junit.Test;

import static org.junit.Assert.*;

public class CodingBatTest {

    @org.junit.Test
    public void sleepIn() {
        CodingBat cb = new CodingBat();
        assertEquals(true, cb.sleepIn(true,true));
        assertEquals(true, cb.sleepIn(false,true));
        assertEquals(true, cb.sleepIn(false,false));
        assertEquals(false, cb.sleepIn(true,false));
    }


    @Test
    public void diff21() {
        CodingBat cb = new CodingBat();
        assertEquals(2, cb.diff21(19));
        assertEquals(11, cb.diff21(10));
        assertEquals(0, cb.diff21(21));
        assertEquals(23, cb.diff21(-2));

    }

    @Test
    public void countEvens() {
        CodingBat cb = new CodingBat();
        assertEquals(3,cb.countEvens(new int[]{2, 1, 2, 3, 4}));
        assertEquals(3,cb.countEvens(new int[]{2, 2, 0}));
        assertEquals(0,cb.countEvens(new int[]{}));
        assertEquals(0,cb.countEvens(new int[]{1,3,5}));
    }

    @Test
    public void helloName() {
        CodingBat cb = new CodingBat();
        assertEquals("Hello Bob!", cb.helloName("Bob"));
        assertEquals("Hello Hello!", cb.helloName("Hello"));
        assertEquals("Hello X!", cb.helloName("X"));
        assertEquals("Hello ho ho ho!", cb.helloName("ho ho ho"));
    }
}