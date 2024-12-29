package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnect {
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/praktikum7";
	private static final String USER = "root";
	private static final String PASS = "";
	
	public static Connection connect() throws Exception{
		Class.forName(JDBC_DRIVER);
		return DriverManager.getConnection(DB_URL, USER, PASS);
	}

	public static void addpelanggan(String Nama, String Email, String Telepon) throws Exception {
        String query = "INSERT INTO pelanggan (nama, email, telepon) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, Nama);
            stmt.setString(2, Email);
            stmt.setString(3, Telepon);
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                }
            }
        }
    }

    public static void addbuku(String judul, String penulis, double harga, int stok) throws Exception {
        String query = "INSERT INTO buku (judul, penulis, harga, stok) VALUES (?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, judul);
            stmt.setString(2, penulis);
            stmt.setDouble(3, harga);
            stmt.setInt(4, stok);
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                }
            }
        }
    }

    public static void addpenjualan(int jumlah, double total_harga, String tanggal) throws Exception {
        String query = "INSERT INTO penjualan (jumlah, total_harga, tanggal) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, jumlah);
            stmt.setDouble(2, total_harga);
            stmt.setString(3, tanggal);
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                }
            }
        }
    }

    public static List<String> getPelanggan() throws Exception {
        String query = "SELECT * FROM pelanggan";
        List<String> result = new ArrayList<>();
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                result.add(rs.getString("nama") + ", " + rs.getString("email") + ", " + rs.getString("telepon"));
            }
        }
        return result;
    }

    public static List<String> getBuku() throws Exception {
        String query = "SELECT * FROM buku";
        List<String> result = new ArrayList<>();
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                result.add(rs.getString("judul") + ", " + rs.getString("penulis") + ", " + rs.getDouble("harga") + ", " + rs.getInt("stok"));
            }
        }
        return result;
    }

    public static List<String> getPenjualan() throws Exception {
        String query = "SELECT * FROM data_penjualan";
        List<String> result = new ArrayList<>();
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                result.add(rs.getInt("jumlah") + ", " + rs.getDouble("total_harga") + ", " + rs.getString("tanggal"));
            }
        }
        return result;
    }

    // Update Methods
    public static void editpelanggan(String nama, String email, String telepon) throws Exception {
        String query = "UPDATE pelanggan SET nama = ?, email = ?, telepon = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nama);
            stmt.setString(2, email);
            stmt.setString(3, telepon);
            stmt.executeUpdate();
        }
    }

    public static void editbuku(String judul, String penulis, double harga, int stok) throws Exception {
        String query = "UPDATE data_buku SET judul = ?, penulis = ?, harga = ?, stok = ? WHERE buku_id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, judul);
            stmt.setString(2, penulis);
            stmt.setDouble(3, harga);
            stmt.setInt(4, stok);
            stmt.executeUpdate();
        }
    }

    public static void editpenjualan(int jumlah, double total_harga, String tanggal) throws Exception {
        String query = "UPDATE penjualan SET jumlah = ?, total_harga = ?, tanggal = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, jumlah);
            stmt.setDouble(2, total_harga);
            stmt.setString(3, tanggal);
            stmt.executeUpdate();
        }
    }

    // Delete Methods
    public static void deletepelanggan(String nama) throws Exception {
        String query = "DELETE FROM pelanggan WHERE nama = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nama);
            stmt.executeUpdate();
        }
    }

    public static void deletebuku(String judul) throws Exception {
        String query = "DELETE FROM buku WHERE judul = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, judul);
            stmt.executeUpdate();
        }
    }

    public static void deletepenjualan(int jumlah) throws Exception {
        String query = "DELETE FROM penjualan WHERE jumlah = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, jumlah);
            stmt.executeUpdate();
        }
    }
}