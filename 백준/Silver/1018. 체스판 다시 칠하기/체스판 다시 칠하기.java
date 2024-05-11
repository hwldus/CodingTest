import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] arr;
    static int min = 64;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new boolean[n][m];
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                if(str.charAt(j) == 'W')
                    arr[i][j] = true;
                else
                    arr[i][j] = false;
            }
        }
        int row = n-7;
        int col = m-7;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                map(i,j);
            }
        }
        System.out.println(min);
    }
    public static void map(int x, int y) {
        int dx = x+8;
        int dy = y+8;
        int count = 0;
        boolean color = arr[x][y];
        for(int i=x; i<dx; i++) {
            for(int j=y; j<dy; j++) {
                if(arr[i][j] != color) {
                    count++;
                }
                color = !color;
            }
            color = !color;
        }
        count = Math.min(count, 64-count);
        min = Math.min(min, count);
    }
}