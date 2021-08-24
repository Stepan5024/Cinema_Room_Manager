import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        long a = Long.parseLong(scanner.next());
        String s = scanner.next();
        long b = Long.parseLong(scanner.next());
        switch (s) {
            case "+":
                System.out.println(a + b);
                break;
            case "-":
                System.out.println(a - b);
                break;
            case "*":
                System.out.println(a * b);
                break;
            case "/":
                if (b == 0)
                    System.out.println("Division by 0!");

                else
                    System.out.println(a / b);
                break;
            default:
                System.out.println("Unknown operator");
                break;
        }
    }
}