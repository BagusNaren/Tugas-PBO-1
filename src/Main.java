import Auth.Login;
import Controller.Admin;
import Controller.Customer;
import Menu.Menu;
import Utils.Clear;
import Utils.Input;

public class Main {
    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            Clear.clearScreen();
            Menu.tampilanLogin();

            int pilihan = Input.nextInt("");

            switch (pilihan) {
                case 1:
                    prosesLogin();
                    break;
                case 2:
                case 0:
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

    private static void prosesLogin() {
        Clear.clearScreen();
        Menu.headerUsernameDanPassword();

        String username = Input.nextLine("Username: ");
        String password = Input.nextLine("Password: ");

        String role = Login.login(username, password);

        switch (role) {
            case "admin":
                Menu.loggedInGreetingAdmin(username);
                new Admin().menu();
                break;
            case "customer":
                Menu.loggedInGreetingCustomer(username);
                new Customer().menu();
                break;
            default:
                Menu.errorLogin();
                break;
        }
    }
}
