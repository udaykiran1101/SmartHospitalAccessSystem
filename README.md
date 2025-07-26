# Smart Hospital Access System

A Java-based system for managing secure access and patient monitoring in a hospital environment. This project demonstrates the use of OOP principles, encryption, logging, and design patterns in a healthcare context.

## Features
- **Role-based Room Access**: Doctors, nurses, admins, patients, and visitors have different access rights to rooms (ICU, Ward, etc.) based on their roles and clearance levels.
- **Vital Monitoring**: Simulates sensors for temperature, heart rate, and oxygen levels. Alerts are generated for critical readings.
- **Encrypted Logging**: All access attempts and vital sign logs are encrypted for security.
- **CLI Interface**: Command-line interface for managing patients, assigning rooms, checking vitals, and viewing logs.
- **Extensible Design**: Uses abstract classes and interfaces for easy extension (add new roles, rooms, or sensors).

## Project Structure
```
src/
  main/
    java/
      app/           # Main entry point
      model/
        hospital/    # Hospital system logic
        monitor/     # Sensors and vital monitoring
        roles/       # Person roles (Doctor, Nurse, Patient, etc.)
        room/        # Room types and access rules
        utils/       # Utilities (encryption, logging)
      ui/            # CLI and JavaFX UI (if extended)
logs/                # Encrypted access and vitals logs
```

## How It Works
- **Access Control**: Each room defines allowed roles and a security level. Persons request access, and the system checks their role and clearance.
- **Vital Monitoring**: Sensors generate random but realistic values. The system checks for critical values and logs them.
- **Logging**: All logs are encrypted using AES and can be decrypted for viewing via the CLI.

## Getting Started
1. **Requirements**:
   - Java 17+
   - Maven

2. **Build and Run**:
   ```sh
   mvn clean compile
   mvn exec:java -Dexec.mainClass="main.app.Main"
   ```

3. **Usage**:
   - Add patients, assign rooms, attempt access, run vital checks, and view logs via the CLI menu.

## Design Patterns Used
- **Factory/Template Method**: Abstract classes for roles and rooms.
- **Strategy**: Sensor implementations.
- **Singleton (static utility)**: Logger and Encryptor.

## Extending the System
- Add new roles by extending `Person`.
- Add new room types by extending `Room`.
- Add new sensors by extending `Sensor`.

## Security
- All logs are AES-encrypted for privacy.


