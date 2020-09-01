
import java.util.*;
import java.io.*;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        while (t > 0) {
            String[] arItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int n = Integer.parseInt(arItems[0]), k = Integer.parseInt(arItems[1]);
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                int arItem = scanner.nextInt();
                ar[i] = arItem;
            }
            
            int l = 0, r = ar.length - 1,ans=-1; 
		while (l <= r) { 
			int m = l + (r - l) / 2;

			// Check if x is present at mid 
			if (ar[m] == k) 
                            ans=1; 

			// If x greater, ignore left half 
			if (ar[m] < k) 
				l = m + 1;

			// If x is smaller, ignore right half 
			else
				r = m - 1; 
		} 
            System.out.println(ans);
            t--;  
        }
        scanner.close();
    }
}
