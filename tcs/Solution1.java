package tcs;

import java.util.Scanner;

public class Solution1 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int k = 0; k < arCount; k++) {
            int[] d = new int[3];
            int[] v = new int[3];
            String[] arItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < 3; i++) {
                int arItem = Integer.parseInt(arItems[i]);
                d[i] = arItem;
            }
            String[] arItems1 = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < 3; i++) {
                int arItem = Integer.parseInt(arItems1[i]);
                v[i] = arItem;
            }

            int c = scanner.nextInt();

            boolean result = getAligned(v, c);
            String ans = result?"YES":"NO";
            System.out.println(ans);
        }

        scanner.close();
    }

    private static boolean getAligned(int[] v, int c) {
        int[] degrees = new int[3];
        boolean checkDuplicate = false;
        for (int i = 0; i < v.length; i++) {
            degrees[i] = (v[i] * c) % 360;
            if(i>0){
                checkDuplicate = degrees[i-1] == degrees[i];
                if (!checkDuplicate){
                    break;
                }
            }
        }
        return checkDuplicate;
    }
}
