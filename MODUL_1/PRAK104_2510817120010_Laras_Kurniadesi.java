import java.util.Scanner;

class PRAK104 {

    private static char[] bacaTangan(Scanner in, String prompt) {
        while (true) {
            System.out.print(prompt);
            String[] bagian = in.nextLine().trim().toUpperCase().split("\\s+");
            boolean valid = bagian.length == 3;
            char[] hasil = new char[3];
            for (int i = 0; valid && i < 3; i++) {
                if (bagian[i].equals("B") || bagian[i].equals("G") || bagian[i].equals("K")) {
                    hasil[i] = bagian[i].charAt(0);
                } else {
                    valid = false;
                }
            }
            if (valid) {
                return hasil;
            }
            System.out.println("  [!] Masukkan 3 pilihan (B/G/K) dipisah spasi, contoh: G G K");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char[] abu = bacaTangan(in, "Tangan Abu: ");
        char[] bagas = bacaTangan(in, "Tangan Bagas: ");

        int poinAbu = 0;
        int poinBagas = 0;

        for (int i = 0; i < 3; i++) {
            char a = abu[i];
            char b = bagas[i];

            if (a == b) {
            } else if (a == 'B' && b == 'G') {
                poinAbu++;
            } else if (a == 'G' && b == 'K') {
                poinAbu++;
            } else if (a == 'K' && b == 'B') {
                poinAbu++;
            } else {
                poinBagas++;
            }
        }

        if (poinAbu > poinBagas) {
            System.out.println("Abu");
        } else if (poinBagas > poinAbu) {
            System.out.println("Bagas");
        } else {
            System.out.println("Seri");
        }

        in.close();
    }
}