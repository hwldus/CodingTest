import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] city;
    static ArrayList<int[]> house = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        city = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if(city[i][j] == 1) {
                    house.add(new int[]{i,j});
                }
                if(city[i][j] == 2) {
                    chicken.add(new int[]{i,j});
                }
            }
        }
        visit = new boolean[chicken.size()];
        selectChicken(0,0,visit);
        System.out.println(min);
    }
    private static void selectChicken(int start, int count, boolean[] visit) {
        if(count == m) {
            min = Math.min(min, calculateDistance(visit));
            return;
        }
        for(int i=start; i<chicken.size(); i++) {
            visit[i] = true;
            selectChicken(i+1, count+1, visit);
            visit[i] = false;
        }
    }
    private static int calculateDistance(boolean[] visit) {
        int totalDistance = 0;
        for(int[] h : house) {
            int houseDistance = Integer.MAX_VALUE;
            for(int i=0; i<chicken.size(); i++) {
                if(visit[i]) {
                    int[] chickenShop = chicken.get(i);
                    int distance = Math.abs(h[0]-chickenShop[0]) + Math.abs(h[1]-chickenShop[1]);
                    houseDistance = Math.min(houseDistance, distance);
                }
            }
            totalDistance += houseDistance;
        }
        return totalDistance;
    }
}