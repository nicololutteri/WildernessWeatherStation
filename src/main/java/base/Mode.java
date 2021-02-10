package base;

/**
 * Modalità di una stazione
 */
public enum Mode {
    /**
     * La stazione decide autonomamente il tipo di alimentazione
     */
    AutomaticAlim,
    /**
     * La stazione prende ordini dalla centrale su quale fonte di energia utilizzare
     */
    RemoteControl
}
