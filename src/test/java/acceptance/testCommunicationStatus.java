package acceptance;

import org.junit.Test;

import station.StationManagmentSystem;
import station.VirtualWeatherStationInfo;

import static org.junit.Assert.assertNotEquals;

public class testCommunicationStatus {

    /**
     * La stazione dev'essere in grado di ricevere dei comandi e di rispondere correttamente ai messaggi di diagnostica
     */
    @Test
    public void testCommunicationStatus()
    {
        VirtualWeatherStationInfo info = new VirtualWeatherStationInfo("0");

        StationManagmentSystem sms = new StationManagmentSystem();
        sms.addStation(info);

        String s = sms.sendCommand("0", "status");
        assertNotEquals(s, "");

        s = sms.sendCommand("0", "info");
        assertNotEquals(s, "");
    }

}
