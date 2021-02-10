package unittest;

import base.Dimension;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestDimension {

    Dimension d;

    @Before
    public void preparation()
    {
        d = new Dimension(1, 2, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testErrorConstructor() {
        Dimension d = new Dimension(-1, 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testErrorConstructor2()
    {
        Dimension s = new Dimension(1, -1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testErrorConstructor3()
    {
        Dimension s = new Dimension(1, 1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testErrorConstructor4()
    {
        Dimension s = new Dimension(-1, -1, -1);
    }

    @Test
    public void testConstructor()
    {
        Assert.assertEquals(d.getWidth(), 1, 0);
        Assert.assertEquals(d.getLength(), 2, 0);
        Assert.assertEquals(d.getDepth(), 3, 0);
    }

    @Test
    public void testToString()
    {
        assertTrue(d.toString().contains("1"));
        assertTrue(d.toString().contains("2"));
        assertTrue(d.toString().contains("3"));
    }

}
