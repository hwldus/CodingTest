import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

       int minDistance = 1;
        int maxDistance = arr[N-1] - arr[0]; // 가장 먼 두 집 사이의 거리

        while(minDistance <= maxDistance) {
            int mid = (minDistance + maxDistance) / 2;
            int installed = 1; // 첫 번째 집에는 무조건 공유기를 설치
            int prevHouse = arr[0];

            for(int i=1; i<N; i++) {
                if(arr[i] - prevHouse >= mid) {
                    installed++;
                    prevHouse = arr[i];
                }
            }
            if(installed >= C) {
                minDistance = mid + 1;
            } else {
                maxDistance = mid - 1;
            }
        }
        System.out.println(maxDistance);
    }
}