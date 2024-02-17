import java.io.*;
import java.util.*;

public class Main { 
    static int N,K;
    static int second;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        System.out.println(BFS(N,K));
    }
    private static int BFS(int n,int k) {
        visited = new boolean[100001];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{n,0});
        visited[n] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentLocation = current[0]; //현재위치
            second = current[1]; //소요시간
            if(currentLocation == k) return second;

            int[] nextLocation = {currentLocation-1, currentLocation+1, currentLocation*2};
            for(int next : nextLocation){
                if(next>=0 && next<=100000 && !visited[next]) {
                    queue.offer(new int[]{next, second+1});
                    visited[next] = true;
                }
            }
        }
        return second;
    }
}