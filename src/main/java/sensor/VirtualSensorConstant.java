package sensor;

/**
 * Sensore virtuale che mantiene un valore costante
 */
public class VirtualSensorConstant extends GenericSensor {

    private final int costantValue;

    public VirtualSensorConstant(String name, int costantValue)
    {
        setName(name);
        this.costantValue = costantValue;
    }

    @Override
    public Object getData() {
        return this.costantValue;
    }

}
