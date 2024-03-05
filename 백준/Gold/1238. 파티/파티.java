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
        return this.weight - node.weight;
    }
}

public class Main {
    static int N,M,X;
    static int[] distance;
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        distance = new int[N+1];
        visited = new boolean[N+1];

        for(int i=0; i<=N; i++)
            list[i] = new ArrayList<>();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,t)); //단방향
        }
        int min = 0;
        for(int i=1; i<=N; i++) { //학생 수 반복
            if(i==X) continue;
            int result = dijkstra(i,X) + dijkstra(X,i);
            if(result > min) min = result;
        }
        System.out.println(min);
    }
    public static int dijkstra(int start, int end) {
        Arrays.fill(distance,INF);
        Arrays.fill(visited, false);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.add(new Node(start,0));
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            if(!visited[current.end])
                visited[current.end] = true;
            for(Node next : list[current.end]) {
                if(!visited[next.end] && current.weight+next.weight < distance[next.end]) {
                    distance[next.end] = current.weight+next.weight;
                    pq.add(new Node(next.end, distance[next.end]));
                }
            }
        }
        return distance[end];
    }
}