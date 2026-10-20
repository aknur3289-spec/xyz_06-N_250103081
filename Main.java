package css217;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        LegacyBulb rawBulb = new LegacyBulb();
        LegacyThermostat rawThermostat = new LegacyThermostat();

        BulbAdapter bulbAdapter = new BulbAdapter(rawBulb);
        ThermostatAdapter thermostatAdapter =
                new ThermostatAdapter(rawThermostat);

        List<SmartDevice> devices =
                List.of(bulbAdapter, thermostatAdapter);

        ModernHub hub = new ModernHub(devices);
        

        // ModernHub badHub = new ModernHub(List.of(rawBulb)); // COMPILE ERROR
        /*
         LegacyBulb cannot be used directly because it does not implement
         SmartDevice. BulbAdapter implements SmartDevice and connects
         LegacyBulb with ModernHub without changing LegacyBulb.
        */

        System.out.println("Activate devices:");

        hub.activateAll();

        System.out.println("Bulb brightness: " + rawBulb.readBrightness());
        System.out.println("Thermostat: " + rawThermostat.checkDial());

        System.out.println("Bulb power: "
                + bulbAdapter.getPowerPercent() + "%");

        System.out.println("Thermostat power: "
                + thermostatAdapter.getPowerPercent() + "%");

        System.out.println("Average power: "
                + hub.calculateAveragePowerUsage() + "%");

        rawBulb.breakFilament();

        System.out.println("\nBroken bulb:");
        System.out.println("isOn: " + bulbAdapter.isOn());
        System.out.println("power: "
                + bulbAdapter.getPowerPercent() + "%");

        rawThermostat.rotateDial("STUCK");

        System.out.println("\nWrong thermostat state:");
        System.out.println("isOn: " + thermostatAdapter.isOn());
        System.out.println("power: "
                + thermostatAdapter.getPowerPercent());
        hub.emergencyShutdown();

        System.out.println("\nAfter shutdown:");
        System.out.println("Bulb brightness: "
                + rawBulb.readBrightness());

        System.out.println("Thermostat: "
                + rawThermostat.checkDial());

        System.out.println("Average power: "
                + hub.calculateAveragePowerUsage() + "%");
    }
}