package praktikum2.soal3;

public class Pegawai {
    public String nama;
    public String asal;
    public String jabatan;
    public int umur;

    public Pegawai(String nama, String asal, String jabatan, int umur) {
        this.nama = nama;
        this.asal = asal;
        this.jabatan = jabatan;
        this.umur = umur;
    }

    public String getNama() {
        return nama;
    }

    public String getAsal() {
        return asal;
    }

    public void setJabatan(String J) {
        this.jabatan = J;
    }

    public int getUmur() {
        return umur;
    }
}