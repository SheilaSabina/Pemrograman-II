package PRAKTIKUM6;
import java.util.Scanner;

public class Mahasiswa {
	private int id;
    private String nama;
    private String nim;

    public Mahasiswa(int id, String nama, String nim) {
    	this.id = id;
        this.nama = nama;
        this.nim = nim;
    }
    
    public int getId() {
    	return id;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }
    void getData (){
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Nama Mahasiswa: ");
        nama = input.nextLine();
        System.out.print("Masukkan NIM Mahasiswa (harus unik): ");
        nim = input.nextLine();
    }
}