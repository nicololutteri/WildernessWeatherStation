package sensor;

import base.Utilities;

import java.util.Random;

/**
 * Sensore virtuale che genera numeri casuali da min a max
 */
public class VirtualSensor extends GenericSensor {

    Random r;

    private int min;
    private int max;

    public VirtualSensor(String name) {
        r = new Random();

        setName(name);

        this.min = 0;
        this.max = 10;
    }

    public VirtualSensor(String name, int min, int max) {
        this(name);

        this.min = min;
        this.max = max;
    }

    public Integer getData() {
        return Utilities.getRandom(min, max);
    }

}
