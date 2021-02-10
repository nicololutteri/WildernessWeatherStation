package station;

import base.*;
import sensor.VirtualSensor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Sistema di gestione delle stazioni
 */
public class StationManagmentSystem {

    List<FirmwareWeatherStation> weatherStations = new ArrayList<>();

    Random ran = new Random();

    public StationManagmentSystem(int n)
    {
        if (n <= 0)
        {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < n; i++) {
            AbstractWeatherStationInfo s = new VirtualWeatherStationInfo("Station" + i);
            s.setDimension(new Dimension(5, 5, 5));
            s.setPosition(new Position(ran.nextInt(10), ran.nextInt(10), ran.nextInt(10)));

            for (int j = 1; j < ran.nextInt(10); j++) {
                s.addSensor(new VirtualSensor("Sensor" + j, 1, 10));
            }

            addStation(s);
        }
    }

    public StationManagmentSystem()
    {

    }

    public void addStation(AbstractWeatherStationInfo info)
    {
        weatherStations.add(new FirmwareWeatherStation(info));
    }

    public void deleteStation(String name) {
        if (name == null || name.trim().equals(""))
        {
            throw new IllegalArgumentException();
        }

        for (FirmwareWeatherStation i : weatherStations) {
            if (i.getInfo().getName().equals(name))
            {
                weatherStations.remove(i);
                return;
            }
        }

        throw new RuntimeException();
    }

    public int totalStation()
    {
        return weatherStations.size();
    }

    public int totalStationRunning()
    {
        int running = 0;

        for (FirmwareWeatherStation i : weatherStations)
        {
            if (i.stationStatus == WeatherStationStatus.On)
            {
                running += 1;
            }
        }

        return running;
    }

    public void start() {
        for (FirmwareWeatherStation i : weatherStations) {
            i.powerOn();
        }
    }

    public String sendCommand(String name, String command)
    {
        if (name == null || name.trim().equals(""))
        {
            throw new IllegalArgumentException();
        }

        FirmwareWeatherStation f = findStation(name);

        switch(command)
        {
            case "poweron":
                f.powerOn();
                break;
            case "shutdown":
                f.shutdown();
                break;
            case "restart":
                f.restart();
                break;
            case "update":
                f.update();
                break;
            case "getdata":
                return Utilities.printMyInfoArray(f.localData());
            case "status":
                return f.getInfo().getPowerStatus().toString();
            case "power":
                return f.getInfo().getPowerSource().name();
            case "setpowerbattery":
                f.getInfo().setPowerSource(PowerSource.Battery);
                break;
            case "setpowersolar":
                f.getInfo().setPowerSource(PowerSource.SolarPower);
                break;
            case "setpowerwind":
                f.getInfo().setPowerSource(PowerSource.WindPower);
                break;
            case "info":
                return info(f);
            case "help":
                return help();
            default:
                return "Unknown command";
        }

        return "";
    }

    public String info(FirmwareWeatherStation station)
    {
        return station.getInfo().getName() + " - " +
                station.getInfo().getPosition() + " - " + station.getInfo().getDimension() + " - " +
                station.getStationStatus().name();
    }

    public String help()
    {
        return Constant.HelpCommand;
    }

    public FirmwareWeatherStation findStation(String name)
    {
        for (FirmwareWeatherStation i : weatherStations)
        {
            if (i.getInfo().getName().equals(name))
            {
                return i;
            }
        }

        throw new RuntimeException();
    }

    public String generalStatus() {
        String tmp = "";

        for (FirmwareWeatherStation i : weatherStations)
        {
            tmp = tmp + info(i) + "\n";
        }

        return tmp;
    }

    public void stop() {
        for (FirmwareWeatherStation i : weatherStations)
        {
            i.shutdown();
        }
    }
}
