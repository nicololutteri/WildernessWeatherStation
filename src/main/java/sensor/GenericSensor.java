package sensor;

/**
 * Implementazione astratta di un sensore che gestisce solo il nome (richiede l'implementazione del tipo dato)
 */
public abstract class GenericSensor implements ISensor {

    String name;

    public void setName(String name)
    {
        if (name == null || name.trim().equals(""))
        {
            throw new IllegalArgumentException();
        }

        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", " + getName();
    }

}
