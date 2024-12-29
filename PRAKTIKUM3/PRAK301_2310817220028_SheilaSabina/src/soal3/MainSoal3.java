package soal3;

import java.util.ArrayList;
import java.util.Scanner;

public class MainSoal3 {
    public static void main(String[] args) {
        String nama = "";
        String nim = "";

        Scanner input = new Scanner(System.in);
        Mahasiswa Pertama = new Mahasiswa(nama, nim);
        ArrayList<Mahasiswa> MahasiswaList = new ArrayList<>();

        while (true){
            System.out.println("Menu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
            System.out.println("3. Cari Mahasiswa berdasarkan NIM");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            int pilihan = input.nextInt();
            input.nextLine();
            switch (pilihan){
                case 1:
                Mahasiswa kedua = new Mahasiswa(nama, nim);
                    kedua.getData();
                    MahasiswaList.add(kedua);
                    System.out.print("Mahasiswa "+ kedua.getNama() + " ditambahkan.\n");
                    continue;
                case 2:
                    System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                    String deletenim = input.nextLine();
                    Mahasiswa deletemhs = null;
                    for (Mahasiswa tiga: MahasiswaList){
                        if (tiga.getNim().equalsIgnoreCase(deletenim)){
                            deletemhs = tiga;
                            break;
                        }
                    }
                    if (deletemhs != null){
                        MahasiswaList.remove(deletemhs);
                        System.out.println("Mahasiswa dengan NIM "+ deletenim +" dihapus");
                    } else {
                        System.out.println("Mahasiswa dengan NIM "+ deletenim +" tidak ditemukan");
                    }
                    continue;
                case 3:
                    System.out.print("Masukkan NIM Mahasiswa yang dicari: ");
                    String inputNim = input.nextLine();
                    boolean inputanNim = false;
                    for (Mahasiswa tiga: MahasiswaList){
                        if (tiga.getNim().equalsIgnoreCase(inputNim)){
                            System.out.println("Mahasiswa dengan NIM: "+ tiga.getNim() +" adalah"+ tiga.getNama());
                            inputanNim = true;
                            break;
                        }
                        }
                    if (!inputanNim){
                        System.out.println("Mahasiswa dengan NIM: " + inputNim +" tidak ditemukan");
                    }
                    continue;
                case 4:
                    System.out.println("Daftar Mahasiswa: ");
                    for (Mahasiswa tiga: MahasiswaList){
                        System.out.print("NIM: "+ tiga.getNim()+ ", Nama: "+ tiga.getNama() + "\n");
                    }
                    continue;
                case 0:
                    MahasiswaList.clear();
                    System.out.println("Terima kasih Sudah Menggunakan Program Ini");
                    System.exit(0);
                default:
                    System.out.println("Inputan tidak valid");
            }
        }
    }
}