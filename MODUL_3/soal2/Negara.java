package soal2;

public class Negara {
    private String nama;
    private String jenisKepemimpinan;
    private String namaPemimpin;
    private int tanggal;
    private int bulan;
    private int tahun;

    public Negara(String nama, String jenisKepemimpinan, String namaPemimpin,
                  int tanggal, int bulan, int tahun) {
        this.nama = nama;
        this.jenisKepemimpinan = jenisKepemimpinan;
        this.namaPemimpin = namaPemimpin;
        this.tanggal = tanggal;
        this.bulan = bulan;
        this.tahun = tahun;
    }

    public String getNama() { return nama; }
    public String getJenisKepemimpinan() { return jenisKepemimpinan; }
    public String getNamaPemimpin() { return namaPemimpin; }
    public int getTanggal() { return tanggal; }
    public int getBulan() { return bulan; }
    public int getTahun() { return tahun; }

    public boolean isMonarki() {
        return jenisKepemimpinan.equalsIgnoreCase("monarki");
    }

    public String getGelar() {
        if (isMonarki()) {
            return "Raja";
        }
        String[] kata = jenisKepemimpinan.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String k : kata) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(Character.toUpperCase(k.charAt(0)))
              .append(k.substring(1).toLowerCase());
        }
        return sb.toString();
    }
}
