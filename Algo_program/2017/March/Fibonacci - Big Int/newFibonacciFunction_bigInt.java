@@ -1,34 +0,0 @@
import java.io.*;
import java.util.*;
import java.math.BigInteger;

// This function is t(3) = t(2) + t(1) * t(1)
//Calculate t(n) 
//Input   t(1) t(2) n
//output  t(n)
public class newFibonacciFunction_bigInt {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int r [] = new int[3];
        Scanner sc = new Scanner(System.in);
        int i =0;
        while(sc.hasNext()){
            
           r[i] = Integer.parseInt(sc.next());            
            i++;
        }
      
        BigInteger a = BigInteger.valueOf(r[0]);
        BigInteger b = BigInteger.valueOf(r[1]);
        BigInteger c = new BigInteger("0");

        for(i=3;i<=r[2];i++){
           BigInteger k = b.multiply(b);
           c = (BigInteger)a.add(k);
           a = (BigInteger)b;
           b = (BigInteger)c;  
        }
        System.out.println((BigInteger)c);
    }
}
\ No newline at end of file