import java.io.*;
import java.util.Arrays;

public class Main {
    static int N;
    static char[][] colors;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static int normalCount,rgCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        colors = new char[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<N; j++)
                colors[i][j] = s.charAt(j);
        }
        //정상
        normalCount=0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    DFS(i,j,colors[i][j]);
                    normalCount++;
                }
            }
        }
        //적록색약
        rgCount=0;
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) { //변경
            for(int j=0; j<N; j++) {
                if(colors[i][j]=='G') colors[i][j] = 'R';
            }
        }
        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    DFS(i, j, colors[i][j]);
                    rgCount++;
                }
            }
        }
        System.out.println(normalCount+" "+rgCount);
    }
    private static void DFS(int x, int y, char current) {
        visited[x][y] = true;
        for(int i=0; i<4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(nx>=0 && nx<N && ny>=0 && ny<N && colors[nx][ny]==current && !visited[nx][ny])
                DFS(nx, ny, current);
        }
    }
}