package Controller;

import Menu.Menu;
import Utils.Clear;
import Utils.Input;
import View.View;
import Model.Saham;
import Model.SuratBerhargaNegara;

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
                    Purchase.buyStock(sahamCustomer);
                    break;
                case 2:
                    Purchase.sellStock(sahamCustomer);
                    break;
                case 3:
                    Purchase.buySBN(sbnCustomer);
                    break;
                case 4:
                    Purchase.simulasiSBN();
                    break;
                case 5:
                    View.showPortofolio(sahamCustomer, sbnCustomer);
                    break;
                case 6:
                    View.showSahamList(Admin.getSahamList());
                    Menu.tekanEnterUntukLanjut();
                    break;
                case 7:
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
