
import java.util.Scanner;

//Problem Statement: 
// Array and String operations using class and objects

class Array {

    // Method to reverse an array
    int[] reverseArray(int[] a, int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = a[n - 1 - i]; // copy elements in reverse order
        }
        return res;
    }

    // Method to sort an array using Bubble Sort
    int[] sortArray(int[] a, int n) {
        int[] b = new int[n];
        // Copy original array into new array
        for (int i = 0; i < n; i++) {
            b[i] = a[i];
        }
        // Bubble sort algorithm
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (b[j] > b[j + 1]) {
                    int t = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = t;
                }
            }
        }
        return b;
    }

    // Method to search for an element in the array
    int searchArray(int[] a, int n, int key) {
        for (int i = 0; i < n; i++) {
            if (a[i] == key) {
                return i + 1; // return position (1-based index)
            }
        }
        return -1; // return -1 if not found
    }

    // Method to calculate average of array elements
    double avgArray(int[] a, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + a[i];
        }
        return (double) sum / n; // cast to double for decimal result
    }

    // Method to find maximum element in array
    int maxArray(int[] a, int n) {
        int max = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

   


    // Main method to test all operations
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Array obj = new Array();

        // Input array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Input array elements
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Reverse array
        int[] rev = obj.reverseArray(arr, n);
        System.out.print("Reversed Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(rev[i] + " ");
        }
        System.out.println();

        // Sort array
        int[] sorted = obj.sortArray(arr, n);
        System.out.print("Sorted Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(sorted[i] + " ");
        }
        System.out.println();

        // Average and maximum
        System.out.println("Average = " + obj.avgArray(arr, n));
        System.out.println("Maximum element = " + obj.maxArray(arr, n));

        // Search element in array
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();
        int pos = obj.searchArray(arr, n, key);
        if (pos == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at position: " + pos);
        }
        sc.close();
    }
}
