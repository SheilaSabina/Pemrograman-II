package soal3;
import java.util.Scanner;

public class MainSoal3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Dadu dd = new Dadu();
        int inputnilai = input.nextInt();

        dd.setInput(inputnilai);
        dd.acakDadu();
    }
}
