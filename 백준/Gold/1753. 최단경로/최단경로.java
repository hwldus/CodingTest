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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); //정점
        int E = Integer.parseInt(st.nextToken()); //간선
        int K = Integer.parseInt(br.readLine()); // 정점 시작 번호
        boolean[] visited = new boolean[V+1]; //방문 처리
        int[] result = new int[V+1]; //최단 경로 값 저장
        List<Node>[] list = new List[V+1]; //연결 정보 저장

        for(int i=1; i<=V; i++) { //list, result 초기화
            list[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); //출발
            int v = Integer.parseInt(st.nextToken()); //도착
            int w = Integer.parseInt(st.nextToken()); //가중치

            list[u].add(new Node(v,w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2)->n1.weight-n2.weight);
        result[K] = 0;
        pq.add(new Node(K,0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            if(!visited[current.end])
                visited[current.end] = true;
            for(int i=0; i<list[current.end].size(); i++) {
                Node next = list[current.end].get(i);
                if(!visited[next.end] && current.weight+next.weight < result[next.end]) {
                    result[next.end] = current.weight+next.weight;
                    pq.add(new Node(next.end, result[next.end]));
                }
            }
        }
        for(int i=1; i<=V; i++) {
            if(result[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(result[i]);
        }
    }
}