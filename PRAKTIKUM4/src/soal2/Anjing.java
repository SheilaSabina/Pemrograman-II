package soal2;

public class Anjing extends HewanPeliharaan{
    private final String warnaBuluAnjing;
    private final String kemampuanAnjing;
    Anjing(String n, String r, String warnaBulu, String kemampuan) {
        super(n, r);
        warnaBuluAnjing = warnaBulu;
        kemampuanAnjing = kemampuan;
    }
    void display() {
        super.display();
        System.out.println("Memiliki warna bulu : " + warnaBuluAnjing);
        System.out.println("Memiliki kemampuan : " + kemampuanAnjing);
    }
}