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
        Deque<int[]> deque = new ArrayDeque<>();
        visited = new boolean[100_001];
        deque.offer(new int[]{node,0});
        visited[node] = true;
        while(!deque.isEmpty()) {
            int[] current = deque.poll();
            int curLocation = current[0];
            second = current[1];
            if(curLocation == k) return second;
            int[] nextLocation = {curLocation-1, curLocation+1, curLocation*2};
            for(int next : nextLocation) {
                if(next>=0 && next<=100_000 && !visited[next]) {
                    if(next == curLocation*2)
                        deque.offerFirst(new int[]{next, second});
                    else
                        deque.offerLast(new int[]{next, second+1});
                    visited[next] = true;
                }
            }
        }
        return -1;
    }
}