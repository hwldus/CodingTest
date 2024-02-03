import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int distance;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=1; i<=N; i++) {
            String str = br.readLine();
            char[] c = str.toCharArray();
            for(int j=1; j<=M; j++)
                arr[i][j] = Character.getNumericValue(c[j-1]);
        }
        visited[1][1] = true;
        BFS(1,1);
    }
    public static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y,1});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            distance = current[2];
            if (currentX == N && currentY == M) 
                break;
            for(int i=0; i<4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];

                if (nx>=1 && nx<=N && ny>=1 && ny<=M && arr[nx][ny]==1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, distance+1});
                }
            }
        }
        System.out.println(distance);
    }
}