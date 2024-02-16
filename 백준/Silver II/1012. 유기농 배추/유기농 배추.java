import java.io.*;
import java.util.*;

public class Main {
    static int M,N,K;
    static int count;
    static boolean[][] visited;
    static int[][] location;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            location = new int[M][N];
            visited = new boolean[M][N];
            for(int j=0; j<K; j++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(str.nextToken());
                int Y = Integer.parseInt(str.nextToken());
                location[X][Y] = 1;
            }
            for(int x=0; x<M; x++) {
                for(int y=0; y<N; y++) {
                    if(location[x][y]==1 && !visited[x][y]) {
                        DFS(x,y);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
    private static void DFS(int x, int y) {
        visited[x][y] = true;
        for(int i=0; i<4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(nx>=0 && nx<M && ny>=0 && ny<N && location[nx][ny]==1 && !visited[nx][ny])
                DFS(nx, ny);
        }
    }
}