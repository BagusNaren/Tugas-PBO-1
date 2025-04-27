package Utils;

import java.util.Scanner;

public class Input {
    // Membuat satu instance Scanner untuk membaca input dari konsol
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Membaca input berupa String dari user dengan menampilkan pesan terlebih dahulu.
     * Melakukan validasi agar input tidak kosong.
     *
     * @param message Pesan yang ditampilkan ke user sebelum input
     * @return Input user dalam bentuk String
     * @throws InvalidInputException jika input kosong
     */
    public static String nextLine(String message) throws InvalidInputException {
        System.out.print(message);
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            throw new InvalidInputException("Input tidak boleh kosong");
        }
        return input;
    }

    /**
     * Membaca input berupa bilangan bulat (integer) dari user dengan menampilkan pesan terlebih dahulu.
     * Melakukan validasi agar input benar-benar berupa angka.
     *
     * @param message Pesan yang ditampilkan ke user sebelum input
     * @return Input user dalam bentuk integer
     * @throws InvalidInputException jika input bukan angka yang valid
     */
    public static int nextInt(String message) throws InvalidInputException {
        System.out.print(message);
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Input harus berupa angka");
        }
    }

    /**
     * Membaca input berupa bilangan desimal (double) dari user dengan menampilkan pesan terlebih dahulu.
     * Melakukan validasi agar input benar-benar berupa angka desimal.
     *
     * @param message Pesan yang ditampilkan ke user sebelum input
     * @return Input user dalam bentuk double
     * @throws InvalidInputException jika input bukan angka desimal yang valid
     */
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
