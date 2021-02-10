package unittest;

import org.junit.Test;
import sensor.SensorValue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestSensorValue {

    @Test(expected = IllegalArgumentException.class)
    public void testErrorConstructor()
    {
        SensorValue s = new SensorValue("", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testErrorConstructor2()
    {
        SensorValue s = new SensorValue(null, "Test");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testErrorConstructor3()
    {
        SensorValue s = new SensorValue("Name", null);
    }

    @Test
    public void testConstructor()
    {
        SensorValue s = new SensorValue("Sensor0", 2);

        assertEquals(s.getName(), "Sensor0");
        assertEquals(s.getData(), 2);
    }

    @Test
    public void testToString()
    {
        SensorValue s = new SensorValue("Sensor0", 1);

        assertTrue(s.toString().contains("Sensor0"));
        assertTrue(s.toString().contains("1"));
    }

}
