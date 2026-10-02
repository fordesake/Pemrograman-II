public class PRAK201_2510817120010_Laras_Kurniadesi {
    public static void main(String[] args) {
        Buah apel = new Buah("Apel", 7000, 0.4, 2, 40);
        Buah mangga = new Buah("Mangga", 3500, 0.2, 2, 40);
        Buah alpukat = new Buah("Alpukat", 10000, 0.25, 2, 40);

        apel.hitungDanTampilkan();
        mangga.hitungDanTampilkan();
        alpukat.hitungDanTampilkan();
    }
}

class Buah {
    private String nama;
    private double hargaPerSatuan;   // harga per satuan berat (Rp)
    private double beratSatuan;      // berat satuan (kg)
    private double diskonPer4Kg;     // diskon (%) per 4 kg
    private double beratBeli;        // total berat dibeli (kg)

    public Buah(String nama, double hargaPerSatuan, double beratSatuan,
                double diskonPer4Kg, double beratBeli) {
        this.nama = nama;
        this.hargaPerSatuan = hargaPerSatuan;
        this.beratSatuan = beratSatuan;
        this.diskonPer4Kg = diskonPer4Kg;
        this.beratBeli = beratBeli;
    }

    // Getter & Setter
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public double getHargaPerSatuan() { return hargaPerSatuan; }
    public void setHargaPerSatuan(double hargaPerSatuan) { this.hargaPerSatuan = hargaPerSatuan; }

    public double getBeratSatuan() { return beratSatuan; }
    public void setBeratSatuan(double beratSatuan) { this.beratSatuan = beratSatuan; }

    public double getDiskonPer4Kg() { return diskonPer4Kg; }
    public void setDiskonPer4Kg(double diskonPer4Kg) { this.diskonPer4Kg = diskonPer4Kg; }

    public double getBeratBeli() { return beratBeli; }
    public void setBeratBeli(double beratBeli) { this.beratBeli = beratBeli; }

    // Method perhitungan + tampilan
    public void hitungDanTampilkan() {
        int jumlahPutaran = (int) (beratBeli / 4);   // 40 kg / 4 kg = 10 kali
        double totalHargaNormal = 0;
        double totalDiskonPersen = 0;

        System.out.println("=== Pembelian " + nama + " ===");

        for (int i = 1; i <= jumlahPutaran; i++) {
            double jumlahSatuan = 4 / beratSatuan;
            double hargaPer4Kg = jumlahSatuan * hargaPerSatuan;
            totalHargaNormal += hargaPer4Kg;
            totalDiskonPersen += diskonPer4Kg;

            System.out.printf("Pembelian ke-%d (4 kg) : Rp%,.0f | Diskon terkumpul: %.0f%%%n",
                    i, hargaPer4Kg, totalDiskonPersen);
        }

        double potongan = totalHargaNormal * totalDiskonPersen / 100;
        double totalBayar = totalHargaNormal - potongan;

        System.out.printf("Total berat        : %.0f kg%n", beratBeli);
        System.out.printf("Harga normal       : Rp%,.0f%n", totalHargaNormal);
        System.out.printf("Total diskon (%.0f%%) : Rp%,.0f%n", totalDiskonPersen, potongan);
        System.out.printf("Total bayar        : Rp%,.0f%n", totalBayar);
        System.out.println();
    }
}