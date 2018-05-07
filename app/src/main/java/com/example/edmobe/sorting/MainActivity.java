
package com.example.edmobe.sorting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Debugging
        int[] array = createRandomArray();
        printArray(array);
        int comparisons = bubbleSort(array);
        printArray(array);
        System.out.println("Comparisons = " + comparisons);

    }

    private int[] createRandomArray() {
        Random random = new Random();
        int max = 40;
        int min = 20;
        int length = random.nextInt(max - min) + min; // the length of the array is a random number between 20 and 40

        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(100);
        }

        return array;
    }

    private void printArray(int[] array) {
        System.out.println("-------------------------------------- ARRAY --------------------------------");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " -> ");
        }
        System.out.println();
        System.out.println("-------------------------------------- END --------------------------------");
    }

    private int bubbleSort(int[] array) {
        int comparisons;
        comparisons = bubbleSort(array, array.length, 0);
        return comparisons;
    }

    private int bubbleSort(int[] array, int n, int comparisons) {
        // Base case
        if (n == 1)
            return comparisons;

        // One pass of bubble sort. After
        // this pass, the largest element
        // is moved (or bubbled) to end.
        for (int i=0; i<n-1; i++)
            if (array[i] > array[i+1])
            {
                // swap arr[i], arr[i+1]
                int temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
                comparisons++;
            }

        // Largest element is fixed,
        // recur for remaining array
        return bubbleSort(array, n-1, comparisons);
    }
}
