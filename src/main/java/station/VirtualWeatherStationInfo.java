package station;

import base.Dimension;
import base.Position;
import base.PowerSource;
import base.PowerStatus;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Stazione virtuale per i test
 */
public class VirtualWeatherStationInfo extends AbstractWeatherStationInfo {

    public VirtualWeatherStationInfo(String name)
    {
        setName(name);

        setPowerSource(PowerSource.Battery);

        setPosition(new Position(1, 2, 3));
        setDimension(new Dimension(5, 5,5));
    }

    @Override
    public PowerStatus getPowerStatus() {
        return new PowerStatus(ThreadLocalRandom.current().nextInt(1, 100 + 1),
                ThreadLocalRandom.current().nextInt(0, 100 + 1),
                ThreadLocalRandom.current().nextInt(0, 100 + 1));
    }

}
