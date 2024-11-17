import java.io.*;

public class Main {
    static int[][] map;
    static int n, k, targetX, targetY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int x = n/2, y = n/2;
        int num = 1, dir = 1;
        map[x][y] = num;
        while(true) {
           for(int i=0; i<dir; i++) {
               map[y--][x] = num++;
           }
           if(num-1 == n*n) break;
           for(int i=0; i<dir; i++) {
               map[y][x++] = num++;
           }
           dir++;
           for(int i=0; i<dir; i++) {
               map[y++][x] = num++;
           }
           for(int i=0; i<dir; i++) {
               map[y][x--] = num++;
           }
           dir++;
        }
        StringBuilder sb = new StringBuilder();
        targetX=0; targetY=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j]==k) {
                    targetX = i+1;
                    targetY = j+1;
                }
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append(targetX).append(" ").append(targetY);
        System.out.println(sb);
    }
}