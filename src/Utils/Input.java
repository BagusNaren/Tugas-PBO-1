package Utils;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static String nextLine(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public static int nextInt(String message) {
        System.out.print(message);
        return Integer.parseInt(scanner.nextLine());
    }

    public static double nextDouble(String s) {
        return 0;
    }

    public static void pressEnter() {

    }

    public static void waitForEnter() {
        System.out.println("Tekan Enter untuk melanjutkan...");
        new java.util.Scanner(System.in).nextLine();
    }
}
