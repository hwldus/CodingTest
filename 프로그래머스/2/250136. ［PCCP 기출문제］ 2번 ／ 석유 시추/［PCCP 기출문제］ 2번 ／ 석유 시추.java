import java.util.*;

class Solution {
    int[][] land;
    int n,m; //가로, 세로
    int[][] oil; // 덩어리 저장
    boolean[][] visited; //방문확인
    public int solution(int[][] land) {
        this.land = land;
        n = land.length;
        m = land[0].length;
        oil = new int[n][m];
        visited = new boolean[n][m];
        int oilId = 0;
        Map<Integer, Integer> oilSize = new HashMap<>(); //석유 덩어리 크기 저장

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(land[i][j] == 1 && !visited[i][j]) {
                    int size = bfs(i,j,oilId);
                    oilSize.put(oilId, size);
                    oilId++;
                }
            }
        }

        int[] oilSum = new int[m];
        for(int i=0; i<m; i++) {
            Set<Integer> oilSet = new HashSet<>();
            for(int j=0; j<n; j++) {
                if(land[j][i]==1)
                    oilSet.add(oil[j][i]);
            }
            for(int id : oilSet)
                oilSum[i] += oilSize.get(id);
        }
        return Arrays.stream(oilSum).max().getAsInt();
    }
    
    private int bfs(int x, int y, int oilId) { //석유 덩어리 찾고 크기 return
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;
        oil[x][y] = oilId;
        int size = 1;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && land[nx][ny]==1 &&!visited[nx][ny]) {
                    queue.offer(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    oil[nx][ny] = oilId;
                    size++;
                }
            }
        }
        return size;
    }
}