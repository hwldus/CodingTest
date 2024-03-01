import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int key = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(arr, key)).append(" ");
        }
        System.out.println(sb);
    }

    private static int binarySearch(int[] arr, int key) {
        int start = 0;
        int end = arr.length-1;
        while(start<=end) {
            int mid = (start+end) / 2;
            if(key < arr[mid])
                end = mid - 1;
            else if(key > arr[mid])
                start = mid + 1;
            else
                return 1;
        }
        return 0;
    }
}