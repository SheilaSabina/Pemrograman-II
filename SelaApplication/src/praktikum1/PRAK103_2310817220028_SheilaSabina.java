package praktikum1;

import java.util.Scanner;

public class PRAK103_2310817220028_SheilaSabina { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
        	
            System.out.print("Masukkan N (jumlah bilangan) dan bilangan awal: ");
            int N = scanner.nextInt();
            int bilanganAwal = scanner.nextInt();
            
            int count = 0;

            System.out.print("");
            do {
                if (bilanganAwal % 2 != 0) {
                    System.out.print(bilanganAwal);
                    count++;
                    if (count < N) {
                        System.out.print(", ");
                    }
                }
                bilanganAwal++;
            } while (count < N);
            
            System.out.println();
            
            System.out.println();
        }
    }
}