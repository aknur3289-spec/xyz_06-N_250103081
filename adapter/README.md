# Adapter Pattern

All Adapter Java source files are in this folder and use the css217 package.
BulbAdapter and ThermostatAdapter connect legacy devices to SmartDevice.
ModernHub activates devices, calculates average power usage, and performs shutdown.

From the repository root:

```cmd
javac -d adapter/bin adapter/*.java
java -cp adapter/bin css217.Main
```

Main demonstrates activation, power readings, a broken bulb, an invalid thermostat
state, and emergency shutdown. Invalid thermostat states report -1 power as a
fault indicator. After shutdown both devices report zero power.
