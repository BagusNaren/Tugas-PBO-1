package Controller;

import Utils.Clear;
import Utils.Input;
import View.View;
import Menu.Menu;
import Model.Saham;
import Model.SuratBerhargaNegara;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    private static List<Saham> sahamList = new ArrayList<Saham>();
    private static List<SuratBerhargaNegara> sbnList = new ArrayList<SuratBerhargaNegara>();

    static {
        sahamList.add(new Saham("TLKM", "Telkom Indonesia", 4000));
        sahamList.add(new Saham("BBCA", "Bank Central Asia", 8500));
        sahamList.add(new Saham("BBRI", "Bank Rakyat Indonesia", 5000));

        sbnList.add(new SuratBerhargaNegara("ORI", 6.5, 3, "2028-05-01", 1000000000));
        sbnList.add(new SuratBerhargaNegara("SBR", 6.0, 2, "2027-05-01", 800000000));
        sbnList.add(new SuratBerhargaNegara("ST", 5.5, 2, "2027-05-01", 600000000));
    }

    public void menu() {
        boolean running = true;
        while (running) {
            Clear.clearScreen();
            Menu.tampilanMenuAdmin();
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
        }
    }

    private void menuSaham() {
        boolean running = true;
        while (running) {
            Clear.clearScreen();
            Menu.tampilanMenuAdminSaham();
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
                    Input.waitForEnter();
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
        }
    }

    private void menuSBN() {
        boolean running = true;
        while (running) {
            Clear.clearScreen();
            Menu.tampilanMenuAdminSBN();
            int pilihan = Input.nextInt("");

            switch (pilihan) {
                case 1:
                    tambahSBN();
                    break;
                case 2:
                    View.showSbnList(sbnList);
                    Input.waitForEnter();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    Menu.pesanGagal("Pilihan tidak valid");
            }
        }
    }

    private void tambahSaham() {
        Menu.inputTambahSaham();
        String kode = Input.nextLine("Kode Saham: ");
        String nama = Input.nextLine("Nama Perusahaan: ");
        int harga = Input.nextInt("Harga: ");
        sahamList.add(new Saham(kode, nama, harga));
        Menu.pesanSukses("Saham berhasil ditambahkan!");
        View.showSahamList(sahamList);
        Input.waitForEnter();
    }

    private void ubahHargaSaham() {
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
    }

    private void hapusSemuaSaham() {
        if (sahamList.isEmpty()) {
            Menu.pesanGagal("Daftar saham sudah kosong!");
        } else {
            sahamList.clear();
            Menu.pesanSukses("Seluruh data saham berhasil dihapus!");
        }
    }

    private void tambahSBN() {
        Menu.inputTambahSBN();
        String nama = Input.nextLine("Nama SBN: ");
        double bunga = Input.nextDouble("Bunga (%): ");
        int jangka = Input.nextInt("Jangka Waktu (tahun): ");
        String jatuhTempo = Input.nextLine("Tanggal Jatuh Tempo (yyyy-MM-dd): ");
        int kuota = Input.nextInt("Kuota Nasional: ");
        sbnList.add(new SuratBerhargaNegara(nama, bunga, jangka, jatuhTempo, kuota));
        Menu.pesanSukses("SBN berhasil ditambahkan!");
        View.showSbnList(sbnList);
        Input.waitForEnter();
    }

    public static List<Saham> getSahamList() {
        return sahamList;
    }

    public static List<SuratBerhargaNegara> getSbnList() {
        return sbnList;
    }
}
