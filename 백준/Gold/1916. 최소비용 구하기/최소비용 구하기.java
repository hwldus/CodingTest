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
    static int N, M;
    static ArrayList<PriorityQueue<Node>> list; //경로 정보 저장
    static int[] result; //최단 거리 저장
    static boolean[] visited; //방문 저장

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); //도시
        M = Integer.parseInt(br.readLine()); //버스
        list = new ArrayList<>();
        result = new int[N+1];
        visited = new boolean[N+1];
        Arrays.fill(result, Integer.MAX_VALUE);

        for(int i=0; i<=N; i++)
            list.add(new PriorityQueue<>());

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(end, weight));
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        System.out.println(dijkstra(s,e));
    }
    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        result[start] = 0;
        pq.add(new Node(start,0));
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int cur = current.end;
            if(!visited[cur])
                visited[cur] = true;
            for (Node next : list.get(cur)) {
                if (!visited[next.end] && current.weight + next.weight < result[next.end]) {
                    result[next.end] = current.weight + next.weight;
                    pq.add(new Node(next.end, result[next.end]));
                }
            }
        }
        return result[end];
    }
}