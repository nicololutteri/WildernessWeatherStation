package acceptance;

import base.Mode;
import base.PowerSource;
import base.PowerStatus;
import org.junit.Test;
import station.FirmwareWeatherStation;
import station.AbstractWeatherStationInfo;
import station.WeatherStationInfo;

import static org.junit.Assert.assertEquals;

public class testPower {

    /**
     * Quando la stazione è in modalità automatica, deve riuscire a gestire l'alimentazione
     */
    @Test
    public void testPower()
    {
        AbstractWeatherStationInfo info = new WeatherStationInfo("Name");
        FirmwareWeatherStation station = new FirmwareWeatherStation(info);

        info.setMode(Mode.AutomaticAlim);

        info.setPowerStatus(new PowerStatus(10, 100, 100));
        station.oneRun();
        assertEquals(info.getPowerSource(), PowerSource.WindPower);

        info.setPowerStatus(new PowerStatus(10, 100, 0));
        station.oneRun();
        assertEquals(info.getPowerSource(), PowerSource.SolarPower);

        info.setPowerStatus(new PowerStatus(10, 0, 0));
        station.oneRun();
        assertEquals(info.getPowerSource(), PowerSource.Battery);

        info.setPowerStatus(new PowerStatus(0, 30, 0));
        station.oneRun();
        assertEquals(info.getPowerSource(), PowerSource.SolarPower);
    }

}
