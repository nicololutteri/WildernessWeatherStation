package unittest;

import base.Dimension;
import base.Position;
import org.junit.Before;
import org.junit.Test;
import sensor.VirtualErrorSensor;
import sensor.VirtualSensor;
import station.AbstractWeatherStationInfo;
import station.WeatherStationInfo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class TestWeatherStationInfo {

    AbstractWeatherStationInfo f;

    @Before
    public void preparation()
    {
        f = new WeatherStationInfo("StationInfo0", new Position(1, 2, 3),
                new Dimension(4, 5 , 6));
    }

    @Test
    public void testConstructor()
    {
        assertEquals(f.getName(),"StationInfo0");

        assertEquals(f.getPosition().getX(), 1, 0);
        assertEquals(f.getPosition().getY(), 2, 0);
        assertEquals(f.getPosition().getZ(), 3, 0);

        assertEquals(f.getDimension().getWidth(), 4, 0);
        assertEquals(f.getDimension().getLength(), 5, 0);
        assertEquals(f.getDimension().getDepth(), 6, 0);
    }

    @Test
    public void testSetList()
    {
        f.setSensorList(new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetList2()
    {
        f.setSensorList(null);
    }

    @Test
    public void TestList(){
        assertEquals(f.getName(), "StationInfo0");

        f.addSensor(new VirtualSensor("Sensor0"));
        f.addSensor(new VirtualSensor("Sensor1", 1, 10));
        assertEquals(f.getSensorList().size(), 2);

        f.removeSensor("Sensor0");
        f.removeSensor("Sensor1");
        assertEquals(f.getSensorList().size(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testErrorList()
    {
        f.addSensor(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testErrorList3()
    {
        f.removeSensor(null);
    }

    @Test(expected = RuntimeException.class)
    public void testErrorList4()
    {
        f.removeSensor("Sensor0");
    }

    @Test(expected = RuntimeException.class)
    public void testErrorList5()
    {
        f.addSensor(new VirtualSensor("Sensor0"));
        f.removeSensor("Sensor1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testErrorListError()
    {
        f.addErrorSensor(null);
    }

}
