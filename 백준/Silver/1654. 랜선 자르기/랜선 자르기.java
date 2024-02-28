import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); //랜선 수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선 수
        int[] arr = new int[K];
        long end = 0;
        for(int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(end < arr[i]) end = arr[i];
        }
        end++;
        long start = 0;
        long mid = 0;
        while(start<end) {
            long lan = 0;
            mid = (start+end) / 2;
            for(int i=0; i<arr.length; i++)
                lan += arr[i] / mid;
            if(lan < N)
                end = mid;
            else
                start = mid + 1;
        }
        System.out.println(start-1);
    }
}