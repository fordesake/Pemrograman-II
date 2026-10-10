package soal3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    private static final HashMap<String, Mahasiswa> indexNim = new HashMap<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            tampilkanMenu();
            pilihan = Integer.parseInt(input.nextLine().trim());

            switch (pilihan) {
                case 1:
                    tambah(input);
                    break;
                case 2:
                    hapus(input);
                    break;
                case 3:
                    cari(input);
                    break;
                case 4:
                    tampilkanSemua();
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        input.close();
    }

    private static void tampilkanMenu() {
        System.out.println("Menu:");
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
        System.out.println("3. Cari Mahasiswa berdasarkan NIM");
        System.out.println("4. Tampilkan Daftar Mahasiswa");
        System.out.println("0. Keluar");
        System.out.print("Pilihan: ");
    }

    private static void tambah(Scanner input) {
        System.out.print("Masukkan Nama Mahasiswa: ");
        String nama = input.nextLine().trim();
        System.out.print("Masukkan NIM Mahasiswa (harus unik): ");
        String nim = input.nextLine().trim();

        if (indexNim.containsKey(nim)) {
            System.out.println("NIM " + nim + " sudah terdaftar. Mahasiswa tidak ditambahkan.");
            return;
        }

        Mahasiswa mhs = new Mahasiswa(nama, nim);
        daftarMahasiswa.add(mhs);
        indexNim.put(nim, mhs);
        System.out.println("Mahasiswa " + nama + " ditambahkan.");
    }

    private static void hapus(Scanner input) {
        System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
        String nim = input.nextLine().trim();

        Mahasiswa mhs = indexNim.get(nim);
        if (mhs == null) {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
            return;
        }

        daftarMahasiswa.remove(mhs);
        indexNim.remove(nim);
        System.out.println("Mahasiswa dengan NIM " + nim + " dihapus.");
    }

    private static void cari(Scanner input) {
        System.out.print("Masukkan NIM Mahasiswa yang dicari: ");
        String nim = input.nextLine().trim();

        Mahasiswa mhs = indexNim.get(nim);
        if (mhs == null) {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        } else {
            System.out.println("Data ditemukan -> NIM: " + mhs.getNim() + ", Nama: " + mhs.getNama());
        }
    }

    private static void tampilkanSemua() {
        if (daftarMahasiswa.isEmpty()) {
            System.out.println("Daftar Mahasiswa kosong.");
            return;
        }
        System.out.println("Daftar Mahasiswa:");
        for (Mahasiswa m : daftarMahasiswa) {
            System.out.println("NIM: " + m.getNim() + ", Nama: " + m.getNama());
        }
    }
}
