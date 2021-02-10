package station;

import base.*;
import sensor.ISensor;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe astratta che implementa la stazione
 */
public abstract class AbstractWeatherStationInfo {

    private Position position;
    private Dimension dimension;

    private boolean isConnected;

    private PowerSource powerSource;
    private PowerStatus powerStatus;

    private List<ISensor> sensorList = new ArrayList<>();
    private final List<ISensor> errorSensor = new ArrayList<>();

    private String name;

    private Mode mode;

    public List<ISensor> getErrorList()
    {
        return errorSensor;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().equals(""))
        {
            throw new IllegalArgumentException(name);
        }

        this.name = name;
    }

    public void addSensor(ISensor s) {
        if (s == null)
        {
            throw new IllegalArgumentException();
        }

        sensorList.add(s);
    }
    public void addErrorSensor(ISensor s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException();
        }

        this.errorSensor.add(s);
    }

    public void removeSensor(String name) {
        if (name == null || name.trim().equals(""))
        {
            throw new IllegalArgumentException();
        }

        for (ISensor i : sensorList)
        {
            if (i.getName().equals(name))
            {
                sensorList.remove(i);
                return;
            }
        }

        throw new RuntimeException();
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }

    public PowerSource getPowerSource() {
        return powerSource;
    }

    public void setPowerSource(PowerSource powerSource) {
        this.powerSource = powerSource;
    }

    public PowerStatus getPowerStatus() {
        return powerStatus;
    }

    public void setPowerStatus(PowerStatus powerStatus) {
        this.powerStatus = powerStatus;
    }

    public List<ISensor> getSensorList() {
        return sensorList;
    }

    public void setSensorList(List<ISensor> sensorList) {
        if (sensorList == null)
        {
            throw new IllegalArgumentException();
        }

        this.sensorList = sensorList;
    }

}
