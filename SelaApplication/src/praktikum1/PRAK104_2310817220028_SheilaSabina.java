package praktikum1;

import java.util.Scanner;

public class PRAK104_2310817220028_SheilaSabina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
        	
            System.out.print("Tangan Abu: ");
            String abuInput = scanner.nextLine();
            String[] abuPilihan = abuInput.split(" ");
            
            System.out.print("Tangan Bagas: ");
            String bagasInput = scanner.nextLine();
            String[] bagasPilihan = bagasInput.split(" ");
            
            if (abuPilihan.length != 3 || bagasPilihan.length != 3) {
                System.out.println("Input harus terdiri dari 3 pilihan! Program dihentikan.");
                break;
            }
            
            int abuSkor = 0;
            int bagasSkor = 0;

            for (int i = 0; i < 3; i++) {
                char abu = abuPilihan[i].charAt(0);
                char bagas = bagasPilihan[i].charAt(0);
                
                if (abu == bagas) {
                    continue;
                } else if ((abu == 'B' && bagas == 'G') || (abu == 'G' && bagas == 'K') || (abu == 'K' && bagas == 'B')) {
                    abuSkor++;
                } else {
                    bagasSkor++;
                }
            }

            if (abuSkor > bagasSkor) {
                System.out.println("Abu");
            } else if (bagasSkor > abuSkor) {
                System.out.println("Bagas");
            } else {
                System.out.println("Seri");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}