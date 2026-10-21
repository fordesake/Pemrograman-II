package soal2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Pilih jenis hewan yang ingin diinputkan:");
        System.out.println("1 = Kucing");
        System.out.println("2 = Anjing");
        System.out.print("Masukkan pilihan: ");
        int pilihan = Integer.parseInt(input.nextLine());

        System.out.print("Nama hewan peliharaan: ");
        String nama = input.nextLine();
        System.out.print("Ras: ");
        String ras = input.nextLine();
        System.out.print("Warna Bulu: ");
        String warna = input.nextLine();

        if (pilihan == 1) {
            Kucing kucing = new Kucing(ras, nama, warna);
            kucing.displayDetailKucing();
        } else if (pilihan == 2) {
            System.out.print("Kemampuan : ");
            String[] kemampuan = input.nextLine().split(",\\s*");
            Anjing anjing = new Anjing(nama, ras, warna, kemampuan);
            anjing.displayDetailAnjing();
        }
    }
}