package View;

import Model.Saham;
import Model.SuratBerhargaNegara;

import java.util.List;
import java.util.Map;

public class View {
    public static void showSahamList(List<Saham> list) {
        System.out.println("Kode | Nama Perusahaan | Harga");
        for (Saham s : list) {
            System.out.println(s.getKode() + " | " + s.getNamaPerusahaan() + " | Rp " + s.getHarga());
        }
    }

    public static void showSBNList(List<SuratBerhargaNegara> list) {
        System.out.println("Nama | Bunga | Jangka Waktu | Jatuh Tempo | Kuota");
        for (SuratBerhargaNegara s : list) {
            System.out.println(s.getNama() + " | " + s.getBunga() + "% | " + s.getJangkaWaktu() + " thn | " + s.getTanggalJatuhTempo() + " | " + s.getKuotaNasional());
        }
    }

    public static void showPortofolio(Map<String, Integer> sahamCustomer, Map<String, Integer> sbnCustomer) {
        System.out.println("=== Portofolio Saham ===");
        if (sahamCustomer.isEmpty()) {
            System.out.println("Tidak ada saham.");
        } else {
            for (Map.Entry<String, Integer> entry : sahamCustomer.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " lembar");
            }
        }

        System.out.println("\n=== Portofolio SBN ===");
        if (sbnCustomer.isEmpty()) {
            System.out.println("Tidak ada SBN.");
        } else {
            for (Map.Entry<String, Integer> entry : sbnCustomer.entrySet()) {
                System.out.println(entry.getKey() + ": Rp " + entry.getValue());
            }
        }
    }

    public static void showSbnList(List<SuratBerhargaNegara> sbnList) {
        System.out.println("=== Daftar Surat Berharga Negara ===");
        System.out.printf("%-10s %-20s %-10s %-15s %-15s%n",
                "Nama", "Bunga (%)", "Jangka (tahun)", "Jatuh Tempo", "Kuota Nasional");
        System.out.println("-------------------------------------------------------------");

        for (SuratBerhargaNegara sbn : sbnList) {
            System.out.printf("%-10s %-20.2f %-10d %-15s %-15d%n",
                    sbn.getNama(),
                    sbn.getBunga(),
                    sbn.getJangkaWaktu(),
                    sbn.getTanggalJatuhTempo(),
                    sbn.getKuotaNasional());
        }
        System.out.println("-------------------------------------------------------------");
    }
}
