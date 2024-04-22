import java.io.*;
import java.util.*;

public class Main {
    static int m,n,k;
    static int count;
    static boolean[][] visited;
    static int[][] location;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++) {
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            location = new int[m][n];
            visited = new boolean[m][n];
            for(int j=0; j<k; j++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(str.nextToken());
                int y = Integer.parseInt(str.nextToken());
                location[x][y] = 1;
            }
            for(int x=0; x<m; x++) {
                for(int y=0; y<n; y++) {
                    if(location[x][y]==1 && !visited[x][y]) {
                        DFS(x,y);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
    private static void DFS(int x, int y) {
        visited[x][y] = true;
        for(int i=0; i<4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(nx>=0 && nx<m && ny>=0 && ny<n && location[nx][ny]==1 && !visited[nx][ny])
                DFS(nx,ny);
        }
    }
}