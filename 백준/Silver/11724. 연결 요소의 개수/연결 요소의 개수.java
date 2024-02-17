import java.io.*;
import java.util.*;

public class Main {
    static int N,M, count;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //정점
        M = Integer.parseInt(st.nextToken()); //간선
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++)
            graph[i] = new ArrayList<>();
        for(int i=0; i<M; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(str.nextToken());
            int end = Integer.parseInt(str.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }
        count = 0;
        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                DFS(i);
                count++;
            }
        }
        System.out.println(count);
    }
    private static void DFS(int n) {
        visited[n] = true;
        for(int next : graph[n]) {
            if(!visited[next]) DFS(next);
        }
    }
}