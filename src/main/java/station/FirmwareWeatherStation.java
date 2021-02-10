package station;

import base.*;
import sensor.ISensor;
import sensor.SensorValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe che implementa la logica di una stazione
 */
public class FirmwareWeatherStation extends Thread {

    public AbstractWeatherStationInfo info;

    public AbstractWeatherStationInfo getInfo() {
        return info;
    }

    public void setInfo(AbstractWeatherStationInfo info) {
        if (info == null)
        {
            throw new IllegalArgumentException();
        }

        this.info = info;
    }

    public WeatherStationStatus getStationStatus() {
        return stationStatus;
    }

    public void setStationStatus(WeatherStationStatus stationStatus) {
        this.stationStatus = stationStatus;
    }

    public List<SensorValue[]> getLocalDB() {
        return localDB;
    }

    public WeatherStationStatus stationStatus;

    List<SensorValue[]> localDB = new ArrayList<>();

    public FirmwareWeatherStation(AbstractWeatherStationInfo my) {
        setInfo(my);

        setStationStatus(WeatherStationStatus.Off);
    }

    public void checkPower() {
        if (info.getMode() == Mode.AutomaticAlim) {
            if (info.getPowerStatus().getWindPower() > 25) {
                info.setPowerSource(PowerSource.WindPower);
            }
            else if (info.getPowerStatus().getSolarPower() > 25) {
                info.setPowerSource(PowerSource.SolarPower);
            } else if (info.getPowerStatus().getBatteryPower() > 0){
                info.setPowerSource(PowerSource.Battery);
            }
            else
            {
                throw new RuntimeException();
            }
        } else {
            if (!info.isConnected()) {
                info.setMode(Mode.AutomaticAlim);
            }
        }
    }

    public SensorValue[] getSensorData() {
        SensorValue[] list = new SensorValue[this.info.getSensorList().size()];

        for (int i = 0; i < this.info.getSensorList().size(); i++)
        {
            list[i] = new SensorValue(info.getSensorList().get(i).getName(), info.getSensorList().get(i).getData());
        }

        return list;
    }

    public List<SensorValue[]> localData()
    {
        return localDB;
    }

    public void uploadData(SensorValue[] Data) {
        localDB.add(Data);

        if (localDB.size() == Constant.MinData) {
            DataBase.uploadData(localDB);
        }
    }

    public ISensor autoCheckProblems()
    {
        for (ISensor x : info.getErrorList())
        {
            if (!x.getData().equals(""))
            {
                return x;
            }
        }

        return null;
    }
    
    public void powerOn() {
        if (getStationStatus() == WeatherStationStatus.Off)
        {
            setStationStatus(WeatherStationStatus.On);
            start();
        }
    }

    public void restart()
    {
        setStationStatus(WeatherStationStatus.On);

        // Riavvia la macchina
    }

    public void shutdown() {
        if (getStationStatus() == WeatherStationStatus.On)
        {
            setStationStatus(WeatherStationStatus.Off);
            interrupt();
        }
    }

    public void update()
    {
        // Aggiorna il firmware

        restart();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            oneRun();

            try {
                Thread.sleep(1000 * Utilities.getRandom(5, 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean writeLog = false;
    public static boolean getWriteLog()
    {
        return writeLog;
    }
    public static void setWriteLog(boolean writeLog) {
        FirmwareWeatherStation.writeLog = writeLog;
    }

    /**
     * Esegue un "ciclo di clock"
     */
    public void oneRun() {
        SensorValue[] d = getSensorData();

        if (writeLog) {
            System.out.println("W [" + info.getName() +
                    "]: [" + info.getPosition().toString() + " - " + info.getDimension().toString() + "] " +
                    Utilities.printMyInfo(d));
        }

        PowerSource prev = info.getPowerSource();

        checkPower();
        uploadData(d);
        ISensor problem = autoCheckProblems();
        if (problem != null && writeLog)
        {
            System.out.println(problem.toString());
        }

        if (!prev.equals(info.getPowerSource()) && writeLog)
        {
            System.out.println("W [" + info.getName() +
                    "]: Change alim: " + prev.name() + " to " + info.getPowerSource().name());
        }
    }

}
