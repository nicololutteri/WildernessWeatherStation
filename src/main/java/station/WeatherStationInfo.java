package station;

import base.Position;
import base.PowerSource;
import base.PowerStatus;
import base.Dimension;
import base.Mode;

/**
 * Implementazione abbozzata di una stazione fisica
 */
public class WeatherStationInfo extends AbstractWeatherStationInfo {

    public WeatherStationInfo(String name)
    {
        setName(name);

        setPowerSource(PowerSource.Battery);
        setPowerStatus(new PowerStatus(1, 0, 0));
        setPosition(new Position(2, 2, 2));
        setDimension(new Dimension(5, 5, 5));
        setConnected(true);
        setMode(Mode.AutomaticAlim);
    }

    public WeatherStationInfo(String name, Position position, Dimension dimension)
    {
        this(name);

        setPosition(position);
        setDimension(dimension);
    }

}
