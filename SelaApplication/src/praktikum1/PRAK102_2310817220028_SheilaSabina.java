package praktikum1;

import java.util.Scanner;

public class PRAK102_2310817220028_SheilaSabina {
    public static void main(String[] args) {
  
        Scanner scanner = new Scanner(System.in);

        while (true) { 
        	
            System.out.print("Masukkan angka awal deret: ");
            String input = scanner.nextLine(); 

            int start;
            try {
                start = Integer.parseInt(input); 
            } catch (NumberFormatException a) {
                System.out.println("Input tidak valid, masukkan angka yang benar!\n");
                continue;
            }

            int count = 0;
            int number = start;

            while (count < 11) {

                if (count == 10) {
                    if (number % 5 == 0) {
                        System.out.print((number / 5) - 1);
                    } else {
                        System.out.print(number);
                    }
                } else {
                	
                    if (number % 5 == 0) {
                        System.out.print((number / 5) - 1 + ", ");
                    } else {
                        System.out.print(number + ", ");
                    }
                }

                number++;
                count++;
            }

            System.out.println("\n");
        }
    }
}