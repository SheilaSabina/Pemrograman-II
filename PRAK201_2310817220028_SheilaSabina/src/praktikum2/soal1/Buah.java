package praktikum2.soal1;
 
public class Buah { 
    String nama; 
    double berat; 
    double harga; 
    double jumlahSatuan; 
    double sebelumDiskon; 
    double totalDiskon; 
    double setelahDiskon; 
 
    public Buah (String namaBuah, double beratBuah, double 
hargaBuah, double jumlahBeliBuah){ 
        this.nama = namaBuah; 
        this.berat = beratBuah; 
        this.harga = hargaBuah; 
        this.jumlahSatuan = jumlahBeliBuah; 
        this.sebelumDiskon = hargaBuah * (jumlahBeliBuah / beratBuah); 
        this.totalDiskon = (int)(jumlahBeliBuah / 4) * (4 * hargaBuah) * 0.02; 
        this.setelahDiskon = sebelumDiskon - totalDiskon; 
    } 
    public void tampilkanInfo(){ 
        System.out.println("Nama Buah: "+ nama); 
        System.out.println("Berat: "+ berat); 
        System.out.println("Harga: "+ harga); 
        System.out.println("Jumlah Beli: "+ jumlahSatuan+"kg"); 
        System.out.printf("Harga Sebelum Diskon: Rp%.2f\n", sebelumDiskon); 
        System.out.printf("Total Diskon: Rp%.2f\n", totalDiskon); 
        System.out.printf("Harga Setelah Diskon: Rp%.2f\n\n", setelahDiskon); 
    } 
}