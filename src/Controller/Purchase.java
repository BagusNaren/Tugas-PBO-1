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
    public static void buyStock(Map<String, Integer> sahamCustomer) {
        try {
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
                throw new InvalidInputException("Saham tidak tersedia");
            }

            int jumlah = Input.nextInt("Jumlah lembar: ");
            if (jumlah <= 0) {
                throw new InvalidInputException("Jumlah lembar harus lebih besar dari 0");
            }

            sahamCustomer.put(kode, sahamCustomer.getOrDefault(kode, 0) + jumlah);
            Menu.pesanSukses("Berhasil membeli saham!");
        } catch (InvalidInputException e) {
            Menu.pesanGagal(e.getMessage());
        }
    }

    public static void sellStock(Map<String, Integer> sahamCustomer) {
        try {
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
            int jumlah = Input.nextInt("Jumlah lembar: ");
            if (jumlah <= 0) {
                throw new InvalidInputException("Jumlah lembar harus lebih besar dari 0");
            }
            if (sahamCustomer.getOrDefault(kode, 0) >= jumlah) {
                sahamCustomer.put(kode, sahamCustomer.get(kode) - jumlah);
                if (sahamCustomer.get(kode) == 0) sahamCustomer.remove(kode);
                Menu.pesanSukses("Berhasil menjual saham!");
            } else {
                Menu.pesanGagal("Jumlah saham tidak mencukupi");
            }
        } catch (InvalidInputException e) {
            Menu.pesanGagal(e.getMessage());
        }
    }

    public static void buySBN(Map<String, Integer> sbnCustomer) {
        try {
            List<SuratBerhargaNegara> sbnList = Admin.getSbnList();
            View.showSBNList(sbnList);
            String nama = Input.nextLine("Masukkan nama SBN: ");
            int nominal = Input.nextInt("Nominal pembelian: ");
            if (nominal <= 0) {
                throw new InvalidInputException("Nominal pembelian harus lebih besar dari 0");
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
            throw new InvalidInputException("SBN tidak ditemukan");
        } catch (InvalidInputException e) {
            Menu.pesanGagal(e.getMessage());
        }
    }

    public static void simulasiSBN() {
        try {
            String nama = Input.nextLine("Masukkan nama SBN: ");
            int nominal = Input.nextInt("Nominal investasi: ");
            if (nominal <= 0) {
                throw new InvalidInputException("Nominal investasi harus lebih besar dari 0");
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
                throw new InvalidInputException("SBN tidak ditemukan");
            }
            Menu.tekanEnterUntukLanjut();
        } catch (InvalidInputException e) {
            Menu.pesanGagal(e.getMessage());
        }
    }
}
