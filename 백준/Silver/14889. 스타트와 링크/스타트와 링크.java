import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        makeTeam(0,0);
        System.out.println(min);
    }
    private static void makeTeam(int depth, int start) {
        if(depth == n/2) {
            min = Math.min(min, getDiff());
            return;
        }
        for(int i=start; i<n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                makeTeam(depth+1, i+1);
                visit[i] = false;
            }
        }
    }
    private static int getDiff() {
        int start = 0;
        int link = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i==j) continue;
                if(visit[i] && visit[j])
                    start += map[i][j];
                if(!visit[i] && !visit[j])
                    link += map[i][j];
            }
        }
        return Math.abs(start - link);
    }
}