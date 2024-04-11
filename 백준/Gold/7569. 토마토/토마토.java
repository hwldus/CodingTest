import java.io.*;
import java.util.*;

class Tomato {
    int x,y,z;
    public Tomato(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
public class Main {
    static int m,n,h;
    static int[][][] box;
    static int[] dx = {0,0,1,-1,0,0}; //상하우좌위아래
    static int[] dy = {1,-1,0,0,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        box = new int[h][n][m];
        for(int i=0; i<h;i++) {
            for(int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<m; k++)
                    box[i][j][k] = Integer.parseInt(st.nextToken());
            }
        }
        int day = BFS();
        if(checkTomato())
            System.out.println(day);
        else System.out.println(-1);
    }
    public static int BFS() {
        Queue<Tomato> queue = new ArrayDeque<>();
        int day = -1;
        for(int i=0; i<h;i++) {
            for(int j=0; j<n; j++) {
                for(int k=0; k<m; k++) {
                    if(box[i][j][k]==1)
                        queue.offer(new Tomato(k,j,i));
                }
            }
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            day++;
            for(int i=0; i<size;i++) {
                Tomato tomato = queue.poll();
                for(int j=0; j<6; j++) {
                    int nx = tomato.x + dx[j];
                    int ny = tomato.y + dy[j];
                    int nz = tomato.z + dz[j];

                    if(nx>=0 && nx<m && ny>=0 && ny<n && nz>=0 && nz<h) {
                        if(box[nz][ny][nx]==0) {
                            box[nz][ny][nx] = 1;
                            queue.offer(new Tomato(nx, ny, nz));
                        }
                    }
                }
            }
        }
        return day;
    }
    public static boolean checkTomato() {
        for(int i=0; i<h;i++) {
            for(int j=0; j<n; j++) {
                for(int k=0; k<m; k++) {
                    if(box[i][j][k]==0)
                        return false;
                }
            }
        }
        return true;
    }
}