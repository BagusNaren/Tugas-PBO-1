package Controller;

import Menu.Menu;
import Utils.Clear;
import Utils.Input;
import View.View;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private static Map<String, Integer> sahamCustomer = new HashMap<String, Integer>();
    private static Map<String, Integer> sbnCustomer = new HashMap<String, Integer>();

    public void menu() {
        boolean running = true;
        while (running) {
            Clear.clearScreen();
            Menu.customerMenu();
            int pilihan = Input.nextInt("");

            switch (pilihan) {
                case 1:
                    Menu.beliSaham();
                    Purchase.buyStock(sahamCustomer);
                    break;
                case 2:
                    Menu.jualSaham();
                    Purchase.sellStock(sahamCustomer);
                    break;
                case 3:
                    Menu.beliSBN();
                    Purchase.buySBN(sbnCustomer);
                    break;
                case 4:
                    Menu.simulasiSBN();
                    Purchase.simulasiSBN();
                    break;
                case 5:
                    Menu.lihatPortofolio();
                    View.showPortofolio(sahamCustomer, sbnCustomer);
                    break;
                case 6:
                    Menu.menuLihatSaham();
                    View.showSahamList(Admin.getSahamList());
                    Menu.tekanEnterUntukLanjut();
                    break;
                case 7:
                    Menu.menuLihatSBN();
                    View.showSbnList(Admin.getSbnList());
                    Menu.tekanEnterUntukLanjut();
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }
    }
}
