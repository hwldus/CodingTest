import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int end, weight;
    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
    public int compareTo(Node node) {
        return weight - node.weight;
    }
}
public class Main {
    static int MAX = 100000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int result = dijkstra(start, end);
        System.out.println(result);
    }
    public static int dijkstra(int start, int end) {
        int[] time = new int[MAX+1]; //최소 이동시간
        Arrays.fill(time, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        time[start] = 0; //시작 위치 이동시간은 0
        pq.offer(new Node(start, 0));
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            if(current.end == end)
                return time[end];
            //순간이동
            int teleportLocation = current.end*2;
            int teleportTime = current.weight;
            if(teleportLocation<=MAX && teleportTime<time[teleportLocation]) {
                time[teleportLocation] = teleportTime;
                pq.offer(new Node(teleportLocation, teleportTime));
            }
            //걷기
            int[] walkPositions = {current.end + 1, current.end - 1};
            for (int walkPos : walkPositions) {
                int walkTime = current.weight + 1;
                if (walkPos >= 0 && walkPos <= MAX && time[walkPos] > walkTime) {
                    time[walkPos] = walkTime;
                    pq.offer(new Node(walkPos, walkTime));
                }
            }
        }
        return time[end];
    }
}