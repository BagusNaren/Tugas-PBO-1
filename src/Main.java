import Auth.Login;
import Controller.Admin;
import Controller.Customer;
import Utils.Clear;
import Utils.Input;
import Utils.InvalidInputException;
import Menu.Menu;

public class Main {
    public static void main(String[] args) {
        boolean running = true; // Variabel untuk mengontrol perulangan aplikasi

        while (running) { // Selama 'running' true, program akan terus berjalan
            Clear.clearScreen();
            Menu.tampilanLogin();

            try {
                int pilihan = Input.nextInt(""); // Menerima input pilihan dari user

                switch (pilihan) { // Menentukan aksi berdasarkan input user
                    case 1:
                        prosesLogin("admin"); // Proses login untuk Admin
                        break;
                    case 2:
                        prosesLogin("customer"); // Proses login untuk Customer
                        break;
                    case 0:
                        running = false;
                        Clear.clearScreen();
                        Menu.ucapanTerimaKasih();
                        break;
                    default:
                        Menu.pesanGagal("Pilihan tidak valid");
                        break;
                }
            } catch (InvalidInputException e) {
                Menu.pesanGagal(e.getMessage());
            }
        }
    }

    // Method untuk memproses login berdasarkan role yang diharapkan (admin atau customer)
    private static void prosesLogin(String expectedRole) {
        Clear.clearScreen();
        Menu.headerUsernameDanPassword();

        try {
            String username = Input.nextLine("Username: ");
            String password = Input.nextLine("Password: ");

            String role = Login.login(username, password);

            if (role.equals(expectedRole)) {
                if (role.equals("admin")) {
                    Menu.loggedInGreetingAdmin();
                    new Admin().menu();
                } else {
                    Menu.loggedInGreetingCustomer();
                    new Customer().menu();
                }
            } else {
                Menu.errorLogin();
            }
        } catch (InvalidInputException e) {
            Menu.pesanGagal(e.getMessage());
        }
    }
}
