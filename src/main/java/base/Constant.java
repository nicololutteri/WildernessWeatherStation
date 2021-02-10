package base;

public class Constant {

    /**
     * Massima profondità per una stazione (Z)
     */
    public static int MaxDepth = -1000;
    /**
     * Minimo di dati da trattenere prima dell'invio al server
     */
    public static int MinData = 5;

    public static String HelpConsole = "Inserire il numero dell stazione e il comando da eseguire " +
            "(se si vuole visualizzare una lista dei comandi disponibili digitare helpcommand)\n" +
            "Con solo il comando normal si avvierà una simulazione delle differenti stazioni\n" +
            "Mentre con il comando general viene visualizzato uno stato generale";

    public static String HelpCommand = "poweron, Accende la stazione\n + " +
            "shutdown, Spegne la stazione\n" +
            "restart, Riavvia la stazione\n" +
            "getdata, Mostra i dati dei sensori salvati all'interno della stazione\n" +
            "status, Mostra l'attuale disponibilità di risorse\n" +
            "power, Sorgente corrente di energia\n" +
            "setpowerbattery, Cambia la sorgente in batteria\n" +
            "setpowersolar, Cambia la sorgente in energia solare\n" +
            "setpowerwind, Cambia la sorgente in energia eolica\n" +
            "info, Informazioni sulla stazione\n" +
            "help, Mostra l'aiuto dei comandi disponibili per una stazione\n";

}
