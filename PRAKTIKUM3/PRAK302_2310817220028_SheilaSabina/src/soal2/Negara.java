package soal2;
import java.util.*;

public class Negara {
    private String namaNegara, jenisKepemimpinan, namaPemimpin;
    private int tanggalKemerdekaan, bulanKemerdekaan, tahunKemerdekaan;
    public Negara(String namaNegara, String jenisKepemimpinan, String namaPemimpin, int tanggalKemerdekaan, int bulanKemerdekaan, int tahunKemerdekaan){
        this.namaNegara = namaNegara;
        this.jenisKepemimpinan = jenisKepemimpinan;
        this.namaPemimpin = namaPemimpin;
        this.tanggalKemerdekaan = tanggalKemerdekaan;
        this.bulanKemerdekaan = bulanKemerdekaan;
        this.tahunKemerdekaan = tahunKemerdekaan;
    }
    public int getBulan(){
        return bulanKemerdekaan;
    }
    void getData(){
        try (Scanner input = new Scanner(System.in)) {
			namaNegara = input.nextLine();
			jenisKepemimpinan = input.nextLine();
			namaPemimpin = input.nextLine();
			if (!(jenisKepemimpinan.equalsIgnoreCase("monarki"))) {
			    tanggalKemerdekaan = input.nextInt();
			    bulanKemerdekaan = input.nextInt();
			    tahunKemerdekaan = input.nextInt();
			}
		}
    }
    void tampilkan(){
        HashMap<Integer, String> month = new HashMap<Integer,String>();
        month.put(1, "Januari");
        month.put(2, "Februari");
        month.put(3, "Maret");
        month.put(4, "April");
        month.put(5, "Mei");
        month.put(6, "Juni");
        month.put(7, "Juli");
        month.put(8, "Agustus");
        month.put(9, "September");
        month.put(10, "Oktober");
        month.put(11, "November");
        month.put(12, "Desember");
        if( jenisKepemimpinan.equalsIgnoreCase("monarki") ) {
            System.out.println("Negara " + namaNegara + " mempunyai Raja bernama " + namaPemimpin + "\n");
        } else if ( jenisKepemimpinan.equalsIgnoreCase("presiden") ){
            System.out.println("Negara " + namaNegara + " mempunyai Presiden bernama " + namaPemimpin );
        } else if ( jenisKepemimpinan.equalsIgnoreCase("perdana menteri") ){
            System.out.println("Negara " + namaNegara + " mempunyai Perdana Menteri bernama " + namaPemimpin );
        }
        if (
        jenisKepemimpinan.equalsIgnoreCase("presiden")||jenisKepemimpinan.equalsIgnoreCase("perdana menteri") ) {
                System.out.println("Deklarasi Kemerdekaan pada Tanggal " + tanggalKemerdekaan +
                        " " + month.get(getBulan())+ " " + tahunKemerdekaan + "\n");
        }
    }
}