# Structural Design Patterns in Java

**Student:** Aknur Zhanysbay  
**Course:** CSS 217 – Software Design Patterns  
**Language:** Java

## Project Description

This repository contains Java implementations of four Structural Design Patterns: Adapter, Decorator, Proxy, and Bridge.

Each pattern demonstrates how classes and objects can be organized to create flexible, reusable, and maintainable code.

## Project Structure

```text
xyz_250103081_06-N/
│
├── Main.java
├── BulbAdapter.java
├── LegacyBulb.java
├── LegacyThermostat.java
├── ModernHub.java
├── SmartDevice.java
├── ThermostatAdapter.java
│
├── adapter/
│   └── Main.java
│
├── patterns/
│   ├── Main.java
│   │
│   ├── decorator/
│   │   ├── Main.java
│   │   ├── Pizza.java
│   │   ├── PlainPizza.java
│   │   ├── PizzaDecorator.java
│   │   ├── Cheese.java
│   │   ├── Olives.java
│   │   └── Pineapple.java
│   │
│   ├── proxy/
│   │   ├── Main.java
│   │   ├── Video.java
│   │   ├── RealVideo.java
│   │   └── VideoProxy.java
│   │
│   └── bridge/
│       ├── Main.java
│       ├── Shape.java
│       ├── Color.java
│       ├── Circle.java
│       ├── Red.java
│       └── Blue.java
│
└── README.md
```

## 1. Adapter Pattern

**Location:** Root directory and `adapter/`

The Adapter Pattern allows incompatible interfaces to work together.

**Files:**
- `SmartDevice.java` – Defines the common interface.
- `LegacyBulb.java` – Represents an existing light bulb.
- `LegacyThermostat.java` – Represents an existing thermostat.
- `BulbAdapter.java` – Adapts the legacy bulb to the SmartDevice interface.
- `ThermostatAdapter.java` – Adapts the legacy thermostat.
- `ModernHub.java` – Manages smart devices.
- `Main.java` – Demonstrates the Adapter Pattern.

## 2. Decorator Pattern

**Location:** `patterns/decorator/`

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

**Location:** `patterns/proxy/`

The Proxy Pattern provides a substitute object that controls access to another object.

**Example:** Video Access

**Files:**
- `Video.java` – Defines the video interface.
- `RealVideo.java` – Implements the real video functionality.
- `VideoProxy.java` – Controls access to the real video.
- `Main.java` – Demonstrates the Proxy Pattern.

## 4. Bridge Pattern

**Location:** `patterns/bridge/`

The Bridge Pattern separates abstraction from implementation so that both can change independently.

**Example:** Shapes and Colors

**Files:**
- `Color.java` – Defines the color interface.
- `Red.java` – Red color implementation.
- `Blue.java` – Blue color implementation.
- `Shape.java` – Defines the shape abstraction.
- `Circle.java` – Implements a circle using a color.
- `Main.java` – Demonstrates the Bridge Pattern.

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