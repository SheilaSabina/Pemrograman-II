package application;

public class Pelanggan {
	private String Nama;
	private String Email;
	private String Telepon;
	
	public Pelanggan(String Nama, String Email, String Telepon) {
		this.Nama = Nama;
		this.Email = Email;
		this.Telepon = Telepon;
	}
	
	public String getNama() {
		return Nama;
	}
	
	public void setNama(String Nama) {
		this.Nama = Nama;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String Email) {
		this.Email = Email;
	}
	
	public String getTelepon() {
		return Telepon;
	}
	
	public void setTelepon(String Telepon) {
		this.Telepon = Telepon;
	}
}