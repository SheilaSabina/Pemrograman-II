package soal1;
import java.util.LinkedList;

public class Dadu {
    private int angka;
    int hasil;
    void setInput( int input ) {
        this.angka = input;
    }
    LinkedList<Integer> ObjekDadu = new LinkedList<Integer>();
    void acakNilai() {
        for( int i = 1; i <= this.angka; i++ ) {
            int nilaiAcak = 1 + (int)(Math.random() * 6);
            ObjekDadu.add(nilaiAcak);
            this.hasil = this.hasil + nilaiAcak;
        }
    }
    void totalDadu() {
        for( int i = 1; i <= this.angka; i++ ) {
            System.out.println("Dadu ke-" + i + " bernilai " + ObjekDadu.get(i-1));
        }
        System.out.println("Total nilai dadu keseluruhan " + this.hasil);
    }
}