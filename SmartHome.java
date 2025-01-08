package SmartHome;

import java.util.ArrayList;
import java.util.List;

public class SmartHome implements Manageable{
    //fields
    private List<User> users;
    private List<Device> devices;

    public SmartHome() {
        users = new ArrayList<User>();
        devices = new ArrayList<Device>();
    }
    //getter setter
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        if(users != null) {
            this.users = users;
        }
    }
    public List<Device> getDevices() {
        return devices;
    }
    public void setDevices(List<Device> devices) {
        if(devices != null) {
            this.devices = devices;
        }
    }
    //adding new users to the system
    public void addUser(User user) {
        if(user != null && !users.contains(user)) {
            users.add(user);
            System.out.println("User added " + user.getFirstName() + " " + user.getLastName());
        } else {
            System.out.println("User already exists or null");
        }
    }
    //removing users from system
    public void removeUser(User user) {
        if(users.remove(user)) {
            System.out.println("User removed: " + user.getFirstName() + " " + user.getLastName());
        } else {
            System.out.println("User does not exist");
        }
    }
    // adding devices to the system
    @Override
    public void addDevice(Device device) {
        if(device != null && !devices.contains(device)) {
            devices.add(device);
            System.out.println("Device added: " + device.getName());
        } else {
            System.out.println("Device already exists or null");
        }
    }
    //removing devices from system
    @Override
    public void removeDevice(Device device) {
        if(devices.remove(device)) {
            System.out.println("Device removed: " + device.getName());
        } else {
            System.out.println("Device does not exist");
        }
    }
    //getting the status of the device
    public Device getDeviceStatus(int id) {
        for (Device device : devices) {
            if(device.getId() == id) {
                return device;
            }
        }
        throw new RuntimeException("No device with id " + id + " found");
    }
}
