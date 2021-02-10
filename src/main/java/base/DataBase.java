package base;

import sensor.SensorValue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Mockup di un database dove ogni stazione salva i dati
 */
public class DataBase {

    private static List<SensorValue[]> list = new ArrayList<>();

    private static final ReentrantLock lock = new ReentrantLock();

    public static void uploadData(List<SensorValue[]> data) {
        synchronized (lock)
        {
            list.addAll(data);
        }
    }

    public static List<SensorValue[]> getData() {
        synchronized (lock)
        {
            return list;
        }
    }

    public static void clean()
    {
        synchronized (lock)
        {
            list = new ArrayList<>();
        }
    }

}
