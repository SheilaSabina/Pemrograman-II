package application;

import javafx.beans.property.SimpleStringProperty;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert.AlertType;

public class controllerTransaksi {
	@FXML
    private TextField textfieldnama;
    @FXML
    private TextField textfieldemail;
    @FXML
    private TextField textfieldtelepon;
    @FXML
    private TableView<Pelanggan> tableviewpelanggan;
    @FXML
    private TableColumn<Pelanggan, String> coloumnnamapelanggan;
    @FXML
    private TableColumn<Pelanggan, String> coloumnemailpelanggan;
    @FXML
    private TableColumn<Pelanggan, String> coloumnteleponpelanggan;
    @FXML
    private Button buttonaddpelanggan, buttoneditpelanggan, buttondeletepelanggan;
    @FXML
    private ObservableList<Pelanggan> pelangganList;

    @FXML
    private TextField textfieldjudul;
    @FXML
    private TextField textfieldpenulis;
    @FXML
    private TextField textfieldharga;
    @FXML
    private TextField textfieldstok;
    @FXML
    private TableView<Buku> tableviewbuku;
    @FXML
    private TableColumn<Buku, String> coloumnjudulbuku;
    @FXML
    private TableColumn<Buku, String> coloumnpenulisbuku;
    @FXML
    private TableColumn<Buku, Double> coloumnhargabuku;
    @FXML
    private TableColumn<Buku, Integer> coloumnstokbuku;
    @FXML
    private Button buttonaddbuku, buttoneditbuku, buttondeletebuku;
    private ObservableList<Buku> bukuList;

    @FXML
    private ComboBox<String> comboboxnamapenjualan;
    @FXML
    private ComboBox<String> comboboxjudulpenjualan;
    
    @FXML
    private TextField textfieldjumlah;
    @FXML
    private TextField textfieldtotalharga;
    @FXML
    private TextField tanggalPenjualanField;
    @FXML
    private DatePicker datepickertanggal;
    @FXML
    private TableView<Penjualan> tableviewpenjualan;
    @FXML
    private TableColumn<Penjualan, String> coloumnnamapenjualan;
    @FXML
    private TableColumn<Penjualan, String> coloumnjudulpenjualan;
    @FXML
    private TableColumn<Penjualan, Integer> coloumnjumlah;
    @FXML
    private TableColumn<Penjualan, Double> coloumntotalharga;
    @FXML
    private TableColumn<Penjualan, String> coloumntanggal;
    @FXML
    private Button buttonaddPenjualan, buttoneditpenjualan, buttondeletepenjualan;
    private ObservableList<Penjualan> penjualanList;
    
    @FXML
    private void initialize() throws Exception {
        initializepelanggan();
        initializeBuku();
        loaddatapelanggan(); 
        loadDataBuku();      
        initializeCombobox();
        initializepenjualan();
    }


