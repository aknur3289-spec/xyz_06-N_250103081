package css217;
public class ThermostatAdapter implements SmartDevice {
    private final LegacyThermostat thermostat;

    public ThermostatAdapter(LegacyThermostat thermostat) {
        if (thermostat == null) {
            throw new IllegalArgumentException("Thermostat is null");
        }
        

        this.thermostat = thermostat;
    }

    @Override
    public void turnOn() {
        String state = thermostat.checkDial();

        if ("IDLE".equals(state)) {
            thermostat.rotateDial("LOW");
        }
    }

    @Override
    public void turnOff() {
        thermostat.rotateDial("IDLE");
    }

    @Override
    public boolean isOn() {
        String state = thermostat.checkDial();

        if ("LOW".equals(state)) {
            return true;
        }

        if ("MEDIUM".equals(state)) {
            return true;
        }

        if ("MAX".equals(state)) {
            return true;
        }

        return false;
    }

    @Override
    public int getPowerPercent() {
        String state = thermostat.checkDial();

        if ("IDLE".equals(state)) {
            return 0;
        } else if ("LOW".equals(state)) {
            return 33;
        } else if ("MEDIUM".equals(state)) {
            return 66;
        } else if ("MAX".equals(state)) {
            return 100;
        } else {
            return -1;
        }
    }
}