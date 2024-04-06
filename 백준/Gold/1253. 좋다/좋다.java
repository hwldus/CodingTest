import java.io.*;
import java.util.*;

public class Main  {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int count = 0;
        for(int i=0; i<n; i++) {
            int start = 0;
            int end = n-1;
            while(true) {
                if(start == i)
                    start++;
                else if(end == i) //현재 i위치
                    end--;
                if(start >= end) break; //결과 X
                //합이 더 크다면 작은 수 필요하므로 end 왼쪽이동
                if(arr[start]+arr[end] > arr[i])
                    end--;
                else if(arr[start]+arr[end] < arr[i])
                    start++;
                else { //좋다
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}