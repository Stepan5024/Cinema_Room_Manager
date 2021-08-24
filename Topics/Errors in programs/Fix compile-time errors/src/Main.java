import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str1;
        String str2 = "123";

        if (str2.equals(str1 = "123")) {
            str2 = null;
        }

        str1 = str2;
        str2 = str1;

        System.out.println(str2);
    }
    public static void checkTheCode (String input) {
        boolean result = Boolean.parseBoolean(input);
        result = !result;
        String output = String.valueOf(result);
        System.out.println(output);
    }
}