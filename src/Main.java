import Auth.Login;
import Controller.Admin;
import Controller.Customer;
import Utils.Clear;
import Utils.Input;
import Utils.InvalidInputException;
import Menu.Menu;

public class Main {
    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            Clear.clearScreen();
            Menu.tampilanLogin();

            try {
                int pilihan = Input.nextInt("");

                switch (pilihan) {
                    case 1:
                        prosesLogin("admin");
                        break;
                    case 2:
                        prosesLogin("customer");
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
