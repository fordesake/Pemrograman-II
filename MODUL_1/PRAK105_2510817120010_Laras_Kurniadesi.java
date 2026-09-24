import java.util.Locale;
import java.util.Scanner;

class PRAK105 {

    private static final double PHI = 3.14;

    private static double bacaPositif(Scanner in, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine().trim();
            try {
                double nilai = Double.parseDouble(s);
                if (nilai > 0 && !Double.isInfinite(nilai)) {
                    return nilai;
                }
                System.out.println("  [!] Nilai harus lebih dari 0.");
            } catch (NumberFormatException e) {
                System.out.println("  [!] Input harus berupa angka (gunakan titik untuk desimal).");
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double jariJari = bacaPositif(in, "Masukkan jari-jari: ");
        double tinggi = bacaPositif(in, "Masukkan tinggi: ");

        double volume = PHI * jariJari * jariJari * tinggi;

        System.out.println(String.format(Locale.US,
                "Volume tabung dengan jari-jari %s cm dan tinggi %s cm adalah %.3f m3",
                jariJari, tinggi, volume));

        in.close();
    }
}