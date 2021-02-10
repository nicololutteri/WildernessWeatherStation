package sensor;

/**
 * Sensore che visualizza un errore
 */
public class VirtualErrorSensorError extends GenericSensor {

    public VirtualErrorSensorError(String name)
    {
        setName(name);
    }

    @Override
    public Object getData() {
        return "Generic Error";
    }

}
