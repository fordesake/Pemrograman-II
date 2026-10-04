public class PRAK201_2510817120010_Laras_Kurniadesi {
    public static void main(String[] args) {
        Buah apel = new Buah("Apel", 7000, 0.4, 2, 40);
        Buah mangga = new Buah("mangga", 3500, 0.2, 2, 15);
        Buah alpukat = new Buah("alpukat", 10000, 0.25, 2, 12);

        apel.tampilkanInfo();
        mangga.tampilkanInfo();
        alpukat.tampilkanInfo();
    }
}

class Buah {
    private String nama;
    private double harga;          // harga per berat satuan
    private double berat;          // berat satuan (kg)
    private double diskonPer4Kg;   // persen diskon tiap kelipatan 4 kg
    private double jumlahBeli;     // total berat yang dibeli (kg)

    public Buah(String nama, double harga, double berat,
                double diskonPer4Kg, double jumlahBeli) {
        this.nama = nama;
        this.harga = harga;
        this.berat = berat;
        this.diskonPer4Kg = diskonPer4Kg;
        this.jumlahBeli = jumlahBeli;
    }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    public double getBerat() { return berat; }
    public void setBerat(double berat) { this.berat = berat; }

    public double getDiskonPer4Kg() { return diskonPer4Kg; }
    public void setDiskonPer4Kg(double diskonPer4Kg) { this.diskonPer4Kg = diskonPer4Kg; }

    public double getJumlahBeli() { return jumlahBeli; }
    public void setJumlahBeli(double jumlahBeli) { this.jumlahBeli = jumlahBeli; }

    public double hitungHargaSebelumDiskon() {
        return (jumlahBeli / berat) * harga;
    }

    public double hitungHargaPer4Kg() {
        return (4 / berat) * harga;
    }

    public double hitungTotalDiskon() {
        int jumlahBlok4Kg = (int) (jumlahBeli / 4);
        return jumlahBlok4Kg * hitungHargaPer4Kg() * (diskonPer4Kg / 100);
    }

    public double hitungHargaSetelahDiskon() {
        return hitungHargaSebelumDiskon() - hitungTotalDiskon();
    }

    public void tampilkanInfo() {
        System.out.println("Nama Buah: " + nama);
        System.out.println("Berat: " + berat);
        System.out.println("Harga: " + harga);
        System.out.println("Jumlah Beli: " + jumlahBeli + "kg");
        System.out.printf(java.util.Locale.US, "Harga Sebelum Diskon: Rp%.2f%n", hitungHargaSebelumDiskon());
        System.out.printf(java.util.Locale.US, "Total Diskon: Rp%.2f%n", hitungTotalDiskon());
        System.out.printf(java.util.Locale.US, "Harga Setelah Diskon: Rp%.2f%n", hitungHargaSetelahDiskon());
        System.out.println();
    }
}