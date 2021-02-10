package sensor;

/**
 * Sensore per i test che non visualizza nessun errore
 */
public class VirtualErrorSensor extends GenericSensor {

    public VirtualErrorSensor(String name)
    {
        setName(name);
    }

    @Override
    public Object getData() {
        return "";
    }

}
