import java.io.*;
import java.util.*;
public class Main {
    static int M,N;
    static int count;
    static int[][] tomato;
    static boolean[][] visited;
    static int day;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static Queue<int[]> queue = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        count = 0;
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomato = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if(tomato[i][j]==1)
                    queue.offer(new int[]{i,j,0}); //거리, 날짜
            }
        }
        System.out.println(BFS(tomato));
    }
    private static int BFS(int[][] tomato) {
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            day = current[2];

            for(int i=0; i<4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M && tomato[nx][ny]==0 && !visited[nx][ny]) { // 0,0부터 시작
                    visited[nx][ny] = true;
                    tomato[nx][ny] = 1; // 익은 표시
                    queue.offer(new int[]{nx,ny,day+1});
                }
            }
        }
        //모두 익지X
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(tomato[i][j]==0)
                    return -1;
            }
        }
        return day;
    }
}