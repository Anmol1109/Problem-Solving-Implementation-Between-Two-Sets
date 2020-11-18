import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */
private static int gcd(int a,int b){
        while(b > 0){
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
    
    private static int gcd(List<Integer> a){
        int r = a.get(0);
        for(int i = 1;i < a.size();i ++)
            r = gcd(r,a.get(i));
        return r;
    }

    private static int lcm(int a,int b){
        return a * (b / gcd(a,b));
    }
    
    private static int lcm(List<Integer> a){
        int r = a.get(0);
        for(int i = 1;i < a.size();i++)
            r = lcm(r,a.get(i));
        return r;
    }
    
    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
        int f = lcm(a);
        int l = gcd(b);
        int c = 0;
        for(int i = f,j = 2; i <= l;i = f * j,j++)
            if(l % i == 0)
                c ++;
        return c;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        String[] brrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> brr = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrTemp[i]);
            brr.add(brrItem);
        }

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
