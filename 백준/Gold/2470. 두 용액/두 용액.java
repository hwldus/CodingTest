import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int[] result = new int[2];
        int start = 0;
        int end = n-1;
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr); //오름차순 정렬
        while(start < end) {
            int sum = arr[start] + arr[end];
            if(min > Math.abs(sum)) {
                min = Math.abs(sum);
                result[0] = arr[start];
                result[1] = arr[end];
                if(sum==0) break;
            }
            if(sum < 0)
                start++; //값이 커져야 함
            else
                end--; //값이 작아져야 함
        }
        System.out.println(result[0]+" "+result[1]);
    }
}