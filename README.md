# Command-Line Calculator

A clean, modular Java console application that performs basic arithmetic operations based on user input. Built using Java 8, `Scanner` for user input handling, and object-oriented practices with error protection.

## Features

- **Basic Arithmetic Operations**:
  - Addition (`+`)
  - Subtraction (`-`)
  - Multiplication (`*`)
  - Division (`/`)
- **Robust Input Validation**:
  - Handles non-numeric inputs gracefully without crashing.
  - Validates operator selection.
- **Error Handling**:
  - Prevents division by zero with user-friendly error messages.
- **Interactive CLI Experience**:
  - Repeats calculation workflow until the user chooses to exit.

## Project Structure

```text
CommandLine_Calculator/
├── src/
│   └── Calculator.java    # Main Java application source code
├── .gitignore             # Git ignore rules for Java build artifacts
└── README.md              # Project documentation
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher installed on your system.

### How to Build & Run

1. **Clone the repository**:
   ```bash
   git clone https://github.com/pranamprabhu/CommandLine_Calculator.git
   cd CommandLine_Calculator
   ```

2. **Compile the Java source code**:
   ```bash
   javac -d bin src/Calculator.java
   ```

3. **Run the application**:
   ```bash
   java -cp bin Calculator
   ```

## Example Output

```text
===========================================
       JAVA COMMAND-LINE CALCULATOR        
===========================================

-------------------------------------------
Enter first number: 10
Enter operator (+, -, *, /): /
Enter second number: 0

Error: Division by zero is not allowed.

Would you like to calculate again? (y/n): y

-------------------------------------------
Enter first number: 25.5
Enter operator (+, -, *, /): *
Enter second number: 2

Result: 25.5000 * 2.0000 = 51.0000

Would you like to calculate again? (y/n): n

Thank you for using Command-Line Calculator. Goodbye!
```

## License

This project is open-source and available under the [MIT License](LICENSE).
