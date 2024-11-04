import java.io.*;
import java.util.*;

public class Main {
    static int S;
    static int second;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        int result = bfs(S);
        System.out.println(result);
    }
    private static int bfs(int s) {
        Queue<int[]> queue = new ArrayDeque<>();
        visited = new boolean[2001][2001];
        queue.offer(new int[]{1,0,0}); //현재 화면, 클립보드, 시간(횟수)
        visited[1][0] = true; //현재 화면, 클립보드
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int now = current[0];
            int clip = current[1];
            second = current[2];
            if(now==s) return second;
            if(now>0 && now<1000 && !visited[now][now]) { //화면의 이모티콘을 클립보드에 저장
                queue.offer(new int[]{now,now,second+1});
                visited[now][now] = true;
            }
            if(clip>0 && now+clip<2000 && !visited[now+clip][clip]) { //클립보드 이모티콘을 화면끝에 붙여넣기
                queue.offer(new int[]{now+clip,clip,second+1});
                visited[now+clip][clip] = true;
            }
            if(now>1 && !visited[now-1][clip]) { //화면 이모티콘 1개 줄이기
                queue.offer(new int[]{now-1, clip, second+1});
                visited[now-1][clip] = true;
            }

        }
        return -1;
    }
}