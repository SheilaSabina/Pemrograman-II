package soal2;

public class HewanPeliharaan {
    private final String nama;
    private final String ras;
    HewanPeliharaan(String n, String r) {
        nama = n;
        ras = r;
    }
    void display () {
        System.out.println("Detail Hewan Peliharaan:");
        System.out.println("Nama hewan peliharaanku adalah : " + nama);
        System.out.println("Dengan ras : " + ras);
    }
}