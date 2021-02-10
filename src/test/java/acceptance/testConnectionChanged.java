package acceptance;

import base.Mode;
import org.junit.Test;
import station.FirmwareWeatherStation;
import station.AbstractWeatherStationInfo;
import station.VirtualWeatherStationInfo;

import static org.junit.Assert.assertEquals;

public class testConnectionChanged {

    /**
     * La stazione deve passare allo stato Automatico di gestione dell'alimentazione quando perde la connessione
     */
    @Test
    public void testConnectionChanged()
    {
        AbstractWeatherStationInfo info = new VirtualWeatherStationInfo("0");
        info.setConnected(true);
        info.setMode(Mode.RemoteControl);

        FirmwareWeatherStation fw = new FirmwareWeatherStation(info);
        fw.oneRun();
        assertEquals(info.getMode(), Mode.RemoteControl);

        info.setConnected(false);
        fw.oneRun();
        assertEquals(info.getMode(), Mode.AutomaticAlim);
    }

}
