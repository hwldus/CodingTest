import java.io.*;
import java.util.*;

public class Main {
    static int n,k;
    static boolean[] visited;
    static int second;
    static int[] prev; //이전 위치 저장
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int result = bfs(n);
        sb.append(result).append("\n");
        Stack<Integer> path = new Stack<>();
        for(int i=k; i!=n; i=prev[i]) {
            path.push(i);
        }
        path.push(n);
        while(!path.isEmpty()) {
            sb.append(path.pop()).append(" ");
        }
        System.out.println(sb);
    }
    private static int bfs(int node) {
        visited = new boolean[100001];
        Queue<int[]> queue = new ArrayDeque<>(); //위치, 이동 초(횟수)
        queue.offer(new int[]{node, 0});
        visited[node] = true;
        prev = new int[100001];

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int curLocation = current[0];
            second = current[1];
            if(curLocation == k) return second;
            int[] nextLocation = {curLocation-1, curLocation+1, curLocation*2};
            for(int next : nextLocation) {
                if(next>=0 && next<=100000 && !visited[next]) {
                    queue.offer(new int[]{next, second+1});
                    prev[next] = curLocation;
                    visited[next] = true;
                }
            }
        }
        return -1;
    }
}