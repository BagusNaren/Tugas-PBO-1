package View;

import Model.Saham;
import Model.SuratBerhargaNegara;

import java.util.List;
import java.util.Map;

public class View {
    public static void showSahamList(List<Saham> list) {
        System.out.println("=======================================================================");
        System.out.println("||                        DAFTAR SAHAM TERSEDIA                      ||");
        System.out.println("=======================================================================");
        System.out.println("Kode        | Nama Perusahaan                 | Harga");
        System.out.println("-----------------------------------------------------------------------");
        for (Saham s : list) {
            System.out.printf("%-12s| %-32s| Rp %,d%n",
                    s.getKode(), s.getNamaPerusahaan(), s.getHarga());
        }
        System.out.println("=======================================================================");
    }

    public static void showSBNList(List<SuratBerhargaNegara> list) {
        System.out.println("=======================================================================");
        System.out.println("||                DAFTAR SURAT BERHARGA NEGARA (SBN)                 ||");
        System.out.println("=======================================================================");
        System.out.printf("%-10s | %-7s | %-13s | %-12s | %-10s%n",
                "Nama", "Bunga", "Jangka Waktu", "Jatuh Tempo", "Kuota");
        System.out.println("-----------------------------------------------------------------------");
        for (SuratBerhargaNegara s : list) {
            System.out.printf("%-10s | %-6.2f%% | %-13d | %-12s | %,10d%n",
                    s.getNama(), s.getBunga(), s.getJangkaWaktu(), s.getTanggalJatuhTempo(), s.getKuotaNasional());
        }
        System.out.println("=======================================================================");
    }

    public static void showPortofolio(Map<String, Integer> sahamCustomer, Map<String, Integer> sbnCustomer) {
        System.out.println("=======================================================================");
        System.out.println("||                        PORTOFOLIO INVESTASI                       ||");
        System.out.println("=======================================================================");

        System.out.println("||                             SAHAM                                 ||");
        if (sahamCustomer.isEmpty()) {
            System.out.printf("|| %-65s ||%n", "Tidak ada saham");
        } else {
            for (Map.Entry<String, Integer> entry : sahamCustomer.entrySet()) {
                String isi = entry.getKey() + ": " + entry.getValue() + " lembar";
                System.out.printf("|| %-65s ||%n", isi);
            }
        }

        System.out.println("||-------------------------------------------------------------------||");

        System.out.println("||                              SBN                                  ||");
        if (sbnCustomer.isEmpty()) {
            System.out.printf("|| %-65s ||%n", "Tidak ada SBN");
        } else {
            for (Map.Entry<String, Integer> entry : sbnCustomer.entrySet()) {
                String isi = entry.getKey() + ": Rp " + String.format("%,d", entry.getValue());
                System.out.printf("|| %-65s ||%n", isi);
            }
        }

        System.out.println("=======================================================================");
    }

    public static void showSbnList(List<SuratBerhargaNegara> sbnList) {
        System.out.println("=======================================================================");
        System.out.println("||                   DAFTAR SURAT BERHARGA NEGARA                    ||");
        System.out.println("=======================================================================");
        System.out.printf("%-10s %-15s %-15s %-15s %-15s%n",
                "Nama", "Bunga (%)", "Jangka (th)", "Jatuh Tempo", "Kuota");
        System.out.println("-----------------------------------------------------------------------");

        for (SuratBerhargaNegara sbn : sbnList) {
            System.out.printf("%-10s %-15.2f %-15d %-15s %-15d%n",
                    sbn.getNama(),
                    sbn.getBunga(),
                    sbn.getJangkaWaktu(),
                    sbn.getTanggalJatuhTempo(),
                    sbn.getKuotaNasional());
        }

        System.out.println("=======================================================================");
    }
}
