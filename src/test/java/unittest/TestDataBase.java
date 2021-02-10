package unittest;

import base.DataBase;
import org.junit.Before;
import org.junit.Test;
import sensor.SensorValue;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestDataBase {

    @Before
    public void testBefore()
    {
        DataBase.clean();
    }

    @Test
    public void testAdd()
    {
        List<SensorValue[]> list = new ArrayList<>();

        SensorValue[] l = new SensorValue[] { new SensorValue("Sensor1", 1)};
        list.add(l);

        assertEquals(DataBase.getData().size(), 0);

        DataBase.uploadData(list);
        assertEquals(DataBase.getData().size(), 1);
        assertEquals(DataBase.getData().get(0)[0].getName(), "Sensor1");
        assertEquals(DataBase.getData().get(0)[0].getData(), 1);
    }

}
