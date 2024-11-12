import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N+1];
            visited = new boolean[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int count = 0;
            for(int j=1; j<=N; j++) {
                if(!visited[j]) {
                    dfs(j);
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
    private static void dfs(int node) {
        visited[node] = true;
        int next = arr[node];
        if (!visited[next]) {
            dfs(next);
        }
    }
}