import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class JumpSearch {

    // Complete the aVeryBigSum function below.
    static int jumpsearching(long[] arr, long x) {
        int n = arr.length;
        int step = (int) Math.floor(Math.sqrt(n));
        for (int i = 0; i < n; i = i + step) {
            System.out.print(i+" ");
            if (arr[i] == x) {
                return 1;
            }
            if (arr[i] > x) {
                int n1 = i;
                for (int j = i - step + 1; j < n1; j++) {
                    System.out.print(j + " ");
                    if (arr[j] == x) {
                        return 1;
                    }
                }
                return -1;
            }
            if (n<i+step-1){
                for (int j = i + 1; j < n; j++) {
                    System.out.print(arr[j] + " ");
                    if (arr[j] == x) {
                        return 1;
                    }
                }
                return -1;
            } 
        }
        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] ar = new long[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            long arItem = Long.parseLong(arItems[i]);
            ar[i] = arItem;
        }
        long x = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int result = jumpsearching(ar,x);
        System.out.print(result);
    }
}
