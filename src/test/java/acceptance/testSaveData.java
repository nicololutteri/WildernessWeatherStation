package acceptance;

import base.Constant;
import base.DataBase;
import org.junit.Test;
import station.AbstractWeatherStationInfo;
import station.StationManagmentSystem;
import station.VirtualWeatherStationInfo;

import static org.junit.Assert.assertEquals;

public class testSaveData {

    /**
     * La stazione deve inviare i dati alla stazione
     */
    @Test
    public void testSaveData()
    {
        AbstractWeatherStationInfo info = new VirtualWeatherStationInfo("Name");
        info.setConnected(true);

        StationManagmentSystem sms = new StationManagmentSystem();
        sms.addStation(info);

        for (int i = 0; i < Constant.MinData; i++)
        {
            sms.findStation("Name").oneRun();
        }

        assertEquals(DataBase.getData().size(), Constant.MinData);
    }

}
