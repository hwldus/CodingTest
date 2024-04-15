import java.io.*;
import java.util.*;

public class Main {
    static int[] parents;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parents = new int[n+1];
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++)
            graph[i] = new ArrayList<>();
        visited = new boolean[n+1];
        StringTokenizer st;
        for(int i=1; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }
        BFS(1);
    }
    public static void BFS(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visited[1] = true;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int next : graph[current]) {
                if(visited[next])
                    continue;
                visited[next] = true;
                queue.offer(next);
                parents[next] = current;
            }
        }
        for(int i=2; i<=n; i++) {
            System.out.println(parents[i]);
        }
    }
}