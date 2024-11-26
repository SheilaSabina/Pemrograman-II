package soal2;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String namaNegara = "", jenisKepemimpinan = "", namaPemimpin = "";
        int tanggalKemerdekaan = 0, bulanKemerdekaan = 0, tahunKemerdekaan = 0;
        Scanner input = new Scanner(System.in);
        LinkedList<Negara> ObjekNegara = new LinkedList<Negara>();
        int inputUser = input.nextInt();
        for (int i = 0; i < inputUser; i++){
            Negara tampungNegara = new Negara(namaNegara, jenisKepemimpinan,
                    namaPemimpin, tanggalKemerdekaan, bulanKemerdekaan, tahunKemerdekaan);
            tampungNegara.getData();
            ObjekNegara.add(tampungNegara);
        }
        for (int i = 0; i < ObjekNegara.size(); i++){
            Negara Cetak = ObjekNegara.get(i);
            Cetak.tampilkan();
        }
    }
}