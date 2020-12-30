/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ryansPC
 */
import java.util.Random;
import java.util.Arrays;

public class NewClas {

    private static int[] data;
    private static final Random generator = new Random();

    public NewClas(int size) {
        data = new int[size];

        for (int i = 0; i < size; i++) {
            data[i] = 10 + generator.nextInt(90);
        }

        Arrays.sort(data);

    }

    public static void main(String[] args) {

    }

    public int binarySearch(int searchElement) {
        int low = 0;
        int high = data.length - 1;
        int middle = (low + high + 1) / 2;
        int location = -1;

        do {
            System.out.print(remainingElements(low, high));

            for (int i = 0; i < middle; i++) {
                System.out.println("  ");
            }

            System.out.println(" * ");

            if (searchElement == data[middle]) {
                location = middle;
            } else if (searchElement < data[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }

            middle = (low + high + 1) / 2;

        } while ((low <= high) && (location == -1));
        return location;
    }

    public String remainingElements(int low, int high) {
        StringBuilder temporary = new StringBuilder();

        for (int i = 0; i < low; i++) {
            temporary.append("  ");
        }

        for (int i = 0; i < high; i++) {
            temporary.append(data[i] + " ");
        }

        temporary.append("\n");
        return temporary.toString();

    }
    
    public String toString(){
        return remainingElements(0,data.length - 1);
    }
    

}
