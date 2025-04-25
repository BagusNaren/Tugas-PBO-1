package Utils;

import Menu.Menu;
import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static String nextLine(String message) {
        String input;
        do {
            System.out.print(message);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                Menu.pesanGagal("Input tidak boleh kosong. Silakan coba lagi.");
            }
        } while (input.isEmpty());
        return input;
    }

    public static int nextInt(String message) {
        int number = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print(message);
            String input = scanner.nextLine();
            try {
                number = Integer.parseInt(input.trim());
                valid = true;
            } catch (NumberFormatException e) {
                Menu.pesanGagal("Input harus berupa angka. Silakan coba lagi.");
            }
        }
        return number;
    }

    public static double nextDouble(String message) {
        double number = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print(message);
            String input = scanner.nextLine();
            try {
                number = Double.parseDouble(input.trim());
                valid = true;
            } catch (NumberFormatException e) {
                Menu.pesanGagal("Input harus berupa angka (desimal). Silakan coba lagi.");
            }
        }
        return number;
    }

    public static void waitForEnter() {
        String input;
        do {
            System.out.print(">> Tekan Enter setelah mengetik sesuatu untuk melanjutkan:...");
            input = scanner.nextLine();
        } while (!input.isEmpty());
    }
}