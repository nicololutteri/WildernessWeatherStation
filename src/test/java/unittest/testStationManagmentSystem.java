package unittest;

import base.Constant;
import base.WeatherStationStatus;
import org.junit.Before;
import org.junit.Test;
import station.AbstractWeatherStationInfo;
import station.StationManagmentSystem;
import station.VirtualWeatherStationInfo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class testStationManagmentSystem {

    StationManagmentSystem sms;

    @Before
    public void preparation()
    {
        sms = new StationManagmentSystem();
        AbstractWeatherStationInfo info = new VirtualWeatherStationInfo("Station0");
        AbstractWeatherStationInfo info2 = new VirtualWeatherStationInfo("Station1");
        sms.addStation(info);
        sms.addStation(info2);
    }

    @Test
    public void testConstructor()
    {
        StationManagmentSystem sms = new StationManagmentSystem(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testErrorConstructor()
    {
        StationManagmentSystem sms = new StationManagmentSystem(-1);
    }

    @Test
    public void testAddAndRemoveStation()
    {
        assertEquals(sms.totalStation(), 2);

        sms.deleteStation("Station0");
        assertEquals(sms.totalStation(), 1);

        sms.deleteStation("Station1");
        assertEquals(sms.totalStation(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testErrorDeleteStation()
    {
        StationManagmentSystem sms = new StationManagmentSystem();
        sms.deleteStation(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testErrorDeleteStation2()
    {
        StationManagmentSystem sms = new StationManagmentSystem();
        sms.deleteStation("");
    }

    @Test(expected = RuntimeException.class)
    public void testErrorDeleteStation3()
    {
        StationManagmentSystem sms = new StationManagmentSystem();
        sms.deleteStation("Station0");
    }

    @Test
    public void testFindStation()
    {
        assertEquals(sms.findStation("Station0").getInfo().getName(), "Station0");
    }

    @Test(expected = RuntimeException.class)
    public void testErrorFindStation()
    {
        StationManagmentSystem sms = new StationManagmentSystem();
        sms.findStation("Station0");
    }

    @Test
    public void testStartAll()
    {
        assertEquals(sms.findStation("Station0").getStationStatus(), WeatherStationStatus.Off);
        assertEquals(sms.findStation("Station1").getStationStatus(), WeatherStationStatus.Off);

        sms.start();

        assertEquals(sms.findStation("Station0").getStationStatus(), WeatherStationStatus.On);
        assertEquals(sms.findStation("Station1").getStationStatus(), WeatherStationStatus.On);
    }

    @Test(expected = RuntimeException.class)
    public void testErrorCommand()
    {
        StationManagmentSystem sms = new StationManagmentSystem();
        sms.sendCommand("Station0", "poweron");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testErrorCommand2()
    {
        StationManagmentSystem sms = new StationManagmentSystem();
        sms.sendCommand("", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testErrorCommand3()
    {
        StationManagmentSystem sms = new StationManagmentSystem();
        sms.sendCommand(null, "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testErrorCommand4()
    {
        StationManagmentSystem sms = new StationManagmentSystem();
        sms.sendCommand("", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testErrorCommand5()
    {
        StationManagmentSystem sms = new StationManagmentSystem();
        sms.sendCommand(null, null);
    }

    @Test
    public void testHelp()
    {
        StationManagmentSystem sms = new StationManagmentSystem();
        assertEquals(sms.help(), Constant.HelpCommand);
    }

    @Test
    public void testGeneral()
    {
        assertTrue(sms.generalStatus().contains("Station0"));
    }

    @Test
    public void testStop()
    {
        assertEquals(sms.totalStationRunning(), 0);
        sms.start();
        assertEquals(sms.totalStationRunning(), 2);
        sms.stop();
        assertEquals(sms.totalStationRunning(), 0);
    }

    @Test
    public void testAllCommand()
    {
        String s = "";

        s += sms.sendCommand("Station0", "poweron");
        s += sms.sendCommand("Station0", "shutdown");
        s += sms.sendCommand("Station0", "restart");
        s += sms.sendCommand("Station0", "update");
        s += sms.sendCommand("Station0", "getdata");
        s += sms.sendCommand("Station0", "status");
        s += sms.sendCommand("Station0", "power");
        s += sms.sendCommand("Station0", "setpowerbattery");
        s += sms.sendCommand("Station0", "setpowersolar");
        s += sms.sendCommand("Station0", "setpowerwind");
        s += sms.sendCommand("Station0", "info");
        s += sms.sendCommand("Station0", "help");
        assertFalse(s.contains("Unknown command"));

        s+= sms.sendCommand("Station0", "test");
        assertTrue(s.contains("Unknown command"));
    }

}
