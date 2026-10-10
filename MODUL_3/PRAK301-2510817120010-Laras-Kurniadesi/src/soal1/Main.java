package soal1;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner input = new Scanner(System.in);
        LinkedList<Dadu> daftarDadu = new LinkedList<>();

        int jumlah = input.nextInt();

        for (int i = 0; i < jumlah; i++) {
            daftarDadu.add(new Dadu());
        }

        int total = 0;
        int urutan = 1;
        for (Dadu dadu : daftarDadu) {
            System.out.println("Dadu ke-" + urutan + " bernilai " + dadu.getNilai());
            total += dadu.getNilai();
            urutan++;
        }

        System.out.println("Total nilai dadu keseluruhan " + total);
        input.close();
    }
}
