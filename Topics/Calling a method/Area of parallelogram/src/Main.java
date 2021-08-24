import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // call the method here
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        countAreaOfParallelogram(a, b);
        char[] array = new char[-1];
        char[] array2 = new char[1];

        char[] array3 = { 'a', 'b', 'c', 'd' };
        char[] array4 = new char[0];
    }

    // Do not change code below   
    public static void countAreaOfParallelogram(int b, int h) {
        System.out.println(b * h);
    }
}