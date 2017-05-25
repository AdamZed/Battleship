// Adam Zanon
// December 15
// Array.1
// This program calculates the sum of valA[] and valB[] and stores it in sum[]

public class Array1 // class name
  { // start class
    public static void main(String[] args) // magic line
    { // start main
        int[] valA = {13, -22, 82, 17}; // stores 4 ints
        int[] valB = {-12, 24, -79, -13}; // stores another 4 ints
        int[] sum = new int[4]; // stores sum of valA[] and valB[]

            for (int index = 0; index < valA.length; index++) // while index < 4
                sum[index] = valA[index] + valB [index]; // adds arrays
            for (int index = 0; index < valA.length; index++) // while index < 4
                System.out.println("Sum of index " + index + " is " + sum[index]);
    } // end main

  } // end class
