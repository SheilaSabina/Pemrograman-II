package soal2;

public class Kucing extends HewanPeliharaan{
    private final String warnaBuluKucing;
    Kucing(String n, String r, String warnaBulu) {
        super(n, r);
        warnaBuluKucing = warnaBulu;
    }
    void display() {
        super.display();
        System.out.println("Memiliki warna bulu : " + warnaBuluKucing);
    }
}