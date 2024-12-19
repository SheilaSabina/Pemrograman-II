import java.util.ArrayList;

public class DatabaseMahasiswa {
    public static void main(String[] args) {
        // Membuat list untuk menyimpan data mahasiswa
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

        // Menambahkan 10 data mahasiswa secara hardcode
        daftarMahasiswa.add(new Mahasiswa("123456", "Sheila Sabina"));
        daftarMahasiswa.add(new Mahasiswa("123457", "Iwan Suryana"));
        daftarMahasiswa.add(new Mahasiswa("123458", "Rani Yuliana"));
        daftarMahasiswa.add(new Mahasiswa("123459", "Budi Santoso"));
        daftarMahasiswa.add(new Mahasiswa("123460", "Lina Supriani"));
        daftarMahasiswa.add(new Mahasiswa("123461", "Doni Prabowo"));
        daftarMahasiswa.add(new Mahasiswa("123462", "Sari Melani"));
        daftarMahasiswa.add(new Mahasiswa("123463", "Tono Kurniawan"));
        daftarMahasiswa.add(new Mahasiswa("123464", "Wati Anggraini"));
        daftarMahasiswa.add(new Mahasiswa("123465", "Fauzi Rahman"));

        // Menampilkan data dalam bentuk tabel
        System.out.println("| NIM       | Nama              |");
        System.out.println("|-----------|-------------------|");
        
        for (Mahasiswa mhs : daftarMahasiswa) {
            System.out.printf("| %-9s | %-17s |\n", mhs.getNim(), mhs.getNama());
        }
    }
}
