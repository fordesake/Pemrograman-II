import java.util.Scanner;

class PRAK102 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Masukkan angka awal: ");
        while (!in.hasNextInt()) {
            System.out.println("  [!] Input harus berupa bilangan bulat.");
            in.next();
            System.out.print("Masukkan angka awal: ");
        }
        int angka = in.nextInt();

        int counter = 0;
        while (counter <= 10) {
            int nilai = angka;
            if (angka % 5 == 0) {
                nilai = (angka / 5) - 1;
            }
            System.out.print(nilai);
            if (counter < 10) {
                System.out.print(", ");
            }
            angka++;
            counter++;
        }
        System.out.println();

        in.close();
    }
}