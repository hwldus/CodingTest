import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) {
            String[] str = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(str[0]);
            arr[i][1] = Integer.parseInt(str[1]);
        }
        Arrays.sort(arr, (x,y) -> {
            if(x[0]==y[0])
                return Integer.compare(x[1],y[1]);
            return Integer.compare(x[0],y[0]);
        });
        StringBuilder sb = new StringBuilder();
        for(int[] a : arr) {
            sb.append(a[0]).append(" ").append(a[1]).append("\n");
        }
        System.out.println(sb);
    }
}