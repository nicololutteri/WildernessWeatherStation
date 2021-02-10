package base;

/**
 * Indica la disponibilità delle varie sorgenti connesse alla centrale
 */
public class PowerStatus {

    public PowerStatus(int batteryPercentage, int solarPower, int windPower) {
        setBatteryPower(batteryPercentage);
        setSolarPower(solarPower);
        setWindPower(windPower);
    }

    private int BatteryPercentage;
    private int SolarPower;

    @Override
    public String toString() {
        return "PowerStatus " +
                "BatteryPercentage=" + BatteryPercentage +
                ", SolarPower=" + SolarPower +
                ", windPower=" + windPower;
    }

    private int windPower;

    public int getBatteryPower() {
        return BatteryPercentage;
    }

    public void setBatteryPower(int batteryPower) {
        if (batteryPower < 0 || batteryPower > 100)
        {
            throw new IllegalArgumentException();
        }

        BatteryPercentage = batteryPower;
    }

    public int getSolarPower() {
        return SolarPower;
    }

    public void setSolarPower(int solarPower) {
        if (solarPower < 0 || solarPower > 100)
        {
            throw new IllegalArgumentException();
        }

        SolarPower = solarPower;
    }

    public int getWindPower() {
        return windPower;
    }

    public void setWindPower(int windPower) {
        if (windPower < 0 || windPower > 100)
        {
            throw new IllegalArgumentException();
        }

        this.windPower = windPower;
    }

}
