package Utils;

import Menu.Menu;

public class Clear {
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            Menu.pesanGagal("Tidak dapat membersihkan layar: " + e.getMessage());
        }
    }
}
