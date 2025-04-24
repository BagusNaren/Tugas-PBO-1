package Controller;

import Utils.Input;
import View.View;
import Model.Saham;
import Model.SuratBerhargaNegara;

import java.util.List;
import java.util.Map;

public class Purchase {
    public static void buyStock(Map<String, Integer> sahamCustomer) {
        List<Saham> sahamList = Admin.getSahamList();
        View.showSahamList(sahamList);
        String kode = Input.nextLine("Masukkan kode saham: ");
        int jumlah = Input.nextInt("Jumlah lembar: ");
        sahamCustomer.put(kode, sahamCustomer.getOrDefault(kode, 0) + jumlah);
        System.out.println("Berhasil membeli saham!");
    }

    public static void sellStock(Map<String, Integer> sahamCustomer) {
        if (sahamCustomer.isEmpty()) {
            System.out.println("Tidak ada saham yang dimiliki.");
            return;
        }
        System.out.println("Saham yang dimiliki:");
        for (String kode : sahamCustomer.keySet()) {
            System.out.println(kode + " : " + sahamCustomer.get(kode) + " lembar");
        }
        String kode = Input.nextLine("Masukkan kode saham: ");
        int jumlah = Input.nextInt("Jumlah lembar: ");
        if (sahamCustomer.getOrDefault(kode, 0) >= jumlah) {
            sahamCustomer.put(kode, sahamCustomer.get(kode) - jumlah);
            if (sahamCustomer.get(kode) == 0) sahamCustomer.remove(kode);
            System.out.println("Berhasil menjual saham!");
        } else {
            System.out.println("Gagal: jumlah saham tidak mencukupi.");
        }
    }

    public static void buySBN(Map<String, Integer> sbnCustomer) {
        List<SuratBerhargaNegara> sbnList = Admin.getSbnList();
        View.showSBNList(sbnList);
        String nama = Input.nextLine("Masukkan nama SBN: ");
        int nominal = Input.nextInt("Nominal pembelian: ");
        for (SuratBerhargaNegara sbn : sbnList) {
            if (sbn.getNama().equalsIgnoreCase(nama)) {
                if (sbn.getKuotaNasional() >= nominal) {
                    sbn.kurangiKuota(nominal);
                    sbnCustomer.put(nama, sbnCustomer.getOrDefault(nama, 0) + nominal);
                    System.out.println("Berhasil membeli SBN!");
                } else {
                    System.out.println("Gagal: kuota tidak mencukupi.");
                }
                return;
            }
        }
        System.out.println("SBN tidak ditemukan.");
    }

    public static void simulasiSBN() {
        String nama = Input.nextLine("Masukkan nama SBN: ");
        int nominal = Input.nextInt("Nominal investasi: ");
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
            System.out.println("SBN tidak ditemukan.");
        }
    }
}
