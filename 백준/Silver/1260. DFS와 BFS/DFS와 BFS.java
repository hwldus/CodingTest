import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++)
            list[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());
            list[start].add(end);
            list[end].add(start);
        }

        DFS(V);
        System.out.println();
        visited = new boolean[N+1];
        BFS(V);
    }
    private static void DFS(int V){
        visited[V] = true;
        System.out.print(V+" ");
        Collections.sort(list[V]);
        for(int x : list[V]) {
            if(!visited[x])
                DFS(x);
        }
    }
    private static void BFS(int V) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(V);
        visited[V] = true;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current+" ");
            List<Integer> sortList = new ArrayList<>(list[current]);
            Collections.sort(sortList);

            for(int x : sortList) {
                if(!visited[x]) {
                    queue.offer(x);
                    visited[x] = true;
                }
            }
        }
    }
}