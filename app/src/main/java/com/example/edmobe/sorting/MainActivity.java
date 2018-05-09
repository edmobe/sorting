
package com.example.edmobe.sorting;

import android.os.SystemClock;
import android.provider.Settings;
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
    TextView txt2;
    Button bttn;
    Button bttn2;
    Button bttn3;
    int[] array;
    int j ;
    int n;
    int c;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txt =  findViewById(R.id.tes);
        txt2 = findViewById(R.id.textView2);
        bttn = findViewById(button);
        bttn2 = findViewById(button2);
        bttn3 = findViewById(button3);

        bttn.setOnClickListener(new View.OnClickListener() { //Generate Button
            @Override
            public void onClick(View v) { //Generate Button

                array = createRandomArray(); //Creates an array
                c = 0;
                n = array.length;
                j = 0;
                String str = Arrays.toString(array); // Change the type of the array to a String
                txt.setText(str); // Set de String array in display
                txt2.setText("Comparasions " + c);
                txt2.setVisibility(1);
                bttn2.setVisibility(1);
                bttn3.setVisibility(1);

            }
        });
        bttn2.setOnClickListener(new View.OnClickListener() { //Sort Button
            @Override
            public void onClick(View v) { //Sort Button
            c += compare(array,j);
            String str = Arrays.toString(array);
            txt.setText(str);
            txt2.setText("Comparasions " + c);

            }
        });
        bttn3.setOnClickListener(new View.OnClickListener() { //Skip Button

            @Override
            public void onClick(View v) { //Skip Button


                c = bubbleSort(array); //
                String str = Arrays.toString(array);
                txt.setText(str);
                txt2.setText("Comparasions " + c);
                txt2.setVisibility(1);


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
        /*Random random = new Random();
        int max = 40;
        int min = 20;
        int length = random.nextInt(max - min) + min; // the length of the array is a random number between 20 and 40

        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(100);
        }
        */
        array = new int[5];

        array[0] = 50;
        array[1] = 30;
        array[2] = 20;
        array[3] = 40;
        array[4] = 10;
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


        c = bubbleSort(array, c);
        return c;
    }

    private int bubbleSort(int[] array, int comparisons) {
        // Base case
        if (n == 1)
            return comparisons;

        // One pass of bubble sort. After
        // this pass, the largest element
        // is moved (or bubbled) to end.
        for (int i=0; i<n-1; i++) {
            if (array[i] > array[i + 1]) {
                // swap arr[i], arr[i+1]
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                comparisons++;

            }


        }
        // Largest element is fixed,
        // recur for remaining array
        this.n--;
        return bubbleSort(array, comparisons);
    }
    private int compare(int[] array, int j){
        if(this.n == 1){
            return 0;
        }else if (j == n-1){
            this.n = n-1;
            this.j = 0;

            return compare(array,this.j);
        }else{
            if(array[j] > array[j+1]){
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                this.j++;
                return 1;
            }else{
                this.j++;
                return 0;

            }
        }

    }
}
