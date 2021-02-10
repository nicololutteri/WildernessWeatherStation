package acceptance;

import org.junit.Test;
import sensor.VirtualSensor;
import station.StationManagmentSystem;
import station.VirtualWeatherStationInfo;

import static org.junit.Assert.assertNotEquals;

public class testCommunicationData {

    /**
     * La stazione deve comunicare i dati dei sensori quando richiesto dall'operatore
     */
    @Test
    public void testCommunicationData()
    {
        VirtualWeatherStationInfo info = new VirtualWeatherStationInfo("0");
        info.addSensor(new VirtualSensor("Sensor"));

        StationManagmentSystem sms = new StationManagmentSystem();
        sms.addStation(info);

        sms.findStation("0").oneRun();

        String s = sms.sendCommand("0", "getdata");
        assertNotEquals(s,"");
    }

}
