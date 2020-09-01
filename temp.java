/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

import java.math.*;
import java.text.*;

class CodeChef {
    static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 
  
        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do
            { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        
  
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
  
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
  
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    } 
    static long power_module(long times)
    {
        long prod=1,base=26;
        while(times>0)
        {
            if((times & 1)==1) prod=(prod*base) % 10000009;
            times=times>>1;
            base=(base*base) % 10000009;
        }
        return prod;
    }
    static int reconstruction(String str) {
        char[] arr = str.toCharArray();
        long len = arr.length;
        char c = '?';
        long count = 0;
        for (int i = 0, j = len - i - 1; i < (len-1)/2; i++, j--) {
            if (arr[j] == arr[i] && arr[i] == c) {
                count++;
            }
            if(arr[i]!=arr[n-i-1] && arr[i]!='?' && arr[n-i-1]!='?')
			{
                return 0;
			}
        }
        if(arr[n-i-1]==c && arr[i]==c)
		{
			count++;
		}
		if(arr[n-i-1]!='?'&& arr[i]!='?'&&arr[n-i-1]!=arr[i])
		{
            return 0;
		}
        int ans = power_module(count);
        return ans;
    }

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int testCase = reader.nextInt();
        while(testCase>0){
            String arItems = reader.readLine();
            System.out.println(reconstruction(arItems));
            testCase--;
        }
    }
}