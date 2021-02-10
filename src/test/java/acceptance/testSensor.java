package acceptance;

import org.junit.Test;
import sensor.SensorValue;
import sensor.VirtualSensorConstant;
import station.FirmwareWeatherStation;
import station.VirtualWeatherStationInfo;

import static org.junit.Assert.assertEquals;

public class testSensor {

    /**
     * La stazione dev'essere in grado di raccogliere i dati dai sensori
     */
    @Test
    public void testSensor()
    {
        VirtualWeatherStationInfo info = new VirtualWeatherStationInfo("0");
        for (int i = 1; i < 6; i++)
        {
            info.addSensor(new VirtualSensorConstant("Sensor" + i, i));
        }

        FirmwareWeatherStation fw = new FirmwareWeatherStation(info);

        SensorValue[] data = fw.getSensorData();

        for (int i = 1; i < 6; i++)
        {
            assertEquals(data[i - 1].getName(), "Sensor" + i);
            assertEquals(data[i - 1].getData(), i);
        }
    }

}
