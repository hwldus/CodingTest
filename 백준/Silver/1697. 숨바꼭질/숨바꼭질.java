import java.io.*;
import java.util.*;

public class Main {
    static int n,k;
    static int second;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int result = bfs(n);
        System.out.println(result);
    }
    private static int bfs(int node) {
        visited = new boolean[100001];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{node, 0});
        visited[node] = true;
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int curLocation = current[0];
            second = current[1];
            if(curLocation == k) return second;
            int[] nextLocation = {curLocation-1, curLocation+1, curLocation*2};
            for(int next : nextLocation) {
                if(next>=0 && next<=100000 && !visited[next]) {
                    queue.offer(new int[]{next, second+1});
                    visited[next] = true;
                }
            }
        }
        return second;
    }
}
