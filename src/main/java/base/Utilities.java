package base;

import sensor.SensorValue;

import java.util.List;
import java.util.Random;

public class Utilities {

    /**
     * Stampa i sensori di una stazione
     * @param d Vettore di sensori
     * @return Stringa che rappresenta il contenuto dei sensori
     * @throws IllegalArgumentException Quando il parametro è null
     */
    public static String printMyInfo(SensorValue[] d) {
        if (d == null)
        {
            throw new IllegalArgumentException();
        }

        String s = "";

        for (SensorValue x : d) {
            s += x.getName() + "=" + x.getData() + " ";
        }

        return s;
    }

    /**
     * Stampa un intero database di sensori
     * @param localData Lista di entry di sensori
     * @return Rappresentazione in stringa del DB
     * @throws IllegalArgumentException Quando il parametro è null
     */
    public static String printMyInfoArray(List<SensorValue[]> localData) {
        if (localData == null)
        {
            throw new IllegalArgumentException();
        }

        String s = "";

        for (SensorValue[] x : localData) {
            String tmp = printMyInfo(x);
            if (!tmp.equals("")) {
                s += printMyInfo(x) + "\n";
            }
        }

        return s;
    }

    private static final Random ran = new Random();

    /**
     * Genera un numero casuale tra due parametri
     * @param min Minimo incluso di generazione random
     * @param max Massimo incluso di generazione random
     * @return Numero casuale tra minimo e massimo
     */
    public static Integer getRandom(int min, int max) {
        return ran.nextInt(max - min + 1) + min;
    }
}
