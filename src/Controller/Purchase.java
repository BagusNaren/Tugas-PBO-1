package Controller;

import Utils.Input;
import Utils.InvalidInputException;
import View.View;
import Model.Saham;
import Model.SuratBerhargaNegara;
import Menu.Menu;

import java.util.List;
import java.util.Map;

public class Purchase {
    public static void buyStock(Map<String, Integer> sahamCustomer) throws InvalidInputException {
        List<Saham> sahamList = Admin.getSahamList();
        View.showSahamList(sahamList);
        String kode = Input.nextLine("Masukkan kode saham: ");
        boolean ditemukan = false;

        for (Saham s : sahamList) {
            if (s.getKode().equalsIgnoreCase(kode)) {
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            Menu.pesanGagal("Saham tidak tersedia");
            return;
        }

        int jumlah;
        try {
            jumlah = Input.nextInt("Jumlah lembar: ");
        } catch (Exception e) {
            throw new InvalidInputException("Input jumlah lembar tidak valid");
        }

        sahamCustomer.put(kode, sahamCustomer.getOrDefault(kode, 0) + jumlah);
        Menu.pesanSukses("Berhasil membeli saham!");
    }

    public static void sellStock(Map<String, Integer> sahamCustomer) throws InvalidInputException {
        if (sahamCustomer.isEmpty()) {
            Menu.pesanGagal("Tidak ada saham yang dimiliki");
            return;
        }

        System.out.println("=======================================================================");
        System.out.println("||                        SAHAM YANG DIMILIKI                        ||");
        System.out.println("=======================================================================");
        System.out.printf("|| %-15s | %-47s ||%n", "Kode Saham", "Jumlah Lembar");
        System.out.println("----------------------------------------------------------------------");
        for (String kode : sahamCustomer.keySet()) {
            System.out.printf("|| %-15s | %-47s ||%n", kode, sahamCustomer.get(kode) + " lembar");
        }
        System.out.println("=======================================================================");

        String kode = Input.nextLine("Masukkan kode saham: ");
        int jumlah;
        try {
            jumlah = Input.nextInt("Jumlah lembar: ");
        } catch (Exception e) {
            throw new InvalidInputException("Input jumlah lembar tidak valid");
        }

        if (sahamCustomer.getOrDefault(kode, 0) >= jumlah) {
            sahamCustomer.put(kode, sahamCustomer.get(kode) - jumlah);
            if (sahamCustomer.get(kode) == 0) sahamCustomer.remove(kode);
            Menu.pesanSukses("Berhasil menjual saham!");
        } else {
            Menu.pesanGagal("Jumlah saham tidak mencukupi");
        }
    }

    public static void buySBN(Map<String, Integer> sbnCustomer) throws InvalidInputException {
        List<SuratBerhargaNegara> sbnList = Admin.getSbnList();
        View.showSBNList(sbnList);
        String nama = Input.nextLine("Masukkan nama SBN: ");
        int nominal;

        try {
            nominal = Input.nextInt("Nominal pembelian: ");
        } catch (Exception e) {
            throw new InvalidInputException("Input nominal tidak valid");
        }

        for (SuratBerhargaNegara sbn : sbnList) {
            if (sbn.getNama().equalsIgnoreCase(nama)) {
                if (sbn.getKuotaNasional() >= nominal) {
                    sbn.kurangiKuota(nominal);
                    sbnCustomer.put(nama, sbnCustomer.getOrDefault(nama, 0) + nominal);
                    Menu.pesanSukses("Berhasil membeli SBN!");
                } else {
                    Menu.pesanGagal("Kuota SBN tidak mencukupi");
                }
                return;
            }
        }

        Menu.pesanGagal("SBN tidak ditemukan");
    }

    public static void simulasiSBN() throws InvalidInputException {
        String nama = Input.nextLine("Masukkan nama SBN: ");
        int nominal;

        try {
            nominal = Input.nextInt("Nominal investasi: ");
        } catch (Exception e) {
            throw new InvalidInputException("Input nominal tidak valid");
        }

        double bunga = 0;
        for (SuratBerhargaNegara sbn : Admin.getSbnList()) {
            if (sbn.getNama().equalsIgnoreCase(nama)) {
                bunga = sbn.getBunga();
                break;
            }
        }

        if (bunga > 0) {
            double kuponBulanan = bunga / 12 / 100 * 0.9 * nominal;
            System.out.println("Estimasi kupon per bulan: Rp " + (int)kuponBulanan);
        } else {
            Menu.pesanGagal("SBN tidak ditemukan");
        }
        Menu.tekanEnterUntukLanjut();
    }
}
