package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TableView<Mahasiswa> tableView = new TableView<>();
        TableColumn<Mahasiswa, Integer> idColumn = new TableColumn<>("ID");
        TableColumn<Mahasiswa, String> namaColumn = new TableColumn<>("Nama");
        TableColumn<Mahasiswa, String> nimColumn = new TableColumn<>("NIM");

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        namaColumn.setCellValueFactory(new PropertyValueFactory<>("nama"));
        nimColumn.setCellValueFactory(new PropertyValueFactory<>("nim"));

        tableView.getColumns().addAll(idColumn, namaColumn, nimColumn);

        tableView.getItems().addAll(
                new Mahasiswa(1, "Sheila Sabina", "2310817220028"),
                new Mahasiswa(2, "Sela", "2310817220029"),
                new Mahasiswa(3, "Selay", "2310817220021"),
                new Mahasiswa(4, "Selong", "2310817220022"),
                new Mahasiswa(5, "Seli", "2310817220023"),
                new Mahasiswa(6, "Sabina", "2310817220024"),
                new Mahasiswa(7, "Sabrina", "2310817220025"),
                new Mahasiswa(8, "Sheila Majid", "2310817220026"),
                new Mahasiswa(9, "Sheila on Seven", "2310817220027"),
                new Mahasiswa(10, "Sheila Escovedo", "2310817220020")
        );

        VBox box = new VBox(tableView);
        Scene scene = new Scene(box);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}