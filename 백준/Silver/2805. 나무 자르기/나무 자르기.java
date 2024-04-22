import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int n = Integer.parseInt(st.nextToken());
       int m = Integer.parseInt(st.nextToken());
       st = new StringTokenizer(br.readLine());
       int[] arr = new int[n];
       int high = 0;
       for(int i=0; i<n; i++) {
           arr[i] = Integer.parseInt(st.nextToken());
           high = Math.max(high, arr[i]);
       }
       int min = 0;
       int max = high;
       while(min < max) {
           int mid = (min+max) / 2;
           long sum = 0;
           for(int x : arr) {
               if(x-mid > 0)
                   sum += x-mid;
           }
           if(sum >= m)
               min = mid+1;
           else
               max = mid;
       }
       System.out.println(min-1);
   }
}