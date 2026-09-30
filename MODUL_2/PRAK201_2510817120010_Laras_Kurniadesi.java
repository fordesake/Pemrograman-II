import java.util.Locale;

// Tanpa "public" supaya boleh berada di file dengan nama berbeda
class Buah {
    private String nama;
    private double berat;       // berat acuan (kg)
    private double harga;       // harga per berat acuan
    private double jumlahBeli;  // jumlah beli (kg)

    public Buah(String nama, double berat, double harga, double jumlahBeli) {
        this.nama = nama;
        this.berat = berat;
        this.harga = harga;
        this.jumlahBeli = jumlahBeli;
    }

    public double hitungHargaSebelumDiskon() {
        return (jumlahBeli / berat) * harga;
    }

    public double hitungDiskon() {
        // Diskon 2% berlaku untuk setiap kelipatan 4kg pembelian
        int kelipatan = (int) (jumlahBeli / 4);
        return kelipatan * 0.02 * 4 * harga;
    }

    public double hitungHargaSetelahDiskon() {
        return hitungHargaSebelumDiskon() - hitungDiskon();
    }

    public void tampilkanInfo() {
        // Locale.US dipakai agar desimal selalu titik (bukan koma)
        System.out.println("Nama Buah: " + nama);
        System.out.println("Berat: " + berat);
        System.out.println("Harga: " + harga);
        System.out.println("Jumlah Beli: " + jumlahBeli + "kg");
        System.out.println(String.format(Locale.US, "Harga Sebelum Diskon: Rp%.2f", hitungHargaSebelumDiskon()));
        System.out.println(String.format(Locale.US, "Total Diskon: Rp%.2f", hitungDiskon()));
        System.out.println(String.format(Locale.US, "Harga Setelah Diskon: Rp%.2f", hitungHargaSetelahDiskon()));
    }
}

public class PRAK201_2510817120010_Laras_Kurniadesi {
    public static void main(String[] args) {
        Buah apel = new Buah("Apel", 0.4, 7000, 40);
        Buah mangga = new Buah("mangga", 0.2, 3500, 15);
        Buah alpukat = new Buah("alpukat", 0.25, 10000, 12);

        apel.tampilkanInfo();
        mangga.tampilkanInfo();
        alpukat.tampilkanInfo();
    }
}