package unittest;

import base.Mode;
import base.PowerSource;
import base.PowerStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sensor.SensorValue;
import sensor.VirtualErrorSensor;
import sensor.VirtualErrorSensorError;
import sensor.VirtualSensor;
import station.FirmwareWeatherStation;
import station.AbstractWeatherStationInfo;
import station.WeatherStationInfo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TestFirmwareWeatherStation {

    AbstractWeatherStationInfo info;

    @Before
    public void preparation()
    {
        info = new WeatherStationInfo("Station0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testErrorConstructor()
    {
        FirmwareWeatherStation f = new FirmwareWeatherStation(null);
    }

    @Test
    public void testCheckPower1()
    {
        info.setPowerStatus(new PowerStatus(50, 100, 100));
        FirmwareWeatherStation f = new FirmwareWeatherStation(info);
        f.oneRun();

        Assert.assertEquals(f.getInfo().getPowerSource(), PowerSource.WindPower);
    }

    @Test
    public void testCheckPower2()
    {
        info.setPowerStatus(new PowerStatus(50, 100, 0));
        FirmwareWeatherStation f = new FirmwareWeatherStation(info);
        f.oneRun();

        Assert.assertEquals(f.getInfo().getPowerSource(), PowerSource.SolarPower);
    }

    @Test
    public void testCheckPower3()
    {
        info.setPowerStatus(new PowerStatus(50, 0, 0));
        FirmwareWeatherStation f = new FirmwareWeatherStation(info);
        f.oneRun();

        Assert.assertEquals(f.getInfo().getPowerSource(), PowerSource.Battery);
    }

    @Test
    public void testCheckPower4()
    {
        info.setConnected(false);
        info.setMode(Mode.RemoteControl);

        FirmwareWeatherStation f = new FirmwareWeatherStation(info);
        f.oneRun();

        Assert.assertEquals(f.getInfo().getMode(), Mode.AutomaticAlim);
    }

    @Test(expected = RuntimeException.class)
    public void testErrorCheckPower()
    {
        info.setPowerStatus(new PowerStatus(0, 0, 0));
        FirmwareWeatherStation f = new FirmwareWeatherStation(info);
        f.oneRun();
    }

    @Test
    public void testMyData()
    {
        info.addSensor(new VirtualSensor("1"));
        info.addSensor(new VirtualSensor("2"));

        FirmwareWeatherStation f = new FirmwareWeatherStation(info);

        SensorValue[] list = f.getSensorData();

        assertEquals(list.length, 2);
        Assert.assertEquals(list[0].getName(), "1");
        Assert.assertEquals(list[1].getName(), "2");
    }

    @Test
    public void testUploadData()
    {
        info.setConnected(false);

        FirmwareWeatherStation f = new FirmwareWeatherStation(info);
    }

    @Test
    public void testAutoCheckForProblems()
    {
        info.addSensor(new VirtualErrorSensor("1"));
        info.addSensor(new VirtualErrorSensor("2"));

        FirmwareWeatherStation f = new FirmwareWeatherStation(info);

        assertNull(f.autoCheckProblems());
    }

    @Test
    public void testErrorAutoCheckForProblem()
    {
        info.addErrorSensor(new VirtualErrorSensor("1"));
        info.addErrorSensor(new VirtualErrorSensorError("2"));

        FirmwareWeatherStation f = new FirmwareWeatherStation(info);

        assertNotNull(f.autoCheckProblems());
    }

    @Test
    public void testOneRun()
    {
        info.addErrorSensor(new VirtualErrorSensor("1"));
        info.addErrorSensor(new VirtualErrorSensorError("2"));

        FirmwareWeatherStation f = new FirmwareWeatherStation(info);

        f.oneRun();
    }

}
