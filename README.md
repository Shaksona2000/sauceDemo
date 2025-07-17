# SauceDemo Test Automation Framework

This is a Selenium WebDriver test automation framework for testing the SauceDemo website. The framework includes video recording functionality for test execution.

## Features

- Automated test cases for SauceDemo website
- Video recording of test executions
- Maven-based project structure
- TestNG test runner
- Page Object Model (POM) design pattern

## Prerequisites

- Java JDK 11 or higher
- Maven 3.6.0 or higher
- Chrome/Firefox browser installed
- Internet connection

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/Shaksona2000/sauceDemo.git
   ```

2. Navigate to the project directory:
   ```bash
   cd sauceDemo
   ```

3. Run the tests using Maven:
   ```bash
   mvn clean test
   ```

## Project Structure

```
├── src/
│   ├── main/java/org/myProject/
│   │   ├── Listeners/      # Test listeners
│   │   ├── Pages/          # Page object classes
│   │   └── Utils/          # Utility classes
│   └── test/java/myProject/
│       └── Tests/          # Test classes
├── recordings/             # Recorded test executions
├── testNg.xml              # TestNG configuration
└── pom.xml                # Maven configuration
```

## Running Tests

Run all tests:
```bash
mvn test
```

Run specific test class:
```bash
mvn test -Dtest=LoginTest
```

## Video Recording

Test executions are automatically recorded and saved in the `recordings/` directory.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
