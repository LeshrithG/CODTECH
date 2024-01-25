import java.util.Scanner;

class Calculator {
    public static void main(String[] args) {
        double a, b, result;

        char operator;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number : ");
        a = sc.nextDouble();
        System.out.print("Enter the operator (+, -, *, / ,% , ^ ): ");
        operator = sc.next().charAt(0);
        System.out.print("Enter second number : ");
        b = sc.nextDouble();

        switch (operator) {
            case '+':
                result = a + b;
                System.out.println("Result: " + result);
                break;
            case '-':
                result = a - b;
                System.out.println("Result: " + result);
                break;
            case '*':
                result = a * b;
                System.out.println("Result: " + result);
                break;
            case '/':
                if (b != 0) {
                    result = a / b;
                    System.out.println("Result: " + result);
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
            case '%':
                result = a % b;
                System.out.println("Result: " + result);
                break;
            case '^':
                result = Math.pow(a, b);
                System.out.println("Result: " + result);
                break;
            default:
                System.out.println("Error: Invalid operator");
        }
    }
}
