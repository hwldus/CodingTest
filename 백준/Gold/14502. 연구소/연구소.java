import java.io.*;
import java.util.*;
public class Main {
    static int N,M;
    static int[][] location;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static int maxSafe = Integer.MIN_VALUE; //최대값을 찾기 위한 최소값 설정
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        location = new int[N][M];
        for(int i=0; i<N; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                location[i][j] = Integer.parseInt(str.nextToken());
            }
        }
        makeWall(0);
        System.out.println(maxSafe);
    }
    private static void makeWall(int wall) { //벽세우기
        if(wall==3) {
            countSafe();
            return;
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(location[i][j]==0) {
                    location[i][j]=1; //벽
                    makeWall(wall+1); //재귀(dfs)
                    location[i][j] = 0; //모두 탐색해야 하므로 다시 0으로 만들기
                }
            }
        }
    }
    private static void countSafe() { //안전구역 세기
        int[][] newLocation = new int[N][M]; //새로운 배열 생성
        for(int i=0; i<N; i++)
            newLocation[i] = Arrays.copyOfRange(location[i],0,M);

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(newLocation[i][j]==2)
                    virus(newLocation,i,j); //바이러스 전파(bfs)
            }
        }
        int count = 0;
        for(int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                if (newLocation[i][j] == 0)
                    count++;
            }
        }
        maxSafe = Math.max(maxSafe, count);
    }
    private static void virus(int[][] newLocation, int x, int y) { //바이러스 전파시키기
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x,y});
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M && newLocation[nx][ny]==0) {
                    newLocation[nx][ny] = 2;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}