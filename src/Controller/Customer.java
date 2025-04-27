package Controller;

import Menu.Menu;
import Utils.Clear;
import Utils.Input;
import Utils.InvalidInputException;
import View.View;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    // Menyimpan data saham yang dimiliki customer (kode saham -> jumlah lembar)
    private static final Map<String, Integer> sahamCustomer = new HashMap<>();
    // Menyimpan data SBN yang dimiliki customer (nama SBN -> nominal investasi)
    private static final Map<String, Integer> sbnCustomer = new HashMap<>();

    // Menu utama customer
    public void menu() {
        boolean running = true;
        while (running) {
            try {
                Clear.clearScreen();
                Menu.customerMenu();
                int pilihan = Input.nextInt("");

                // Validasi pilihan menu
                if (pilihan < 1 || pilihan > 8) {
                    throw new InvalidInputException("Pilihan tidak valid");
                }

                // Aksi berdasarkan pilihan
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
                        View.showPortofolio(sahamCustomer, sbnCustomer, Admin.getSahamList(), Admin.getSbnList());
                        Menu.tekanEnterUntukKembali();
                        break;
                    case 6:
                        View.showSahamList(Admin.getSahamList());
                        Menu.tekanEnterUntukKembali();
                        break;
                    case 7:
                        View.showSbnList(Admin.getSbnList());
                        Menu.tekanEnterUntukKembali();
                        break;
                    case 8:
                        running = false;
                        break;
                }
            } catch (InvalidInputException e) {
                Menu.pesanGagal(e.getMessage());
            }
        }
    }
}
