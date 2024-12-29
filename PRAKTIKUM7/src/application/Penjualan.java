package application;

public class Penjualan {
    private int jumlah;
    private double totalHarga;
    private String tanggal;
    private String namaPelanggan;
    private String judulBuku;


    public Penjualan(String namaPelanggan, String judulBuku, int jumlah, double totalHarga, String tanggal) {
        this.namaPelanggan = namaPelanggan;
        this.judulBuku = judulBuku;
        this.jumlah = jumlah;
        this.totalHarga = totalHarga;
        this.tanggal = tanggal;
    }

    public Penjualan(int jumlah2, double totalHarga2, String tanggal2, String namaPelanggan2, String judulBuku2) {
		// TODO Auto-generated constructor stub
	}

	public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    
}
