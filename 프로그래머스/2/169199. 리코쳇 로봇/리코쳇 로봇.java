import java.util.*;

class Solution {
    int N,M;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static int count;
    static boolean[][] visited;
    static Queue<int[]> queue = new ArrayDeque<>();

    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        count = 0;
        visited = new boolean[N][M];
        int startX=0, startY=0, endX=0, endY=0;
        for(int i=0; i<N; i++) {
            String s = board[i];
            for(int j=0; j<M; j++) {
                if (s.charAt(j) == 'R') {
                    queue.offer(new int[]{i,j,0}); //거리, 횟수
                    visited[i][j] = true;
                }
                else if(s.charAt(j) == 'G') {
                    endX = i;
                    endY = j;
                }
            }
        }
        return BFS(endX, endY, board);
    }
    public int BFS(int ex, int ey, String[] board) {
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int cnt = current[2];

            if(currentX==ex && currentY==ey) //목표 도달
                return cnt;

            for(int i=0; i<4; i++) {
                int nx = currentX+dx[i];
                int ny = currentY+dy[i];

                while(nx>=0 && nx<N && ny>=0 && ny<M && board[nx].charAt(ny)!='D') {
                    nx += dx[i];
                    ny += dy[i];
                }
                nx -= dx[i];
                ny -= dy[i];
                if (!visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny, cnt + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}