    private void initializepelanggan() throws Exception {
    	coloumnnamapelanggan.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNama()));
    	coloumnemailpelanggan.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
    	coloumnteleponpelanggan.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelepon()));
        loaddatapelanggan();
        
        if (pelangganList == null) {
            pelangganList = FXCollections.observableArrayList();
        }

        tableviewpelanggan.setItems(pelangganList);
    }

    private void initializeBuku() {
    	coloumnjudulbuku.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getJudul()));
    	coloumnpenulisbuku.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPenulis()));
    	coloumnhargabuku.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getHarga()).asObject());
    	coloumnstokbuku.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getStok()).asObject());
        loadDataBuku();
    }

    private void initializepenjualan() {
    	coloumnjumlah.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getJumlah()).asObject());
    	coloumntotalharga.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getTotalHarga()).asObject());
    	coloumntanggal.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTanggal()));
    	coloumnnamapenjualan.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNamaPelanggan()));
    	coloumnjudulpenjualan.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getJudulBuku()));
        loadDataPenjualan();
        penjualanList = FXCollections.observableArrayList();
        tableviewpenjualan.setItems(penjualanList);

    }
    
    private void initializeCombobox() {
        ObservableList<String> pelangganNames = FXCollections.observableArrayList();
        for (Pelanggan pelanggan : pelangganList) {
            pelangganNames.add(pelanggan.getNama());
        }
        comboboxnamapenjualan.setItems(pelangganNames);

        ObservableList<String> bukuTitles = FXCollections.observableArrayList();
        for (Buku buku : bukuList) {
            bukuTitles.add(buku.getJudul());
        }
        comboboxjudulpenjualan.setItems(bukuTitles);

        comboboxnamapenjualan.setOnAction(event -> {
            String selectedName = (String) comboboxnamapenjualan.getSelectionModel().getSelectedItem();
            if (selectedName != null) {
                showAlert("Pelanggan Dipilih", "Nama pelanggan: " + selectedName);
            }
        });

        comboboxjudulpenjualan.setOnAction(event -> {
            String selectedTitle = (String) comboboxjudulpenjualan.getSelectionModel().getSelectedItem();
            if (selectedTitle != null) {
                showAlert("Buku Dipilih", "Judul buku: " + selectedTitle);
            }
        });
    }

    @FXML
    private void loaddatapelanggan() throws Exception {
        pelangganList = FXCollections.observableArrayList();
        
        String query = "SELECT * FROM pelanggan";
        try (Connection conn = DatabaseConnect.connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String nama = rs.getString("nama");
                String email = rs.getString("email");
                String telepon = rs.getString("telepon");

                Pelanggan pelanggan = new Pelanggan(nama, email, telepon);
                pelangganList.add(pelanggan);
            }

            tableviewpelanggan.setItems(pelangganList);
        } catch (SQLException | ClassNotFoundException e) {
            showAlert("Database Error", "Gagal memuat data dari database.\n" + e.getMessage(), Alert.AlertType.ERROR);
        }
    }


    private void loadDataBuku() {
        bukuList = FXCollections.observableArrayList();
        try (Connection conn = DatabaseConnect.connect();
             Statement stat = conn.createStatement();
             ResultSet rs = stat.executeQuery("SELECT * FROM buku")) {
            while (rs.next()) {
                bukuList.add(new Buku(rs.getString("judul"), rs.getString("penulis"), rs.getDouble("harga"), rs.getInt("stok")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tableviewbuku.setItems(bukuList);
    }

    private void loadDataPenjualan() {
        penjualanList = FXCollections.observableArrayList();
        try (Connection conn = DatabaseConnect.connect();
             Statement stat = conn.createStatement();
             ResultSet rs = stat.executeQuery("SELECT * FROM penjualan")) {
            while (rs.next()) {
                penjualanList.add(new Penjualan(null, null, rs.getInt("jumlah"), rs.getDouble("total_harga"), rs.getString("tanggal")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tableviewpenjualan.setItems(penjualanList);
    }
    
    private void updateComboboxData() throws Exception {
        ObservableList<String> pelangganNames = FXCollections.observableArrayList();

        String query = "SELECT nama FROM pelanggan";
        try (Connection conn = DatabaseConnect.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String nama = rs.getString("nama");
                pelangganNames.add(nama);
            }

            comboboxnamapenjualan.setItems(pelangganNames);

        } catch (SQLException | ClassNotFoundException e) {
            showAlert("Database Error", "Gagal memperbarui data ComboBox.\n" + e.getMessage(), AlertType.ERROR);
        }
    }


    @FXML
    private void handleaddpelanggan(ActionEvent event) throws Exception {
        if (pelangganList == null) {
            pelangganList = FXCollections.observableArrayList();
        }

        String nama = textfieldnama.getText().trim();
        String email = textfieldemail.getText().trim();
        String telepon = textfieldtelepon.getText().trim();

        if (nama.isEmpty() || email.isEmpty() || telepon.isEmpty()) {
            showAlert("Validation Error", "Semua field harus diisi!", Alert.AlertType.WARNING);
            return;
        }

        String query = "INSERT INTO pelanggan (nama, email, telepon) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnect.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nama);
            stmt.setString(2, email);
            stmt.setString(3, telepon);
            stmt.executeUpdate();

            Pelanggan newPelanggan = new Pelanggan(nama, email, telepon);
            pelangganList.add(newPelanggan);

            tableviewpelanggan.setItems(pelangganList);

            updateComboboxData();

            clearFields();

            tableviewpelanggan.refresh();  // Refresh the TableView to reflect changes
            showAlert("Success", "Data pelanggan berhasil ditambahkan.", Alert.AlertType.INFORMATION);
        } catch (SQLException | ClassNotFoundException e) {
            showAlert("Database Error", "Gagal menambahkan data ke database.\n" + e.getMessage(), AlertType.ERROR);
        }
    }


    @FXML
    private void handleeditpelanggan(ActionEvent event) throws Exception {
        Pelanggan pelangganDipilih = tableviewpelanggan.getSelectionModel().getSelectedItem();

        if (pelangganDipilih == null) {
            showAlert("Error", "Pilih pelanggan yang ingin diedit!", Alert.AlertType.ERROR);
            return;
        }

        String nama = textfieldnama.getText();
        String telepon = textfieldtelepon.getText();
        String email = textfieldemail.getText();

        if (nama.isEmpty() || telepon.isEmpty() || email.isEmpty()) {
            showAlert("Error", "Semua field harus diisi!", Alert.AlertType.ERROR);
            return;
        }
        
        if (telepon.startsWith("0")) {
            telepon = "-1" + telepon.substring(1);
        }

        try (Connection conn = DatabaseConnect.connect()) {
            String sql = "UPDATE pelanggan SET nama = ?, telepon = ?, email = ? WHERE nama = ? AND telepon = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nama);
            stmt.setString(2, telepon);
            stmt.setString(3, email);
            stmt.setString(4, pelangganDipilih.getNama());
            stmt.setString(5, pelangganDipilih.getTelepon());
            stmt.executeUpdate();

            showAlert("Sukses", "Data pelanggan berhasil diupdate.", Alert.AlertType.INFORMATION);

            pelangganDipilih.setNama(nama);
            pelangganDipilih.setTelepon(telepon);
            pelangganDipilih.setEmail(email);

            tableviewpelanggan.refresh();
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "Gagal mengupdate data di database.", Alert.AlertType.ERROR);
        }
    }


    @FXML
    private void handledeletepelanggan(ActionEvent event) throws Exception {
        Pelanggan pelangganDipilih = tableviewpelanggan.getSelectionModel().getSelectedItem();

        if (pelangganDipilih == null) {
            showAlert("Error", "Pilih pelanggan yang ingin dihapus!", Alert.AlertType.ERROR);
            return;
        }

        if (pelangganDipilih.getNama() == null || pelangganDipilih.getNama().isEmpty()) {
            showAlert("Error", "Nama pelanggan tidak ditemukan!", Alert.AlertType.ERROR);
            return;
        }

        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Konfirmasi Hapus");
        confirmationAlert.setContentText("Apakah Anda yakin ingin menghapus pelanggan dengan nama \"" + pelangganDipilih.getNama() + "\"?");

        if (confirmationAlert.showAndWait().orElse(null) == ButtonType.OK) {
            try (Connection conn = DatabaseConnect.connect()) {
                String sql = "DELETE FROM pelanggan WHERE nama = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, pelangganDipilih.getNama());
                stmt.executeUpdate();

                showAlert("Sukses", "Pelanggan berhasil dihapus dari database.", Alert.AlertType.INFORMATION);

                pelangganList.remove(pelangganDipilih);
            } catch (SQLException e) {
                e.printStackTrace();
                showAlert("Error", "Gagal menghapus data pelanggan dari database.", Alert.AlertType.ERROR);
            }
        }
    }

    
    @FXML
    private void handleaddbuku(ActionEvent event) throws Exception {
        if (bukuList == null) {
            bukuList = FXCollections.observableArrayList();
        }

        String judul = textfieldjudul.getText().trim();
        String penulis = textfieldpenulis.getText().trim();
        String hargaText = textfieldharga.getText().trim();
        String stokText = textfieldstok.getText().trim();

        if (judul.isEmpty() || penulis.isEmpty() || hargaText.isEmpty() || stokText.isEmpty()) {
            showAlert("Validation Error", "Semua field harus diisi!", Alert.AlertType.WARNING);
            return;
        }

        int harga;
        int stok;
        try {
            harga = Integer.parseInt(hargaText);
            stok = Integer.parseInt(stokText);
        } catch (NumberFormatException e) {
            showAlert("Validation Error", "Harga dan Stok harus berupa angka!", Alert.AlertType.WARNING);
            return;
        }

        String query = "INSERT INTO buku (judul, penulis, harga, stok) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnect.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, judul);
            stmt.setString(2, penulis);
            stmt.setInt(3, harga);
            stmt.setInt(4, stok);
            stmt.executeUpdate();

            Buku newBuku = new Buku(judul, penulis, harga, stok);
            bukuList.add(newBuku);  // Add to the list

            tableviewbuku.setItems(bukuList); // Ensure TableView gets updated with the new list

            updateComboboxData();

            clearFields();

            tableviewbuku.refresh();
            showAlert("Success", "Data buku berhasil ditambahkan.", Alert.AlertType.INFORMATION);
        } catch (SQLException | ClassNotFoundException e) {
            showAlert("Database Error", "Gagal menambahkan data ke database.\n" + e.getMessage(), Alert.AlertType.ERROR);
        }
    }


    
    @FXML
    private void handleeditbuku() {
        try {
            Buku selectedBuku = tableviewbuku.getSelectionModel().getSelectedItem();

            if (selectedBuku == null) {
                showAlert("Warning", "Silakan pilih buku yang akan diedit.");
                return;
            }

            String judul = textfieldjudul.getText();
            String penulis = textfieldpenulis.getText();
            String hargaText = textfieldharga.getText();
            String stokText = textfieldstok.getText();

            if (judul.isEmpty() || penulis.isEmpty() || hargaText.isEmpty() || stokText.isEmpty()) {
                showAlert("Warning", "Semua kolom harus diisi.");
                return;
            }

            int harga = 0;
            int stok = 0;
            try {
                harga = Integer.parseInt(hargaText);
                stok = Integer.parseInt(stokText);
            } catch (NumberFormatException e) {
                showAlert("Warning", "Harga dan Stok harus berupa angka.");
                return;
            }

            try (Connection conn = DatabaseConnect.connect()) {
                String sql = "UPDATE buku SET judul = ?, penulis = ?, harga = ?, stok = ? WHERE judul = ? AND penulis = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, judul);
                stmt.setString(2, penulis);
                stmt.setInt(3, harga);
                stmt.setInt(4, stok);
                stmt.setString(5, selectedBuku.getJudul());
                stmt.setString(6, selectedBuku.getPenulis()); 

                int rowsAffected = stmt.executeUpdate();
                
                if (rowsAffected > 0) {
                    selectedBuku.setJudul(judul);
                    selectedBuku.setPenulis(penulis);
                    selectedBuku.setHarga(harga);
                    selectedBuku.setStok(stok);
                    
                    tableviewbuku.refresh(); 
                    showAlert("Berhasil", "Data buku berhasil diperbarui!");
                } else {
                    showAlert("Error", "Data buku tidak ditemukan untuk diperbarui.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
                showAlert("Error", "Gagal mengupdate data buku di database.");
            }

            clearFields();
            
        } catch (Exception e) {
            showAlert("Error", "Gagal memperbarui data buku: " + e.getMessage());
        }
    }

    @FXML
    private void handledeletebuku(ActionEvent event) throws Exception {
        Buku bukuDipilih = tableviewbuku.getSelectionModel().getSelectedItem();

        if (bukuDipilih == null) {
            showAlert("Error", "Pilih buku yang ingin dihapus!", Alert.AlertType.ERROR);
            return;
        }

        if (bukuDipilih.getJudul() == null || bukuDipilih.getJudul().isEmpty()) {
            showAlert("Error", "Judul buku tidak ditemukan!", Alert.AlertType.ERROR);
            return;
        }

        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Konfirmasi Hapus");
        confirmationAlert.setContentText("Apakah Anda yakin ingin menghapus buku dengan judul \"" + bukuDipilih.getJudul() + "\"?");

        if (confirmationAlert.showAndWait().orElse(null) == ButtonType.OK) {
            try (Connection conn = DatabaseConnect.connect()) {
                String sql = "DELETE FROM buku WHERE judul = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, bukuDipilih.getJudul());
                stmt.executeUpdate();

                showAlert("Sukses", "Buku berhasil dihapus dari database.", Alert.AlertType.INFORMATION);

                bukuList.remove(bukuDipilih);
            } catch (SQLException e) {
                e.printStackTrace();
                showAlert("Error", "Gagal menghapus data buku dari database.", Alert.AlertType.ERROR);
            }
        }
    
    }

    @FXML
    private void handleaddpenjualan(ActionEvent event) throws Exception {
        if (penjualanList == null) {
            penjualanList = FXCollections.observableArrayList();
        }

        String jumlahText = textfieldjumlah.getText().trim();
        String totalHargaText = textfieldtotalharga.getText().trim();
        String tanggal = datepickertanggal.getValue() != null ? datepickertanggal.getValue().toString() : "";

        if (jumlahText.isEmpty() || totalHargaText.isEmpty() || tanggal.isEmpty()) {
            showAlert("Validation Error", "Semua field harus diisi!", Alert.AlertType.WARNING);
            return;
        }

        int jumlah;
        double totalHarga;
        try {
            jumlah = Integer.parseInt(jumlahText);
            totalHarga = Double.parseDouble(totalHargaText);
        } catch (NumberFormatException e) {
            showAlert("Validation Error", "Jumlah dan Total Harga harus berupa angka!", Alert.AlertType.WARNING);
            return;
        }

        String namaPelanggan = comboboxnamapenjualan.getSelectionModel().getSelectedItem();
        findPelangganByName(namaPelanggan);
        
        String judulBuku = comboboxjudulpenjualan.getSelectionModel().getSelectedItem();
        findBukuByTitle(judulBuku);


        String query = "INSERT INTO penjualan (jumlah, total_harga, tanggal, nama_pelanggan, judul_buku) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnect.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
        	
            stmt.setInt(1, jumlah);
            stmt.setDouble(2, totalHarga);
            stmt.setString(3, tanggal);
            stmt.setString(4, namaPelanggan);
            stmt.setString(5, judulBuku); 
            
            
            Penjualan newPenjualan = new Penjualan(jumlah, totalHarga, tanggal, namaPelanggan, judulBuku);
            penjualanList.add(newPenjualan);

            tableviewpenjualan.setItems(penjualanList);

            updateComboboxData();

            clearFields();

            tableviewpenjualan.refresh();
            showAlert("Success", "Data penjualan berhasil ditambahkan.", Alert.AlertType.INFORMATION);
        } catch (SQLException | ClassNotFoundException e) {
            showAlert("Database Error", "Gagal menambahkan data ke database.\n" + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    
    private Buku findBukuByTitle(String judulBuku) {
		return null;
	}


	private Pelanggan findPelangganByName(String namaPelanggan) {
		return null;
	}


	@FXML
    private void handleeditpenjualan() {
        try {
            Penjualan selectedPenjualan = tableviewpenjualan.getSelectionModel().getSelectedItem();
            if (selectedPenjualan == null) {
                showAlert("Warning", "Silakan pilih penjualan yang akan diedit.");
                return;
            }

            int jumlah = Integer.parseInt(textfieldjumlah.getText());
            int totalHarga = Integer.parseInt(textfieldtotalharga.getText());
            String tanggal = tanggalPenjualanField.getText();

            if (jumlah <= 0 || totalHarga <= 0 || tanggal.isEmpty()) {
                showAlert("Warning", "Semua kolom harus diisi dan valid.");
                return;
            }

            DatabaseConnect.editpenjualan(jumlah, totalHarga, String.valueOf(tanggal));

            selectedPenjualan.setJumlah(jumlah);
            selectedPenjualan.setTotalHarga(totalHarga);
            selectedPenjualan.setTanggal(tanggal);

            tableviewpenjualan.refresh();
            clearFields();
            showAlert("Berhasil", "Data penjualan berhasil diperbarui!");
        } catch (Exception e) {
            showAlert("Error", "Gagal memperbarui data penjualan: " + e.getMessage());
        }
    }

    @FXML
    private void handledeletepenjualan(ActionEvent event) throws Exception {
        Penjualan penjualanDipilih = tableviewpenjualan.getSelectionModel().getSelectedItem();

        if (penjualanDipilih == null) {
            showAlert("Error", "Pilih penjualan yang ingin dihapus!", Alert.AlertType.ERROR);
            return;
        }

        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Konfirmasi Hapus");
        confirmationAlert.setContentText("Apakah Anda yakin ingin menghapus penjualan dengan produk \"" + penjualanDipilih.getTanggal() + "\"?");

        if (confirmationAlert.showAndWait().orElse(null) == ButtonType.OK) {
            try (Connection conn = DatabaseConnect.connect()) {
                String sql = "DELETE FROM penjualan WHERE nama_produk = ? AND tanggal_penjualan = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, penjualanDipilih.getTanggal());
                stmt.setDate(2, java.sql.Date.valueOf(penjualanDipilih.getTanggal()));

                stmt.executeUpdate();

                showAlert("Sukses", "Penjualan berhasil dihapus dari database.", Alert.AlertType.INFORMATION);

                penjualanList.remove(penjualanDipilih);
            } catch (SQLException e) {
                e.printStackTrace();
                showAlert("Error", "Gagal menghapus data penjualan dari database.", Alert.AlertType.ERROR);
            }
        }
    }

    @FXML
    private void handlecomboboxnamapelanggan() {
        String selectedName = comboboxnamapenjualan.getSelectionModel().getSelectedItem();
        if (selectedName != null) {
            showAlert("Pelanggan Dipilih", "Nama pelanggan: " + selectedName);
        }
    }

    @FXML
    private void handlecomboboxjudulbuku() {
        String selectedTitle = comboboxjudulpenjualan.getSelectionModel().getSelectedItem();
        if (selectedTitle != null) {
            showAlert("Buku Dipilih", "Judul buku: " + selectedTitle);
        }
    }

    private void clearFields() {
    	textfieldnama.clear();
    	textfieldemail.clear();
    	textfieldtelepon.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
