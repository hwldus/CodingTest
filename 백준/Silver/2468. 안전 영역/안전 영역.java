import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static int max = 0;
    static int safe = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max,map[i][j]);
            }
        }
        for(int h=0; h<=max; h++) {
            visited = new boolean[n][n];
            int count = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(map[i][j]>h && !visited[i][j]) {
                        DFS(i,j,h);
                        count++;
                    }
                }
            }
            safe = Math.max(safe, count);
        }
        System.out.println(safe);
    }
    public static void DFS(int x, int y, int h) {
        visited[x][y] = true;
        for(int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n && map[nx][ny]>h && !visited[nx][ny])
                DFS(nx,ny,h);
        }
    }
}