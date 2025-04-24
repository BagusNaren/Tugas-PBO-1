package Model;

import java.util.ArrayList;
import java.util.List;

public class Saham {
    private String kode;
    private String namaPerusahaan;
    private int harga;

    private static List<Saham> daftarSaham = new ArrayList<>();

    public Saham(String kode, String namaPerusahaan, int harga) {
        this.kode = kode;
        this.namaPerusahaan = namaPerusahaan;
        this.harga = harga;
        daftarSaham.add(this);
    }

    public String getKode() { return kode; }
    public String getNamaPerusahaan() { return namaPerusahaan; }
    public int getHarga() { return harga; }
    public void setHarga(int harga) { this.harga = harga; }

    public static List<Saham> getAll() {
        return daftarSaham;
    }
}
