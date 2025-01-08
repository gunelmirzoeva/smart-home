package SmartHome;

public class Doorbell extends Device {
    public Doorbell(String name) {
        super(name, DeviceType.DOORBELL);
    }
    @Override
    public void turnOn() {
        setStatus(true);
        System.out.println(getName() + " doorbell is ON");
    }
    @Override
    public void turnOff() {
        setStatus(false);
        System.out.println(getName() + " doorbell is OFF");
    }
    public void ring() {
        if(getStatus()) {
            System.out.println(getName() + " doorbell is ringing");
        }
        else {
            System.out.println(getName() + " doorbell must be ON to ring");
        }
    }
}
