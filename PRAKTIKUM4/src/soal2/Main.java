package soal2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih jenis hewan yang ingin diinputkan:");
        System.out.println("1 = Kucing");
        System.out.println("2 = Anjing");
        System.out.print("Masukkan pilihan: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        if (pilihan == 1) {
            System.out.print("Nama hewan peliharaan: ");
            String namaKucing = scanner.nextLine();
            System.out.print("Ras: ");
            String rasKucing = scanner.nextLine();
            System.out.print("Warna Bulu: ");
            String warnaBuluKucing = scanner.nextLine();

            Kucing kucing = new Kucing(namaKucing, rasKucing, warnaBuluKucing);
            kucing.display();
        } else if (pilihan == 2) {
            System.out.print("Nama hewan peliharaan: ");
            String namaAnjing = scanner.nextLine();
            System.out.print("Ras: ");
            String rasAnjing = scanner.nextLine();
            System.out.print("Warna Bulu: ");
            String warnaBuluAnjing = scanner.nextLine();
            System.out.print("Kemampuan : ");
            String kemampuanAnjing = scanner.nextLine();

            Anjing anjing = new Anjing(namaAnjing, rasAnjing, warnaBuluAnjing, kemampuanAnjing);
            anjing.display();
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }
}
