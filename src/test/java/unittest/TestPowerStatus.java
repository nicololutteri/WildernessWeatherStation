package unittest;

import base.PowerStatus;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPowerStatus {

    @Test(expected = IllegalArgumentException.class)
    public void testErrorConstructor1()
    {
        PowerStatus p = new PowerStatus(-1, 0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testErrorConstructor2()
    {
        PowerStatus p = new PowerStatus(0, -1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testErrorConstructor3()
    {
        PowerStatus p = new PowerStatus(0, 0, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testErrorConstructor4() {PowerStatus p = new PowerStatus(-1, -1, -1); }

    @Test
    public void testConstructor()
    {
        PowerStatus p = new PowerStatus(1, 2, 3);

        assertEquals(p.getBatteryPower(), 1, 0);
        assertEquals(p.getSolarPower(), 2, 0);
        assertEquals(p.getWindPower(), 3, 0);
    }

}
