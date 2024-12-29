package soal3;

import java.util.LinkedList;
public class Dadu {
    int input, min = 1, max = 6, total;

    public void setInput(int input){
        this.input = input;
    }

    void acakDadu(){
        LinkedList<Integer> LL = new LinkedList<Integer>();
        LL.add(min); LL.add(max);
        for (int i = 0; i < input; i++){
            int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            System.out.println("Dadu ke-" + (i + 1) + " bernilai "+ random_int);
            total += random_int;}
        System.out.println("Total nilai dadu keseluruhan " + total);
    }
}
