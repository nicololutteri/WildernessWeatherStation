package acceptance;

import base.WeatherStationStatus;
import org.junit.Test;
import station.StationManagmentSystem;
import station.VirtualWeatherStationInfo;

import static org.junit.Assert.assertEquals;

public class testCommunicationPower {

    /**
     * La stazione dev'essere in grado di ricevere dei comandi e di rispondere correttamente ai comandi di accensione
     */
    @Test
    public void testCommunicationPower()
    {
        VirtualWeatherStationInfo info = new VirtualWeatherStationInfo("0");

        StationManagmentSystem sms = new StationManagmentSystem();
        sms.addStation(info);

        sms.sendCommand("0", "shutdown");
        assertEquals(sms.findStation("0").stationStatus, WeatherStationStatus.Off);

        sms.sendCommand("0", "poweron");
        assertEquals(sms.findStation("0").stationStatus, WeatherStationStatus.On);

        sms.sendCommand("0", "restart");
        assertEquals(sms.findStation("0").stationStatus, WeatherStationStatus.On);

        sms.sendCommand("0", "update");
        assertEquals(sms.findStation("0").stationStatus, WeatherStationStatus.On);
    }

}
