import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int max = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        int left = 0;
        int right = max;
        while(left < right) {
            int mid = (left+right) / 2;
            long sum = 0;
            for(int x : arr) {
                if(x-mid > 0)
                    sum += x - mid;
            }
            if(sum >= M)
                left = mid + 1;
            else
                right = mid;
        }
        System.out.println(left-1);
    }
}