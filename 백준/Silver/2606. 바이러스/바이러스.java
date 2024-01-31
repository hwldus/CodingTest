import java.io.*;
import java.util.*;

public class Main {
    static int n,e;
    static ArrayList<Integer>[] dfsList;
    static boolean[] visited;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());
        dfsList = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i=1; i<=n; i++)
            dfsList[i] = new ArrayList<>();
        for(int i=0; i<e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            dfsList[start].add(end);
            dfsList[end].add(start);
        }
        DFS(1);
        for(int i=1; i<=n; i++) {
            if(visited[i]) sum += 1;
        }
        System.out.println(sum-1);
    }
    private static void DFS(int v) {
        visited[v] = true;
        for(int x : dfsList[v]) {
            if(!visited[x]) DFS(x);
        }
    }
}