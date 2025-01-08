package SmartHome;

public class Camera extends Device{
    private boolean recording;

    public Camera(String name) {
        super(name, DeviceType.CAMERA);
        recording = false;
    }

    @Override
    public void turnOn() {
        setStatus(true);
        System.out.println(getName() + " camera is ON");
    }
    @Override
    public void turnOff() {
        if(recording) {
            stopRecording();
        }
        setStatus(false);
        System.out.println(getName() + " camera is OFF");
    }

    public void startRecording() {
        if(getStatus()) {
            recording = true;
            System.out.println(getName() + " recording started");
        } else {
            System.out.println(getName()+ " camera must be ON to start recording");
        }
    }
    public void stopRecording() {
        if(recording) {
            recording = false;
            System.out.println(getName() + " recording stopped");
        } else {
            System.out.println(getName()+ " camera is not recording");
        }
    }
    public boolean isRecording() {
        return recording;
    }
}
