import Auth.Login;
import Controller.Admin;
import Controller.Customer;
import Utils.Clear;
import Utils.Input;

public class Main {
    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            Clear.clearScreen();
            tampilkanMenuUtama();

            int pilihan = Input.nextInt("Pilih menu: ");

            switch (pilihan) {
                case 1:
                    prosesLogin();
                    break;
                case 2:
                    running = false;
                    System.out.println("Terima kasih telah menggunakan aplikasi investasi!");
                    Input.pressEnter();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    Input.pressEnter();
                    break;
            }
        }
    }

    private static void tampilkanMenuUtama() {
        System.out.println("+==================================+");
        System.out.println("|      Aplikasi Investasi          |");
        System.out.println("+==================================+");
        System.out.println("| 1. Login                         |");
        System.out.println("| 2. Keluar                        |");
        System.out.println("+==================================+");
    }

    private static void prosesLogin() {
        Clear.clearScreen();
        String username = Input.nextLine("Username: ");
        String password = Input.nextLine("Password: ");

        String role = Login.login(username, password);

        switch (role) {
            case "admin":
                new Admin().menu();
                break;
            case "customer":
                new Customer().menu();
                break;
            default:
                System.out.println("+==================================+");
                System.out.println("|           Login gagal!           |");
                System.out.println("|  Username atau password salah.   |");
                System.out.println("+==================================+");
                Input.pressEnter();
                break;
        }
    }
}
