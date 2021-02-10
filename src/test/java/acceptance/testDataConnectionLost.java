package acceptance;

import org.junit.Test;
import station.FirmwareWeatherStation;
import station.AbstractWeatherStationInfo;
import station.VirtualWeatherStationInfo;

import static org.junit.Assert.assertEquals;

public class testDataConnectionLost {

    /**
     * La stazione deve salvare in locale i dati dei sensori fino a quando non viene ripristinata la connessione
     */
    @Test
    public void test()
    {
        AbstractWeatherStationInfo info = new VirtualWeatherStationInfo("0");
        info.setConnected(false);
        FirmwareWeatherStation fw = new FirmwareWeatherStation(info);

        fw.oneRun();
        fw.oneRun();

        assertEquals(fw.getLocalDB().size(), 2);
    }

}
