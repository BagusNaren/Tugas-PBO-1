package Model;

import java.util.ArrayList;
import java.util.List;

public class SuratBerhargaNegara {
    private final String nama;
    private final double bunga;
    private final int jangkaWaktu;
    private final String tanggalJatuhTempo;
    private int quotaNational;

    private static final List<SuratBerhargaNegara> daftarSBN = new ArrayList<>();

    public SuratBerhargaNegara(String nama, double bunga, int jangkaWaktu, String tanggalJatuhTempo, int kuotaNasional) {
        this.nama = nama;
        this.bunga = bunga;
        this.jangkaWaktu = jangkaWaktu;
        this.tanggalJatuhTempo = tanggalJatuhTempo;
        this.quotaNational = kuotaNasional;
        daftarSBN.add(this);
    }

    public String getNama() { return nama; }
    public double getBunga() { return bunga; }
    public int getJangkaWaktu() { return jangkaWaktu; }
    public String getTanggalJatuhTempo() { return tanggalJatuhTempo; }
    public int getKuotaNasional() { return quotaNational; }
    public void kurangiKuota(int nominal) { this.quotaNational -= nominal; }

    public static List<SuratBerhargaNegara> getAll() {
        return daftarSBN;
    }
}
