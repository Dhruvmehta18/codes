
import java.io.DataInputStream;
import java.io.IOException;

class Problem20{
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

    static int multiply(int x, int[] result, int res_size){
        int carry = 0; // Initialize carry 
  
        // One by one multiply n with individual  
        // digits of res[] 
        int i=0;
        while (result[i]==0&&i < res_size) i++;
        for (; i < res_size; i++) 
        { 
            int prod = result[i] * x + carry; 
            result[i] = prod % 10; // Store last digit of  
                                // 'prod' in res[] 
            carry = prod/10; // Put rest in carry 
        } 
  
        // Put carry in res and increase result size 
        while (carry!=0)
        { 
            result[res_size] = carry % 10;
            carry = carry / 10; 
            res_size++; 
        }
        return res_size; 
    }
    static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println("i="+i+"\tarraySum = "+arr[i]);
        }
    }
    static int sumArray(int[] result, int res_size){
        int sum=0,i=0;
        while(result[i]==0&&i<res_size) i++;
        for(;i<res_size;i++){
            sum+=result[i];
        }
        return sum;
    }

    static int[] factorialSum(int n){
        int[] result = new int[2568];
        int[] factorialSum = new int[1001];
        factorialSum[0]=1;
        factorialSum[1]=1;
        result[0]=1;
        int res_size = 1;
        for (int i = 2; i <= n; i++) {
            res_size = multiply(i, result, res_size);
            factorialSum[i] = sumArray(result, res_size);
        }
        return factorialSum;
    }

    public static void main(String[] args) throws IOException{
        int[] factorialSum = factorialSum(1000);
        // printArray(factorialSum);
        Reader r = new Reader();
        int t = r.nextInt();
        for(;t>0;t--){
            int n = r.nextInt();
            System.out.println(factorialSum[n]);
        }
    }
}