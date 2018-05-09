
package com.example.edmobe.sorting;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

import static com.example.edmobe.sorting.R.id.button;
import static com.example.edmobe.sorting.R.id.button2;
import static com.example.edmobe.sorting.R.id.button3;

public class MainActivity extends AppCompatActivity {
    //  Vatiable declaration
    TextView txt;
    Button bttn;
    Button bttn2;
    Button bttn3;
    int[] array;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txt =  findViewById(R.id.tes);
        bttn = findViewById(button);
        bttn2 = findViewById(button2);
        bttn3 = findViewById(button3);

        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                array = createRandomArray();
                String str = Arrays.toString(array);
                txt.setText(str);
                bttn2.setVisibility(1);
                bttn3.setVisibility(1);
                //Mostrar la cantidad de comparaciones
                //nuevo boton que vaya mostrando paso a paso
            }
        });
        bttn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int comparisons = bubbleSort(array);
                String str = Arrays.toString(array);
                txt.setText(str);
            }
        });
        bttn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                txt.setText("Hola");


            }
        });
        //Debugging
        /*
        int[] array = createRandomArray();
        printArray(array);
        int comparisons = bubbleSort(array);
        printArray(array);
        System.out.println("Comparisons = " + comparisons);
        */

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
