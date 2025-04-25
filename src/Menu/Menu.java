package Menu;

import Model.Account;

import java.util.Scanner;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);

    public static void tampilanLogin() {
        System.out.println("=======================================================================");
        System.out.println("||                            W E L C O M E                          ||");
        System.out.println("||                                                                   ||");
        System.out.println("||                              LOGIN PAGE                           ||");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("||                      Pilih Tipe User Di Bawah                     ||");
        System.out.println("||                                                                   ||");
        System.out.println("||          [1] Administrator                  [2] Customer          ||");
        System.out.println("||                           [0] Keluar Program                      ||");
        System.out.println("=======================================================================");
        System.out.print("Masukkan pilihan: ");
    }

    public static void headerUsernameDanPassword() {
        System.out.println("=======================================================================");
        System.out.println("||                             L O G I N                             ||");
        System.out.println("||        Mohon Masukkan Username dan Password untuk Melanjutkan     ||");
        System.out.println("=======================================================================");
    }

    public static void errorLogin() {
        System.out.println("=======================================================================");
        System.out.println("||                             LOGIN GAGAL                           ||");
        System.out.println("||               Periksa kembali Username dan Password Anda          ||");
        System.out.println("||                    Tekan Enter untuk Melanjutkan                  ||");
        System.out.println("=======================================================================");
        scanner.nextLine();
    }

    public static void loggedInGreetingAdmin(String userName) {
        System.out.println("=======================================================================");
        System.out.printf("||                        Halo Admin, %-31s||\n", Account.ADMIN_NAME);
        System.out.println("||                    Tekan Enter untuk Melanjutkan                  ||");
        System.out.println("=======================================================================");
        scanner.nextLine();
    }

    public static void loggedInGreetingCustomer(String userName) {
        System.out.println("=======================================================================");
        System.out.printf("||                       Halo Customer, %-29s||\n", Account.CUSTOMER_NAME);
        System.out.println("||                    Tekan Enter untuk Melanjutkan                  ||");
        System.out.println("=======================================================================");
        scanner.nextLine();
    }

    public static void tampilanMenuAdmin() {
        System.out.println("=======================================================================");
        System.out.println("||                             ADMIN MENU                            ||");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("||   [1] Kelola Saham                                                ||");
        System.out.println("||   [2] Kelola Surat Berharga Negara (SBN)                          ||");
        System.out.println("||   [3] Logout                                                      ||");
        System.out.println("=======================================================================");
        System.out.print("Masukkan pilihan: ");
    }

    public static void tampilanMenuAdminSaham() {
        System.out.println("=======================================================================");
        System.out.println("||                       KELOLA SAHAM - ADMIN                        ||");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("||   [1] Tambah Saham                                                ||");
        System.out.println("||   [2] Ubah Harga Saham                                            ||");
        System.out.println("||   [3] Lihat Daftar Saham                                          ||");
        System.out.println("||   [4] Hapus Saham                                                 ||");
        System.out.println("||   [5] Kembali ke Menu Utama                                       ||");
        System.out.println("=======================================================================");
        System.out.print("Masukkan pilihan: ");
    }

    public static void tampilanMenuAdminSBN() {
        System.out.println("=======================================================================");
        System.out.println("||                         KELOLA SBN - ADMIN                        ||");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("||   [1] Tambah SBN                                                  ||");
        System.out.println("||   [2] Lihat Daftar SBN                                            ||");
        System.out.println("||   [3] Hapus SBN                                                   ||");
        System.out.println("||   [4] Kembali ke Menu Utama                                       ||");
        System.out.println("=======================================================================");
        System.out.print("Masukkan pilihan: ");
    }

    public static void customerMenu() {
        System.out.println("=======================================================================");
        System.out.println("||                          CUSTOMER MENU                            ||");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("||   [1] Beli Saham                                                  ||");
        System.out.println("||   [2] Jual Saham                                                  ||");
        System.out.println("||   [3] Beli SBN                                                    ||");
        System.out.println("||   [4] Simulasi Bunga SBN                                          ||");
        System.out.println("||   [5] Lihat Portofolio                                            ||");
        System.out.println("||   [6] Lihat Daftar Saham                                          ||");
        System.out.println("||   [7] Lihat Daftar SBN                                            ||");
        System.out.println("||   [8] Logout                                                      ||");
        System.out.println("=======================================================================");
        System.out.print("Masukkan pilihan: ");
    }

    public static void inputTambahSaham() {
        System.out.println("=======================================================================");
        System.out.println("||                          TAMBAH SAHAM                             ||");
        System.out.println("||         Masukkan Kode, Nama Perusahaan, dan Harga Saham           ||");
        System.out.println("=======================================================================");
    }

    public static void inputUbahHargaSaham() {
        System.out.println("=======================================================================");
        System.out.println("||                        UBAH HARGA SAHAM                           ||");
        System.out.println("||             Pilih Saham dan Masukkan Harga Baru                   ||");
        System.out.println("=======================================================================");
    }

    public static void inputTambahSBN() {
        System.out.println("=======================================================================");
        System.out.println("||                            TAMBAH SBN                             ||");
        System.out.println("||   Masukkan Nama SBN, Bunga(%), Jangka Waktu, dan Kuota Nasional   ||");
        System.out.println("=======================================================================");
    }

    public static void beliSaham() {
        System.out.println("=======================================================================");
        System.out.println("||                           BELI SAHAM                              ||");
        System.out.println("||        Pilih Saham dan Masukkan Jumlah Lembar yang Dibeli         ||");
        System.out.println("=======================================================================");
    }

    public static void jualSaham() {
        System.out.println("=======================================================================");
        System.out.println("||                           JUAL SAHAM                              ||");
        System.out.println("||        Pilih Saham dan Masukkan Jumlah Lembar yang Dijual         ||");
        System.out.println("=======================================================================");
    }

    public static void beliSBN() {
        System.out.println("=======================================================================");
        System.out.println("||                             BELI SBN                              ||");
        System.out.println("||             Pilih SBN dan Masukkan Nominal Pembelian              ||");
        System.out.println("=======================================================================");
    }

    public static void simulasiSBN() {
        System.out.println("=======================================================================");
        System.out.println("||                       SIMULASI BUNGA SBN                          ||");
        System.out.println("||    Simulasikan Bunga Bulanan Berdasarkan Jumlah Investasi Anda    ||");
        System.out.println("=======================================================================");
    }

    public static void lihatPortofolio() {
        System.out.println("=======================================================================");
        System.out.println("||                      PORTOFOLIO INVESTASI                         ||");
        System.out.println("||      Menampilkan Portofolio Saham & SBN yang Dimiliki Customer    ||");
        System.out.println("=======================================================================");
    }

    public static void pesanGagal(String pesan) {
        System.out.println("=======================================================================");
        System.out.println("||                               GAGAL                               ||");
        cetakTengahDenganKotak(pesan);
        System.out.println("||                      Tekan Enter untuk Kembali                    ||");
        System.out.println("=======================================================================");
        scanner.nextLine();
    }

    public static void pesanSukses(String pesan) {
        System.out.println("=======================================================================");
        System.out.println("||                             BERHASIL                              ||");
        cetakTengahDenganKotak(pesan);
        System.out.println("||                     Tekan Enter untuk Kembali                     ||");
        System.out.println("=======================================================================");
        scanner.nextLine();
    }

    private static void cetakTengahDenganKotak(String pesan) {
        int lebar = 67;
        if (pesan.length() > lebar) {
            pesan = pesan.substring(0, lebar);
        }
        int paddingKiri = (lebar - pesan.length()) / 2;
        int paddingKanan = lebar - pesan.length() - paddingKiri;
        System.out.printf("||%" + paddingKiri + "s%s%" + paddingKanan + "s||\n", "", pesan, "");
    }

    public static void tekanEnterUntukLanjut() {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("||                   Tekan Enter untuk Melanjutkan                   ||");
        System.out.println("=======================================================================");
        scanner.nextLine();
    }

    public static void ucapanTerimaKasih() {
        System.out.println("=======================================================================");
        System.out.println("||                    TERIMA KASIH TELAH MENGGUNAKAN                 ||");
        System.out.println("||                        APLIKASI INVESTASI KAMI!                   ||");
        System.out.println("=======================================================================");
    }
}
