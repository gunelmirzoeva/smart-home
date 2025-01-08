package SmartHome;

import java.util.Scanner;

public class SmartHomeApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SmartHome smartHome = new SmartHome();

        //User registration
        System.out.println("\n== USER REGISTRATION ==\n");
        System.out.println("Enter your first name: ");
        String firstName = sc.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = sc.nextLine();
        System.out.println("Enter your email: ");
        String email = sc.nextLine();
        System.out.println("Enter your password: ");
        String password = sc.nextLine();

        User user = new User(firstName, lastName, email, password);
        user.register();

        //User login
        System.out.println("\n== USER LOGIN ==\n");
        System.out.println("Enter your email: ");
        String loginEmail = sc.nextLine();
        System.out.println("Enter your password: ");
        String loginPassword =  sc.nextLine();
        user.login(loginEmail, loginPassword);

        // Adding devices
        System.out.println("\n== ADDING DEVICES ==\n");
        System.out.println("Enter device name: ");
        String deviceName = sc.nextLine();
        System.out.println("Enter device type (LIGHT, THERMOSTAT, CAMERA, DOORBELL): ");
        Device.DeviceType deviceType = Device.DeviceType.valueOf(sc.nextLine().toUpperCase());

        Device device;
        switch (deviceType) {
            case LIGHT:
                device = new Light(deviceName);
                break;
            case THERMOSTAT:
                device = new Thermostat(deviceName);
                break;
            case CAMERA:
                device = new Camera(deviceName);
                break;
            case DOORBELL:
                device = new Doorbell(deviceName);
                break;
            default:
                throw new IllegalArgumentException("Invalid device type");
        }
        smartHome.addDevice(device);

        System.out.println("\n== DEVICE INTERACTION ==\n");
        device.turnOn();
        if(device instanceof Thermostat) {
            System.out.println("Set the temperature: ");
            int temperature = sc.nextInt();
            ((Thermostat) device).setTemperature(temperature);
        } else if (device instanceof Camera) {
            ((Camera) device).startRecording();
            ((Camera) device).stopRecording();
        } else if (device instanceof Doorbell) {
            ((Doorbell) device).ring();
        }
        device.turnOff();

        System.out.println("\n== DEVICE LIST ==\n");
        for (Device d : smartHome.getDevices()) {
            System.out.println(d);
        }

        System.out.println("\n== DEVICE STATUS ==\n");
        System.out.println("Enter device ID: ");
        int deviceID = sc.nextInt();
        try {
            Device foundDevice = smartHome.getDeviceStatus(deviceID);
            System.out.println("Found device: " + foundDevice);
        } catch (Exception e) {
            System.out.println("Could not find device: " + deviceID);
        }

        System.out.println("\n== REMOVE DEVICE ==\n");
        smartHome.removeDevice(device);
        System.out.println(device + " removed");

        System.out.println("\n== USER LOGOUT ==\n");
        user.logout();
    }
}
