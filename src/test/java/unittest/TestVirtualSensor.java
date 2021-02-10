package unittest;

import org.junit.Test;
import sensor.VirtualSensor;
import sensor.VirtualSensorConstant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestVirtualSensor {

    @Test(expected = IllegalArgumentException.class)
    public void testErrorConstructor()
    {
        VirtualSensor s = new VirtualSensor(null);
    }

    @Test
    public void testConstructor()
    {
        VirtualSensor s = new VirtualSensor("Sensor0");
        assertEquals(s.getName(), "Sensor0");
    }

    @Test
    public void testConstructor2()
    {
        VirtualSensor s = new VirtualSensor("Sensor0", 1, 10);
        assertEquals(s.getName(), "Sensor0");
    }

    @Test
    public void testToString()
    {
        VirtualSensor s = new VirtualSensor("Sensor0");
        assertTrue(s.toString().contains("Sensor0"));
    }

}
