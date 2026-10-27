package css217;

import java.util.List;

public class ModernHub {
    private final List<SmartDevice> devices;

    public ModernHub(List<SmartDevice> devices) {
        this.devices = List.copyOf(devices);
    }

    public void activateAll() {
        for (SmartDevice device : devices) {
            device.turnOn();
        }
    }

    public void emergencyShutdown() {
        for (SmartDevice device : devices) {
            device.turnOff();
        }
    }

    public double calculateAveragePowerUsage() {
        if (devices.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (SmartDevice device : devices) {
            sum += device.getPowerPercent();
        }
        return (double) sum / devices.size();
    }
}
