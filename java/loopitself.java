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

public class loopitself {

    private static int[] data;
    private static final Random generator = new Random();

    public static void main(String[] args) {
        
        linearArray(1000);
        System.out.println(RLinearSearch(data,data.length-1,15));

    }

    public static void linearArray(int size) {
         data = new int[size];

        for (int i = 0; i < size; i++) {
            data[i] = 10 + generator.nextInt(90);
        }
    }

    public static int RLinearSearch(int A[], int n, int key) {
        if (n < 0) { // Base case - not found
            return -1;
        }
        if (A[n] == key) { // Base case - found
            return n;
        }
        // Recursive case
        return RLinearSearch(A, n - 1, key);
    }
}
