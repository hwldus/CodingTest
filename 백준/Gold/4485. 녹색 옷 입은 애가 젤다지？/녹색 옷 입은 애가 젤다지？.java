import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int x, y, cost;
    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node n) {
        return this.cost - n.cost;
    }
}
public class Main {
    static int[][] map;
    static int[][] cost;
    static boolean[][] visited;
    static int[] dirX = {1,0,-1,0};
    static int[] dirY = {0,-1,0,1};
    static int n, nx, ny;
    public static void main(String[] args) throws IOException {
        int count = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String temp = "";
        while(!(temp = br.readLine()).isEmpty()) {
            n = Integer.parseInt(temp);
            if(n==0)
                break;
            map = new int[n][n];
            cost = new int[n][n];
            visited = new boolean[n][n];
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    cost[i][j] = Integer.MAX_VALUE;
                }
            }
            BFS(0,0);
            sb.append("Problem "+count+": "+cost[n-1][n-1]).append("\n");
            count++;
        }
        System.out.println(sb);
    }
    public static void BFS(int x, int y) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        visited[x][y] = true;
        pq.offer(new Node(0, 0, map[0][0]));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            for(int i=0; i<4; i++) {
                nx = current.x + dirX[i];
                ny = current.y + dirY[i];
                if (nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny] && cost[nx][ny]>(map[nx][ny]+current.cost)) {
                    cost[nx][ny] = map[nx][ny] + current.cost;
                    visited[nx][ny] = true;
                    pq.offer(new Node(nx, ny, cost[nx][ny]));
                }
            }
        }
    }
}