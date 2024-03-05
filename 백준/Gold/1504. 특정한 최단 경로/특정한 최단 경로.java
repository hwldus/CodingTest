import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int end, weight;
    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node node) {
        return weight - node.weight;
    }
}
public class Main {
    static int N,E,result;
    static int INF = 200000000;
    static ArrayList<Node>[] list;
    static int[] distance;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //정점
        E = Integer.parseInt(st.nextToken()); //간선
        list = new ArrayList[N+1];
        distance = new int[N+1];
        visited = new boolean[N+1];

        for(int i=0; i<=N; i++)
            list[i] = new ArrayList<>();
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        int result1 = 0;
        result1 = dijkstra(1,v1) + dijkstra(v1,v2) + dijkstra(v2,N);
        int result2 = 0;
        result2 = dijkstra(1,v2) + dijkstra(v2,v1) + dijkstra(v1,N);
        result = 0;
        if(result1>=INF && result2>=INF)
            result = -1;
        else
            result = Math.min(result1, result2);
        System.out.println(result);
    }
    public static int dijkstra(int start, int end) {
        Arrays.fill(distance, INF);
        Arrays.fill(visited, false);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.add(new Node(start,0));
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            if(current.end == end)
                break;
            if(visited[current.end]) continue;
            visited[current.end] = true;

            for(Node node : list[current.end]) {
                if(current.weight+node.weight < distance[node.end]) {
                    distance[node.end] = current.weight+node.weight;
                    pq.add(new Node(node.end, distance[node.end]));
                }
            }
        }
        return distance[end];
    }
}