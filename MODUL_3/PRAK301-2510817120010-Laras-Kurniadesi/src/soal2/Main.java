package soal2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        HashMap<Integer, String> namaBulan = new HashMap<>();
        namaBulan.put(1, "Januari");
        namaBulan.put(2, "Februari");
        namaBulan.put(3, "Maret");
        namaBulan.put(4, "April");
        namaBulan.put(5, "Mei");
        namaBulan.put(6, "Juni");
        namaBulan.put(7, "Juli");
        namaBulan.put(8, "Agustus");
        namaBulan.put(9, "September");
        namaBulan.put(10, "Oktober");
        namaBulan.put(11, "November");
        namaBulan.put(12, "Desember");

        LinkedList<Negara> daftarNegara = new LinkedList<>();

        int jumlah = Integer.parseInt(input.nextLine().trim());

        for (int i = 0; i < jumlah; i++) {
            String nama = input.nextLine().trim();
            String jenis = input.nextLine().trim();
            String pemimpin = input.nextLine().trim();

            int tanggal = 0, bulan = 0, tahun = 0;
            if (!jenis.equalsIgnoreCase("monarki")) {
                tanggal = Integer.parseInt(input.nextLine().trim());
                bulan = Integer.parseInt(input.nextLine().trim());
                tahun = Integer.parseInt(input.nextLine().trim());
            }

            daftarNegara.add(new Negara(nama, jenis, pemimpin, tanggal, bulan, tahun));
        }

        for (Negara n : daftarNegara) {
            System.out.println("Negara " + n.getNama() + " mempunyai " + n.getGelar()
                    + " bernama " + n.getNamaPemimpin());
            if (!n.isMonarki()) {
                System.out.println("Deklarasi Kemerdekaan pada Tanggal " + n.getTanggal()
                        + " " + namaBulan.get(n.getBulan()) + " " + n.getTahun());
            }
        }
        input.close();
    }
}
