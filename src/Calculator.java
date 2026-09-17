import java.util.Scanner;

/**
 * Command-Line Calculator Application in Java
 * 
 * Features:
 * - Basic arithmetic operations: Addition, Subtraction, Multiplication, Division
 * - User input handling using Scanner
 * - Input validation for numbers and operators
 * - Error handling for division by zero
 * - Interactive console interface with loop execution
 */
public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;

        printHeader();

        while (continueCalculating) {
            System.out.println("\n-------------------------------------------");
            
            // Step 1: Input first number
            double num1 = getValidDouble(scanner, "Enter first number: ");

            // Step 2: Input arithmetic operator (+, -, *, /)
            char operator = getValidOperator(scanner);

            // Step 3: Input second number
            double num2 = getValidDouble(scanner, "Enter second number: ");

            // Step 4: Perform calculation and display output
            try {
                double result = calculate(num1, num2, operator);
                System.out.printf("%nResult: %.4f %c %.4f = %.4f%n", num1, operator, num2, result);
            } catch (ArithmeticException e) {
                System.out.println("\nError: " + e.getMessage());
            }

            // Step 5: Ask user if they want to perform another calculation
            continueCalculating = askToContinue(scanner);
        }

        System.out.println("\nThank you for using Command-Line Calculator. Goodbye!");
        scanner.close();
    }

    /**
     * Prints welcome header.
     */
    private static void printHeader() {
        System.out.println("===========================================");
        System.out.println("       JAVA COMMAND-LINE CALCULATOR        ");
        System.out.println("===========================================");
    }

    /**
     * Prompt for and validate numeric input.
     */
    public static double getValidDouble(Scanner scanner, String prompt) {
        double number = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                number = scanner.nextDouble();
                isValid = true;
            } else {
                System.out.println("Invalid input! Please enter a valid numerical value.");
                scanner.next(); // Clear invalid token
            }
        }
        return number;
    }

    /**
     * Prompt for and validate operator input (+, -, *, /).
     */
    public static char getValidOperator(Scanner scanner) {
        char operator = ' ';
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Enter operator (+, -, *, /): ");
            String input = scanner.next().trim();

            if (input.length() == 1) {
                char op = input.charAt(0);
                if (op == '+' || op == '-' || op == '*' || op == '/') {
                    operator = op;
                    isValid = true;
                } else {
                    System.out.println("Invalid operator! Supported operators are: +, -, *, /");
                }
            } else {
                System.out.println("Invalid operator length! Please enter a single operator.");
            }
        }
        return operator;
    }

    /**
     * Dispatches calculation based on operator.
     */
    public static double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return add(num1, num2);
            case '-':
                return subtract(num1, num2);
            case '*':
                return multiply(num1, num2);
            case '/':
                return divide(num1, num2);
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
    }

    /**
     * Performs addition of two numbers.
     */
    public static double add(double a, double b) {
        return a + b;
    }

    /**
     * Performs subtraction of two numbers.
     */
    public static double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Performs multiplication of two numbers.
     */
    public static double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Performs division of two numbers with zero check.
     */
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }

    /**
     * Asks user whether to perform another calculation.
     */
    private static boolean askToContinue(Scanner scanner) {
        while (true) {
            System.out.print("\nWould you like to calculate again? (y/n): ");
            String choice = scanner.next().trim().toLowerCase();
            if (choice.equals("y") || choice.equals("yes")) {
                return true;
            } else if (choice.equals("n") || choice.equals("no")) {
                return false;
            } else {
                System.out.println("Invalid response. Please enter 'y' for yes or 'n' for no.");
            }
        }
    }
}
