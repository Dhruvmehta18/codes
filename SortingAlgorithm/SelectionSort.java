import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SelectionSort {

    // Complete the aVeryBigSum function below.
    static int[] selectionsort(int[] ar, int n) {
        for (int i = 0; i < n-1; i++) {
            int min_index = i;
            for (int j = i + 1; j < n; j++) {
                if (ar[j] < a[min_index]) {
                    min_index = j;
                }
            }
            swap(arr[min_index], arr[i]);
        }
        return ar;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int[] result = selectionsort(ar, n);
        System.out.println(result);
    }
}
