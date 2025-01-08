package SmartHome;

public class Thermostat extends Device{
    private int temperature;

    public Thermostat(String name) {
        super(name, DeviceType.THERMOSTAT);
        this.temperature = 20;
    }

    @Override
    public void turnOn() {
        setStatus(true);
        System.out.println(getName() + " thermostat is ON.");
    }
    @Override
    public void turnOff() {
        setStatus(false);
        System.out.println(getName() + " thermostat is OFF.");
    }
    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println(getName() + " temperature is set to " + temperature);
    }
    public int getTemperature() {
        return temperature;
    }
}
