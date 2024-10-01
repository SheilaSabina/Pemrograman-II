package praktikum1;

import java.util.Scanner;

public class PRAK101_2310817220028_SheilaSabina {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Masukkan Nama Lengkap:");
		String NamaLengkap = input.nextLine();
		System.out.print("Masukkan Tempat Lahir:");
		String TempatLahir = input.nextLine();
		System.out.print("Masukkan Tanggal Lahir:");
		String TanggalLahir = input.nextLine();
		System.out.print("Masukkan Bulan Lahir:");
		int BulanLahir = input.nextInt();
		System.out.print("Masukkan Tahun Lahir:");
		int TahunLahir = input.nextInt();
		System.out.print("Masukkan Tinggi Badan:");
		int TinggiBadan = input.nextInt();
		System.out.print("Masukkan Berat Badan:");
		float BeratBadan = input.nextFloat();
		
		String[] NamaBulan = {
				"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"
		};
		
		System.out.println("\nNama Lengkap " + NamaLengkap +", Lahir di " + TempatLahir + " pada Tanggal " + TanggalLahir + " " + NamaBulan[BulanLahir - 1] + " " + TahunLahir);
		System.out.println("Tinggi Badan " + TinggiBadan + " CM dan Berat Badan " + BeratBadan + " Kilogram ");
	}

}