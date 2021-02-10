package acceptance;

import org.junit.Test;
import sensor.ISensor;
import sensor.VirtualErrorSensor;
import sensor.VirtualErrorSensorError;
import station.FirmwareWeatherStation;
import station.AbstractWeatherStationInfo;
import station.VirtualWeatherStationInfo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

public class testErrorSensor {

    /**
     * La stazione deve identificare gli errori
     */
    @Test
    public void testErrorSensor()
    {
        AbstractWeatherStationInfo info = new VirtualWeatherStationInfo("Name");
        info.setConnected(true);
        info.addErrorSensor(new VirtualErrorSensor("Sensor1"));
        info.addErrorSensor(new VirtualErrorSensor("Sensor2"));

        FirmwareWeatherStation fw = new FirmwareWeatherStation(info);
        assertNull(fw.autoCheckProblems());

        info.addErrorSensor(new VirtualErrorSensorError("Sensor3"));

        ISensor s = fw.autoCheckProblems();
        assertNotNull(s);
        assertEquals(s.getName(), "Sensor3");
        assertTrue(s.getData() != "");
    }

}
