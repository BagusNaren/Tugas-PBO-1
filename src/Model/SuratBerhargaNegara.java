package Model;

public class SuratBerhargaNegara {
    private String nama;
    private double bunga;
    private int jangkaWaktu;
    private String tanggalJatuhTempo;
    private int kuotaNasional;

    public SuratBerhargaNegara(String nama, double bunga, int jangkaWaktu, String tanggalJatuhTempo, int kuotaNasional) {
        this.nama = nama;
        this.bunga = bunga;
        this.jangkaWaktu = jangkaWaktu;
        this.tanggalJatuhTempo = tanggalJatuhTempo;
        this.kuotaNasional = kuotaNasional;
    }

    public String getNama() { return nama; }
    public double getBunga() { return bunga; }
    public int getJangkaWaktu() { return jangkaWaktu; }
    public String getTanggalJatuhTempo() { return tanggalJatuhTempo; }
    public int getKuotaNasional() { return kuotaNasional; }
    public void kurangiKuota(int nominal) { this.kuotaNasional -= nominal; }
}
