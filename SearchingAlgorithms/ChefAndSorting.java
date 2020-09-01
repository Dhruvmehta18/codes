import java.util.*;
import java.io.*;
public class ChefAndSorting {

    static long chefSort(long arr[],int n){
        long[] cum = new long[n];
        cum[n-1]=arr[n-1];
        for (int i=n-2; i>=0; i--) {
            cum[i]=min(arr[i],cum[i+1]);
        }
        long ans=0,mm=1000000000;
        for (int i=0; i<n; i++) {
            if(min(mm,cum[i])<arr[i+1]){
                ans++;
                mm=min(mm,arr[i]);
            }
        }
        return ans;
    }

    static long min(long a,long b){
        if (a>b) {
            return a;
        }
        else{
            return b;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
        int time = scanner.nextInt();

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        while(time!=0){
            int n=scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            long[] ar = new long[n];

            String[] arItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < arItems.length; i++) {
                long arItem = Long.parseLong(arItems[i]);
                ar[i] = arItem;
            }

            long result = chefSort(ar,n);
            System.out.println(result);
            time--;
        }
        scanner.close();
    }
}
