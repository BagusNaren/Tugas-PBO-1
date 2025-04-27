package Controller;

import Utils.Clear;
import Utils.Input;
import Utils.InvalidInputException;
import View.View;
import Menu.Menu;
import Model.Saham;
import Model.SuratBerhargaNegara;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    // List untuk menyimpan data Saham dan SBN
    private static final List<Saham> sahamList = new ArrayList<>();
    private static final List<SuratBerhargaNegara> sbnList = new ArrayList<>();

    // Inisialisasi data awal Saham dan SBN
    static {
        sahamList.add(new Saham("TLKM", "Telkom Indonesia", 4000));
        sahamList.add(new Saham("BBCA", "Bank Central Asia", 8500));
        sahamList.add(new Saham("BBRI", "Bank Rakyat Indonesia", 5000));

        sbnList.add(new SuratBerhargaNegara("ORI", 6.5, 3, "2028-05-01", 1000000000));
        sbnList.add(new SuratBerhargaNegara("SBR", 6.0, 2, "2027-05-01", 800000000));
        sbnList.add(new SuratBerhargaNegara("ST", 5.5, 2, "2027-05-01", 600000000));
    }

    // Menu utama admin
    public void menu() {
        boolean running = true;
        while (running) {
            Clear.clearScreen();
            Menu.tampilanMenuAdmin();

            try {
                int pilihan = Input.nextInt("");
                switch (pilihan) {
                    case 1:
                        menuSaham();
                        break;
                    case 2:
                        menuSBN();
                        break;
                    case 3:
                        running = false;
                        break;
                    default:
                        Menu.pesanGagal("Pilihan tidak valid");
                }
            } catch (InvalidInputException e) {
                Menu.pesanGagal(e.getMessage());
            }
        }
    }

    // Menu pengelolaan saham
    private void menuSaham() {
        boolean running = true;
        while (running) {
            Clear.clearScreen();
            Menu.tampilanMenuAdminSaham();

            try {
                int pilihan = Input.nextInt("");
                switch (pilihan) {
                    case 1:
                        tambahSaham();
                        break;
                    case 2:
                        ubahHargaSaham();
                        break;
                    case 3:
                        View.showSahamList(sahamList);
                        Menu.tekanEnterUntukKembali();
                        break;
                    case 4:
                        hapusSemuaSaham();
                        break;
                    case 5:
                        running = false;
                        break;
                    default:
                        Menu.pesanGagal("Pilihan tidak valid");
                }
            } catch (InvalidInputException e) {
                Menu.pesanGagal(e.getMessage());
            }
        }
    }

    // Menu pengelolaan Surat Berharga Negara (SBN)
    private void menuSBN() {
        boolean running = true;
        while (running) {
            Clear.clearScreen();
            Menu.tampilanMenuAdminSBN();

            try {
                int pilihan = Input.nextInt("");
                switch (pilihan) {
                    case 1:
                        tambahSBN();
                        break;
                    case 2:
                        View.showSbnList(sbnList);
                        Menu.tekanEnterUntukKembali();
                        break;
                    case 3:
                        hapusSemuaSBN();
                        break;
                    case 4:
                        running = false;
                        break;
                    default:
                        Menu.pesanGagal("Pilihan tidak valid");
                }
            } catch (InvalidInputException e) {
                Menu.pesanGagal(e.getMessage());
            }
        }
    }

    // Method untuk menambah data saham
    private void tambahSaham() {
        try {
            Menu.inputTambahSaham();
            String kode = Input.nextLine("Kode Saham: ");
            String nama = Input.nextLine("Nama Perusahaan: ");
            int harga = Input.nextInt("Harga: ");

            sahamList.add(new Saham(kode, nama, harga));
            Menu.pesanSukses("Saham berhasil ditambahkan!");
            View.showSahamList(sahamList);
            Menu.tekanEnterUntukKembali();
        } catch (InvalidInputException e) {
            Menu.pesanGagal(e.getMessage());
        }
    }

    // Method untuk mengubah harga saham yang sudah ada
    private void ubahHargaSaham() {
        try {
            Menu.inputUbahHargaSaham();
            View.showSahamList(sahamList);
            String kode = Input.nextLine("Masukkan kode saham: ");

            for (Saham s : sahamList) {
                if (s.getKode().equalsIgnoreCase(kode)) {
                    int hargaBaru = Input.nextInt("Harga baru: ");
                    s.setHarga(hargaBaru);
                    Menu.pesanSukses("Harga saham berhasil diubah!");
                    return;
                }
            }
            Menu.pesanGagal("Saham tidak ditemukan!");
        } catch (InvalidInputException e) {
            Menu.pesanGagal(e.getMessage());
        }
    }

    // Method untuk menghapus semua saham
    private void hapusSemuaSaham() {
        if (sahamList.isEmpty()) {
            Menu.pesanGagal("Daftar saham sudah kosong!");
        } else {
            sahamList.clear();
            Menu.pesanSukses("Seluruh data saham berhasil dihapus!");
        }
    }

    // Method untuk menambah data SBN
    private void tambahSBN() {
        try {
            Menu.inputTambahSBN();
            String nama = Input.nextLine("Nama SBN: ");
            double bunga = Input.nextDouble("Bunga (%): ");
            int jangka = Input.nextInt("Jangka Waktu (tahun): ");
            String jatuhTempo = Input.nextLine("Tanggal Jatuh Tempo (yyyy-MM-dd): ");
            int kuota = Input.nextInt("Kuota Nasional: ");

            sbnList.add(new SuratBerhargaNegara(nama, bunga, jangka, jatuhTempo, kuota));
            Menu.pesanSukses("SBN berhasil ditambahkan!");
            View.showSbnList(sbnList);
            Menu.tekanEnterUntukKembali();
        } catch (InvalidInputException e) {
            Menu.pesanGagal(e.getMessage());
        }
    }

    // Method untuk menghapus semua SBN
    private void hapusSemuaSBN() {
        if (sbnList.isEmpty()) {
            Menu.pesanGagal("Daftar SBN sudah kosong!");
        } else {
            sbnList.clear();
            Menu.pesanSukses("Seluruh data SBN berhasil dihapus!");
        }
    }

    // Getter untuk mengambil daftar saham
    public static List<Saham> getSahamList() {
        return sahamList;
    }

    // Getter untuk mengambil daftar SBN
    public static List<SuratBerhargaNegara> getSbnList() {
        return sbnList;
    }
}
