package SmartHome;

public class Light extends Device {
    public Light(String name) {
        super(name, DeviceType.LIGHT);
    }

    @Override
    public void turnOn() {
        setStatus(true);
        System.out.println(getName() + " light is now ON.");
    }

    @Override
    public void turnOff() {
        setStatus(false);
        System.out.println(getName() + " light is now OFF.");
    }
}
