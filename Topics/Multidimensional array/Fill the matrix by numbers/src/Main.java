import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) System.out.print(Math.abs(i - j) + " ");
            System.out.println();
        }

    }
}