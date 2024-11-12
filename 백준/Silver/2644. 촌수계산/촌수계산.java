import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static boolean[] visited;
    static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(br.readLine());
        for(int i=0; i<=n; i++) {
            arr.add(new ArrayList<>());
        }
        for(int i=0; i<count; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.get(x).add(y);
            arr.get(y).add(x);
        }
        dfs(start, end, 0);
        System.out.println(result);
    }
    private static void dfs(int now, int next, int count) {
        if(now == next) {
            result = count;
        }
        visited[now] = true;
        for(int nextNode : arr.get(now)) {
            if(!visited[nextNode]) {
                dfs(nextNode, next, count+1);
            }
        }
    }
}