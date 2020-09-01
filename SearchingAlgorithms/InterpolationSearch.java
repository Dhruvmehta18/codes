import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class InterpolationSearch {

    // Complete the aVeryBigSum function below.
    static int interpolationSearch(int[] arr, int x) {
        int lo = 0, hi = arr.length - 1,ans=-1; 
        while (lo - hi != 0) {
            //calculation of pos for likelyhood of the index location in the array
			int pos = lo + ((x-arr[lo])*(hi-lo) / (arr[hi]-arr[lo]));
            System.out.print(arr[pos] + " ");
			// Check if x is present at pos
            if (arr[pos] == x) {
                ans = 1;
                return ans;
            } 

			// If x greater, ignore left half 
			if (arr[pos] < x){
			    lo = pos + 1;
			}
			// If x is smaller, ignore right half 
			else{
				hi = pos - 1;
			}
        }
        return ans;
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
        int x = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int result = interpolationSearch(ar,x);
        System.out.print(result);
    }
}