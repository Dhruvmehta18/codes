import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * ExtraLongFactorial
 */

class ExtraLongFactorial {

    /**
     * Function for printing array
     * @param array it is array to be printed
     */
    static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }

    /**
     * Function for multiplying large numbers
     * @param res array in which result of multiplication will store
     * @param res_size size of an array that is used
     * @param n the number to which is to be multiplied to res
     * @return result of type int is returned after multiplication is done
     */
    static int multiply(int[] res, int res_size, int n) {
        int carry = 0,i=0;
        while(res[i]==0&&i<res_size) i++;
        for (; i < res_size; i++) {
            int product = res[i]*n+carry;
            res[i]=product%10;
            carry = product/10;
        }
        while(carry!=0){
            res[res_size++]=carry%10;
            carry/=10;
        }
        return res_size;
    }

    /**
     * Function for obtaining large number factorials
     * @param n the number for which the factorial is to be obtained
     */
    static void extraLongFactorials(int n) {
        int res_size = 1;
        int[] res = new int[1000];
        res[0]=1;
        for (int i = 2; i < n; i++) {
            res_size = multiply(res, res_size, i);
        }
        printArray(res);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException{
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
