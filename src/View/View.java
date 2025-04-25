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

    public static void showPortofolio(Map<String, Integer> sahamCustomer, Map<String, Integer> sbnCustomer,
                                      List<Saham> listSaham, List<SuratBerhargaNegara> listSbn) {
        System.out.println("=======================================================================");
        System.out.println("||                               SAHAM                               ||");
        System.out.println("=======================================================================");
        System.out.printf("|| %-10s | %-10s | %-18s | %-18s ||%n", "Kode", "Lembar", "Total Beli", "Nilai Pasar");
        System.out.println("-----------------------------------------------------------------------");

        if (sahamCustomer.isEmpty()) {
            System.out.printf("|| %-65s ||%n", "Tidak ada saham");
        } else {
            for (Map.Entry<String, Integer> entry : sahamCustomer.entrySet()) {
                String kode = entry.getKey();
                int jumlahLembar = entry.getValue();

                Saham saham = listSaham.stream()
                        .filter(s -> s.getKode().equalsIgnoreCase(kode))
                        .findFirst().orElse(null);

                if (saham != null) {
                    int harga = saham.getHarga();
                    int totalBeli = jumlahLembar * harga;
                    int nilaiPasar = jumlahLembar * harga;

                    System.out.printf("|| %-10s | %-10d | Rp %-15s | Rp %-15s ||%n",
                            kode, jumlahLembar,
                            String.format("%,d", totalBeli),
                            String.format("%,d", nilaiPasar));
                } else {
                    System.out.printf("|| %-10s | %-10d | %-18s | %-18s ||%n",
                            kode, jumlahLembar, "Data tidak ada", "Data tidak ada");
                }
            }
        }
        System.out.println("=======================================================================");

        System.out.println("=======================================================================");
        System.out.println("||                     SURAT BERHARGA NEGARA (SBN)                   ||");
        System.out.println("=======================================================================");
        System.out.printf("|| %-17s | %-21s | %-21s ||%n", "Nama SBN", "Total Beli", "Bunga / Bulan");
        System.out.println("-----------------------------------------------------------------------");

        if (sbnCustomer.isEmpty()) {
            System.out.printf("|| %-65s ||%n", "Tidak ada SBN");
        } else {
            for (Map.Entry<String, Integer> entry : sbnCustomer.entrySet()) {
                String nama = entry.getKey();
                int nominal = entry.getValue();

                SuratBerhargaNegara sbn = listSbn.stream()
                        .filter(s -> s.getNama().equalsIgnoreCase(nama))
                        .findFirst().orElse(null);

                if (sbn != null) {
                    double bungaBulanan = (nominal * (sbn.getBunga() / 100)) / 12;
                    System.out.printf("|| %-17s | Rp %-18s | Rp %-18.2f ||%n",
                            nama,
                            String.format("%,d", nominal),
                            bungaBulanan);
                } else {
                    System.out.printf("|| %-25s | %-18s | %-18s ||%n",
                            nama, "Data tidak ada", "Data tidak ada");
                }
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
