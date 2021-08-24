import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        switch (type) {
            case "triangle":
                double a = scanner.nextInt();
                double b = scanner.nextInt();
                double c = scanner.nextInt();
                double p = (a + b + c) / 2;


                System.out.println(Math.sqrt(p * (p - a) * (p - b) * (p - c)));
                break;
            case "rectangle":
                double a1 = scanner.nextInt();
                double b1 = scanner.nextInt();
                System.out.println(a1 * b1);
                break;
            case "circle":
                double c1 = scanner.nextInt();
                System.out.println(3.14 * c1 * c1);
                break;

        }
    }
}