import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;

// Java program for implementation of Merge Sort 
class MergeSort {
    void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[m + i + 1];
        }
        int i=0, j = 0, k = l;
        while (i <= n1 && j <= n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            k++;
            i++;
        }
        while (j<n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    /*Function to sort array using merge sort*/
    void mergesort(int arr[],int l,int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergesort(arr, l, m);
            mergesort(arr, m + 1, r);
            merge(arr, l, m, r);  
        }
    }

    /* A utility function to print array of size n*/
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    // Driver method 
    public static void main(String args[]) {
        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseint(arItems[i]);
            arr[i] = arItem;
        }

        MergeSort ob = new MergeSort();
        ob.mergesort(arr,0,arr.length-1);

        printArray(arr);
        scanner.close();

    }
}
