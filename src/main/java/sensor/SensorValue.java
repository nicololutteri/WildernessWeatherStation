package sensor;

import java.time.LocalDateTime;

/**
 * Classe che rappresenta un valore di un sensore all'interno del database
 */
public class SensorValue {
    @Override
    public String toString() {
        return "SensorValue{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }

    private String name;
    private Object date;

    private final LocalDateTime time;

    public SensorValue(String name, Object date) {
        setName(name);
        setDate(date);

        time = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().equals(""))
        {
            throw new IllegalArgumentException();
        }

        this.name = name;
    }

    public Object getData() {
        return date;
    }

    private void setDate(Object date) {
        if (date == null)
        {
            throw new IllegalArgumentException();
        }

        this.date = date;
    }

}
