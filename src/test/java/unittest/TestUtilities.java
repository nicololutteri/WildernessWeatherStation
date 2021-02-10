package unittest;

import base.Utilities;
import org.junit.Test;
import sensor.SensorValue;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class TestUtilities {

    @Test(expected = IllegalArgumentException.class)
    public void testErrorPrintMyInfo()
    {
        String s = Utilities.printMyInfo(null);
    }

    @Test
    public void testPrintMyInfo()
    {
        String s = Utilities.printMyInfo(new SensorValue[] {});

        assertEquals(s, "");
    }

    @Test
    public void testPrintMyInfo2()
    {
        SensorValue[] arr = new SensorValue[] {new SensorValue("Sensor0", 1),
                new SensorValue("Sensor1", 2)};

        String s = Utilities.printMyInfo(arr);

        assertTrue(s.contains("Sensor0"));
        assertTrue(s.contains("Sensor1"));
        assertTrue(s.contains("1"));
        assertTrue(s.contains("2"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testErrorPrintMyInfoArray()
    {
        String s = Utilities.printMyInfoArray(null);
    }

    @Test
    public void testPrintMyInfoArray()
    {
        List<SensorValue[]> list = new ArrayList<>();
        SensorValue[] list2 = new SensorValue[] {};
        list.add(list2);

        String s = Utilities.printMyInfoArray(list);
        assertEquals(s, "");
    }

    @Test
    public void testPrintMyInfoArray2()
    {
        List<SensorValue[]> list = new ArrayList<>();
        SensorValue[] list2 = new SensorValue[] {new SensorValue("Sensor0", 1),
                new SensorValue("Sensor1", 2)};
        list.add(list2);
        SensorValue[] list3 = new SensorValue[] { new SensorValue("Sensor2", 3),
                new SensorValue("Sensor3", 4)};
        list.add(list3);

        String s = Utilities.printMyInfoArray(list);
        assertTrue(s.contains("Sensor0"));
        assertTrue(s.contains("Sensor1"));
        assertTrue(s.contains("Sensor2"));
        assertTrue(s.contains("Sensor3"));
        assertTrue(s.contains("1"));
        assertTrue(s.contains("2"));
        assertTrue(s.contains("3"));
        assertTrue(s.contains("4"));
    }

    @Test
    public void testRandom()
    {
        int r = Utilities.getRandom(0, 0);
        assertEquals(r, 0);
    }

    @Test
    public void testRandom2()
    {
        int r = Utilities.getRandom(1, 1);
        assertEquals(r, 1);
    }

}
