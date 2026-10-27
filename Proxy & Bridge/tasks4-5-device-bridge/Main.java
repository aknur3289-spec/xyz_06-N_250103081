// Tasks 4 and 5: Smart Light and Party Remote - Bridge


class SmartLight implements Device {
    public void turnOn() {
        System.out.println("Smart Light glows bright white.");
    }
    public void turnOff() {
        System.out.println("Smart Light shuts off.");
    }
    public void setVolume(int level) {
        System.out.println("Smart Light brightness set to: "+level+"%");
    }
}

class PartyRemote extends BasicRemote {
    public PartyRemote(Device device) {
        super(device);
    }
    public void partyMode() {
        System.out.println("[Party Remote] Pumping up the party!");
        device.turnOn();
        device.setVolume(100);
    }
}

// ==========================================
// STEP 1: THE MACHINE (DOES THE RAW WORK)
// ==========================================

// The rule: Every machine must be able to turn on, off, and change volume
interface Device {
    // Turn the machine on
    void turnOn();
    // Turn the machine off
    void turnOff();
    // Set the machine's volume
    void setVolume(int volume);
}

// Machine 1: A TV
class Tv implements Device {
    // The TV's volume level
    int volume = 20;

    // What happens when you turn on a TV
    public void turnOn() {
        // Print proof the TV screen lit up
        System.out.println("TV screen powers ON.");
    }

    // What happens when you turn off a TV
    public void turnOff() {
        // Print proof the TV screen went black
        System.out.println("TV screen powers OFF.");
    }

    // How the TV sets volume
    public void setVolume(int volume) {
        // Update the TV's volume variable
        this.volume = volume;
        // Print the TV's new volume
        System.out.println("TV volume set to: " + this.volume);
    }
}

// Machine 2: A Radio
class Radio implements Device {
    // The Radio's volume level
    int volume = 10;

    // What happens when you turn on a Radio
    public void turnOn() {
        // Print proof the Radio started playing audio
        System.out.println("Radio starts playing static/music.");
    }

    // What happens when you turn off a Radio
    public void turnOff() {
        // Print proof the Radio went silent
        System.out.println("Radio goes silent.");
    }

    // How the Radio sets volume
    public void setVolume(int volume) {
        // Update the Radio's volume variable
        this.volume = volume;
        // Print the Radio's new volume
        System.out.println("Radio volume knob turned to: " + this.volume);
    }
}

// ==========================================
// STEP 2: THE CONTROLLER (THE REMOTE YOU HOLD)
// ==========================================

// The basic remote controller
class BasicRemote {
    // THIS VARIABLE IS THE BRIDGE!
    // It's just a blank slot that can hold ANY machine (TV, Radio, whatever)
    protected Device device;

    // When you buy the remote, you pair it with a machine
    public BasicRemote(Device device) {
        // Store that machine inside this remote
        this.device = device;
    }

    // Pressing the Power On button on the remote
    public void powerOn() {
        // The remote doesn't turn itself on; it tells the machine to turn on!
        device.turnOn();
    }

    // Pressing the Power Off button on the remote
    public void powerOff() {
        // The remote tells the machine to turn off
        device.turnOff();
    }
}

// An upgraded remote that has an extra "Mute" button
// It borrows everything from BasicRemote using "extends"
class AdvancedRemote extends BasicRemote {

    // Pair this upgraded remote with a machine
    public AdvancedRemote(Device device) {
        // Send the machine up to BasicRemote so it can store it in the slot
        super(device);
    }

    // The special feature only this remote has: A MUTE BUTTON
    public void mute() {
        // Print an alert that mute was clicked
        System.out.println("[Remote] Mute button pressed!");
        // Tell whichever machine is plugged into this remote to drop volume to 0
        device.setVolume(0);
    }
}

// ==========================================
// STEP 3: RUNNING IT (PLUGGING THEM TOGETHER)
// ==========================================
public class Main {
    public static void main(String[] args) {
        // Task 4: Pair the new SmartLight with the existing remote.
        Device light = new SmartLight();
        AdvancedRemote remote = new AdvancedRemote(light);
        remote.powerOn();
        remote.mute();
        // Task 5: Use the new PartyRemote with the existing Radio.
        new PartyRemote(new Radio()).partyMode();
    }
}
