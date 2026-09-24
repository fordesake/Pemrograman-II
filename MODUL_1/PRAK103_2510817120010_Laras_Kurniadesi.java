import java.util.Scanner;

class PRAK103 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n;
        do {
            System.out.print("Masukkan N (jumlah bilangan): ");
            while (!in.hasNextInt()) {
                System.out.println("  [!] Input harus berupa bilangan bulat.");
                in.next();
                System.out.print("Masukkan N (jumlah bilangan): ");
            }
            n = in.nextInt();
            if (n < 1) {
                System.out.println("  [!] N harus lebih dari 0.");
            }
        } while (n < 1);

        System.out.print("Masukkan bilangan awal: ");
        while (!in.hasNextInt()) {
            System.out.println("  [!] Input harus berupa bilangan bulat.");
            in.next();
            System.out.print("Masukkan bilangan awal: ");
        }
        int bilangan = in.nextInt();

        int tampil = 0;
        do {
            if (bilangan % 2 != 0) {
                System.out.print(bilangan);
                tampil++;
                if (tampil < n) {
                    System.out.print(", ");
                }
            }
            bilangan++;
        } while (tampil < n);
        System.out.println();

        in.close();
    }
}