package unittest;

import base.Constant;
import base.Position;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestPosition {

    Position p;

    @Before
    public void preparation()
    {
        p = new Position(1, 2, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testErrorConstructor() {
        Position p1 = new Position(0, 0, Constant.MaxDepth + 1);
        Position p2 = new Position(0, 0, Constant.MaxDepth - 1);
    }

    @Test
    public void testConstructor() {
        assertEquals(p.getX(), 1, 0);
        assertEquals(p.getY(), 2, 0);
        assertEquals(p.getZ(), 3, 0);
    }

    @Test
    public void testToString() {
        assertTrue(p.toString().contains("1"));
        assertTrue(p.toString().contains("2"));
        assertTrue(p.toString().contains("3"));
    }

}
