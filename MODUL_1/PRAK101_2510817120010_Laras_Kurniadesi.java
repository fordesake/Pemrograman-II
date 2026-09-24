import java.time.Year;
import java.util.Locale;
import java.util.Scanner;

class PRAK101 {

    private static final String[] NAMA_BULAN = {
            "Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
    };

    private static boolean isKabisat(int tahun) {
        return (tahun % 4 == 0 && tahun % 100 != 0) || (tahun % 400 == 0);
    }

    private static int hariDalamBulan(int bulan, int tahun) {
        switch (bulan) {
            case 2:
                return isKabisat(tahun) ? 29 : 28;
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                return 31;
        }
    }

    private static String bacaTeks(Scanner in, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine().trim();
            if (!s.isEmpty() && s.matches("[\\p{L} .'-]+")) {
                return s;
            }
            System.out.println("  [!] Input harus berupa teks (huruf saja) dan tidak boleh kosong.");
        }
    }

    private static int bacaInt(Scanner in, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine().trim();
            try {
                int nilai = Integer.parseInt(s);
                if (nilai >= min && nilai <= max) {
                    return nilai;
                }
                System.out.println("  [!] Nilai harus antara " + min + " dan " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("  [!] Input harus berupa bilangan bulat.");
            }
        }
    }

    private static double bacaDouble(Scanner in, String prompt, double min, double max) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine().trim();
            try {
                double nilai = Double.parseDouble(s);
                if (nilai >= min && nilai <= max) {
                    return nilai;
                }
                System.out.println("  [!] Nilai harus antara " + min + " dan " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("  [!] Input harus berupa angka desimal (gunakan titik, contoh 54.89).");
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);

        String nama = bacaTeks(in, "Masukkan Nama Lengkap: ");
        String tempatLahir = bacaTeks(in, "Masukkan Tempat Lahir: ");
        int tanggal = bacaInt(in, "Masukkan Tanggal Lahir: ", 1, 31);
        int bulan = bacaInt(in, "Masukkan Bulan Lahir: ", 1, 12);
        int tahun = bacaInt(in, "Masukkan Tahun Lahir: ", 1, Year.now().getValue());

        // Validasi tanggal sesuai bulan & tahun (termasuk kabisat)
        int maksHari = hariDalamBulan(bulan, tahun);
        while (tanggal > maksHari) {
            System.out.println("  [!] " + NAMA_BULAN[bulan - 1] + " " + tahun
                    + " hanya punya " + maksHari + " hari.");
            tanggal = bacaInt(in, "Masukkan Tanggal Lahir: ", 1, maksHari);
        }

        int tinggi = bacaInt(in, "Masukkan Tinggi Badan: ", 1, 300);
        double berat = bacaDouble(in, "Masukkan Berat Badan: ", 0.1, 500);

        System.out.println();
        System.out.println("Nama Lengkap " + nama + ", Lahir di " + tempatLahir
                + " pada Tanggal " + tanggal + " " + NAMA_BULAN[bulan - 1] + " " + tahun);
        System.out.println("Tinggi Badan " + tinggi + " cm dan Berat Badan " + berat + " kilogram");

        in.close();
    }
}