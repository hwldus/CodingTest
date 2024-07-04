import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int n,m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        dfs(0);
        System.out.println(sb);
    }
    public static void dfs(int d) {
        if(d == m) {
            for(int x : arr) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<n; i++) {
            arr[d] = i+1;
            dfs(d+1);
        }
    }
}