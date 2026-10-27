# Structural Design Patterns in Java

**Student:** Aknur Zhanysbay  
**Course:** CSS 217 – Software Design Patterns  
**Language:** Java

## Project Description

This repository contains Java implementations of four Structural Design Patterns: Adapter, Decorator, Proxy, and Bridge.

Each pattern demonstrates how classes and objects can be organized to create flexible, reusable, and maintainable code.

## Project Structure

```text
xyz_06-N_250103081/
|-- adapter/                 # Adapter source files and run instructions
|-- decorator/               # Existing Decorator, Proxy and Bridge examples
|-- Proxy & Bridge/          # Worksheet Tasks 1-6 and original boilerplate
|-- .gitignore
`-- README.md
```

## 1. Adapter Pattern

**Location:** [adapter/](adapter/README.md)

The Adapter Pattern allows incompatible interfaces to work together.

**Files:**
- `SmartDevice.java` – Defines the common interface.
- `LegacyBulb.java` – Represents an existing light bulb.
- `LegacyThermostat.java` – Represents an existing thermostat.
- `BulbAdapter.java` – Adapts the legacy bulb to the SmartDevice interface.
- `ThermostatAdapter.java` – Adapts the legacy thermostat.
- `ModernHub.java` – Manages smart devices.
- `Main.java` – Demonstrates the Adapter Pattern.

Run the Adapter example from the repository root:

```cmd
javac -d adapter/bin adapter/*.java
java -cp adapter/bin css217.Main
```

## 2. Decorator Pattern

**Location:** `decorator/decorator/`

The Decorator Pattern allows additional features to be added dynamically without changing the original object.

**Example:** Custom Pizza Builder

**Files:**
- `Pizza.java` – Base pizza interface.
- `PlainPizza.java` – Basic pizza implementation.
- `PizzaDecorator.java` – Base decorator class.
- `Cheese.java` – Adds cheese topping.
- `Olives.java` – Adds olives topping.
- `Pineapple.java` – Adds pineapple topping.
- `Main.java` – Demonstrates combining toppings and calculating the total price.

## 3. Proxy Pattern

**Location:** `decorator/proxy/`

The Proxy Pattern provides a substitute object that controls access to another object.

**Example:** Video Access

**Files:**
- `Video.java` – Defines the video interface.
- `RealVideo.java` – Implements the real video functionality.
- `VideoProxy.java` – Controls access to the real video.
- `Main.java` – Demonstrates the Proxy Pattern.

## 4. Bridge Pattern

**Location:** `decorator/bridge/`

The Bridge Pattern separates abstraction from implementation so that both can change independently.

**Example:** Shapes and Colors

**Files:**
- `Color.java` – Defines the color interface.
- `Red.java` – Red color implementation.
- `Blue.java` – Blue color implementation.
- `Shape.java` – Defines the shape abstraction.
- `Circle.java` – Implements a circle using a color.
- `Main.java` – Demonstrates the Bridge Pattern.

## Proxy & Bridge Lab Worksheet - Tasks 1-6

**Location:** [Proxy & Bridge](<Proxy & Bridge/README.md>) - a top-level folder beside `adapter/` and `decorator/`.

All six worksheet tasks are implemented using the supplied `proxy_boilerplate.zip`
and `bridge_boilerplate.zip` examples. Original source files and the Proxy diagram
are preserved in `Proxy & Bridge/boilerplate/`.

| Task | Exercise | Source file |
| --- | --- | --- |
| Task 1 | The Bouncer: ADMIN/GUEST image protection and lazy loading | [Main.java](<Proxy & Bridge/task1-image-proxy/Main.java>) |
| Task 2 | The View Counter: audit counter and lazy video loading | [Main.java](<Proxy & Bridge/task2-video-proxy/Main.java>) |
| Task 3 | School Wi-Fi Firewall: block gaming.com and socialmedia.com | [Main.java](<Proxy & Bridge/task3-firewall/Main.java>) |
| Task 4 | The New Machine: SmartLight with AdvancedRemote | [Main.java](<Proxy & Bridge/tasks4-5-device-bridge/Main.java>) |
| Task 5 | The New Button: PartyRemote with Radio at volume 100 | [Main.java](<Proxy & Bridge/tasks4-5-device-bridge/Main.java>) |
| Task 6 | RPG Weapon System: Knight/Wizard with Sword or MagicWand | [Main.java](<Proxy & Bridge/task6-weapon-bridge/Main.java>) |

Tasks 4 and 5 are in the same file, with separate task comments. Each task example
has expected-output.txt. The original message/sender Bridge example is also
available in example-message-bridge/.

Run one task at a time from the repository root:

```cmd
cd "Proxy & Bridge/task1-image-proxy"
javac -d bin Main.java
java -cp bin Main
```

See the [lab README](<Proxy & Bridge/README.md>) for instructions and boilerplate details.

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Structural Design Patterns
- Git and GitHub

## AI Assistance

AI tools, including ChatGPT, were used as learning and development assistance during this project.

AI assistance included:
- Explaining structural design pattern concepts.
- Helping understand Java class relationships.
- Assisting with debugging and error fixing.
- Providing guidance on project organization.
- Helping with Git and GitHub commands.
- Assisting with README documentation.

The project was completed as part of the student's Java design patterns coursework.

## Author

**Aknur Zhanysbay**

GitHub: [aknur3289-spec](https://github.com/aknur3289-spec)