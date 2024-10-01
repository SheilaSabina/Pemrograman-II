package praktikum1;

import java.util.Scanner;

public class PRAK105_2310817220028_SheilaSabina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double phi = 3.14; 

        System.out.print("Masukkan jari-jari: ");
        double jariJari1 = scanner.nextDouble();
        System.out.print("Masukkan tinggi: ");
        double tinggi1 = scanner.nextDouble();
        double volume1 = phi * Math.pow(jariJari1, 2) * tinggi1;

        System.out.printf("Volume tabung dengan jari-jari %.1f cm dan tinggi %.1f cm adalah %.3f m3\n\n", jariJari1, tinggi1, volume1);

        System.out.print("Masukkan jari-jari: ");
        double jariJari2 = scanner.nextDouble();
        System.out.print("Masukkan tinggi: ");
        double tinggi2 = scanner.nextDouble();
        double volume2 = phi * Math.pow(jariJari2, 2) * tinggi2;

        System.out.printf("Volume tabung dengan jari-jari %.1f cm dan tinggi %.1f cm adalah %.3f m3\n\n", jariJari2, tinggi2, volume2);

        System.out.print("Masukkan jari-jari: ");
        double jariJari3 = scanner.nextDouble();
        System.out.print("Masukkan tinggi: ");
        double tinggi3 = scanner.nextDouble();
        double volume3 = phi * Math.pow(jariJari3, 2) * tinggi3;

        System.out.printf("Volume tabung dengan jari-jari %.1f cm dan tinggi %.1f cm adalah %.3f m3\n", jariJari3, tinggi3, volume3);

        scanner.close();
    }
}