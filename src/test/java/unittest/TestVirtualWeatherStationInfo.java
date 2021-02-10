package unittest;

import org.junit.Test;
import station.VirtualWeatherStationInfo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestVirtualWeatherStationInfo {

    @Test(expected = IllegalArgumentException.class)
    public void testErrorConstructor()
    {
        VirtualWeatherStationInfo w = new VirtualWeatherStationInfo(null);
    }

    @Test
    public void testConstructor()
    {
        VirtualWeatherStationInfo w = new VirtualWeatherStationInfo("StationInfo0");

        assertEquals(w.getName(), "StationInfo0");
    }

    @Test
    public void testGetPowerStatus()
    {
        VirtualWeatherStationInfo w = new VirtualWeatherStationInfo("StationInfo0");

        assertNotNull(w.getPowerStatus());
    }

}
