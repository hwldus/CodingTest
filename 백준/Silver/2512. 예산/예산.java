import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        int min = 0;
        int max = arr[N-1];
        while(min <= max) {
            int mid = (min+max) / 2;
            long sum = 0;
            for(int i=0; i<N; i++) {
                if(arr[i]>mid) sum += mid;
                else sum += arr[i];
            }
            if(sum <= M) min = mid + 1;
            else max = mid - 1;
        }
        System.out.println(max);
    }
}