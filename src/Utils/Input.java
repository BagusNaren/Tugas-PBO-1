package Utils;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static String nextLine(String message) throws InvalidInputException {
        System.out.print(message);
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            throw new InvalidInputException("Input tidak boleh kosong");
        }
        return input;
    }

    public static int nextInt(String message) throws InvalidInputException {
        System.out.print(message);
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Input harus berupa angka");
        }
    }

    public static double nextDouble(String message) throws InvalidInputException {
        System.out.print(message);
        String input = scanner.nextLine();
        try {
            return Double.parseDouble(input.trim());
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Input harus berupa angka (desimal)");
        }
    }
}
