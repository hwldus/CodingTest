import java.io.*;
import java.util.*;

class Maze implements Comparable<Maze> {
    int row, col, cost;

    public Maze(int row, int col, int cost) {
        this.row = row;
        this.col = col;
        this.cost = cost;
    }
    @Override
    public int compareTo(Maze maze) {
        return Integer.compare(this.cost, maze.cost);
    }
}

public class Main {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static int[][] maze;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); //가로
        int N = Integer.parseInt(st.nextToken()); //세로
        maze = new int[N][M];
        for(int i=0; i<N; i++) {
            String row = br.readLine();
            for(int j=0; j<M; j++)
                maze[i][j] = row.charAt(j) - '0';
        }
        int result = dijkstra(N, M);
        System.out.println(result);
    }
    public static int dijkstra(int N, int M) {
        PriorityQueue<Maze> pq = new PriorityQueue<>();
        int[][] distance = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++)
                distance[i][j] = Integer.MAX_VALUE;
        }
        distance[0][0] = 0;
        pq.offer(new Maze(0,0,0));

        while(!pq.isEmpty()) {
            Maze current = pq.poll();
            if(current.row==N-1 && current.col==M-1)
                return distance[N-1][M-1];
            for(int i=0; i<4; i++) {
                int nx = current.row + dx[i];
                int ny = current.col + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M) {
                    int newCost = current.cost + maze[nx][ny];
                    if(newCost < distance[nx][ny]) {
                        distance[nx][ny] = newCost;
                        pq.offer(new Maze(nx,ny,newCost));
                    }
                }
            }
        }
        return -1; //불가능 경로
    }
}