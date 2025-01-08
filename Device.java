package SmartHome;

public abstract class Device {
    public enum DeviceType {
        LIGHT,
        THERMOSTAT,
        CAMERA,
        DOORBELL
    }
    //fields
    private int id;
    private String name;
    private boolean status;
    private DeviceType deviceType;
    private static int nextId = 1;

    public Device(String name, DeviceType deviceType) {
        this.id = nextId++;
        this.name = name;
        this.deviceType = deviceType;
        this.status = false;
    }

    //getter setter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name != null && !name.isEmpty()){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }
    public DeviceType getDeviceType() {
        return deviceType;
    }
    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }
    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    // turns the device on
    public abstract void turnOn();
    // turns the device off
    public abstract void turnOff();

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + (status ? "ON" : "OFF") +
                ", deviceType=" + deviceType +
                '}';
    }
}
