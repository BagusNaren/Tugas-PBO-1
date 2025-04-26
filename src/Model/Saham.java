package Model;

public class Saham {
    private final String kode;
    private final String namaPerusahaan;
    private int harga;

    public Saham(String kode, String namaPerusahaan, int harga) {
        this.kode = kode;
        this.namaPerusahaan = namaPerusahaan;
        this.harga = harga;
    }

    public String getKode() { return kode; }
    public String getNamaPerusahaan() { return namaPerusahaan; }
    public int getHarga() { return harga; }
    public void setHarga(int harga) { this.harga = harga; }
}
