import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] aparts;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static ArrayList<Integer> house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        aparts = new int[N+1][N+1];
        house = new ArrayList<>();
        visited = new boolean[N+1][N+1];

        for(int i=1; i<=N; i++) {
            String str = br.readLine();
            char[] c = str.toCharArray();
            for(int j=1; j<=N; j++)
                aparts[i][j] = Character.getNumericValue(c[j-1]);
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(aparts[i][j]==1 && !visited[i][j]) {
                    int count = DFS(i,j);
                    house.add(count);
                }
            }
        }
        Collections.sort(house);
        System.out.println(house.size());
        for(int h : house)
            System.out.println(h);
    }
    public static int DFS(int x, int y) {
        visited[x][y] = true;
        int count = 1;
        
        for(int i=0; i<4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(nx>=1 && nx<=N && ny>=1 && ny<=N && aparts[nx][ny]==1 && !visited[nx][ny]) {
                count += DFS(nx, ny);
            }
        }
        return count;
    }
}
