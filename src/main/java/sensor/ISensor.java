package sensor;

/**
 * Nome e Dato di un sensore
 */
public interface ISensor {

    void setName(String name);
    String getName();

    Object getData();

}
