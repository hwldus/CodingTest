import java.util.*;

class Solution {
    static int startX;
    static int startY;

    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        Map<String, int[]> map = new HashMap<>();
        map.put("E", new int[]{0,1});
        map.put("W", new int[]{0,-1});
        map.put("S", new int[]{1,0});
        map.put("N", new int[]{-1,0});
        
        startX = 0;
        startY = 0;
        
        String[][] arr = new String[park.length][park[0].length()]; //공원 위치, 시작파악
        for(int i=0; i<park.length; i++) {
            String[] cur = park[i].split("");
            for(int j=0; j<cur.length; j++) {
                arr[i][j] = cur[j];
                if(cur[j].equals("S")) {
                    startX = i;
                    startY = j;
                }
            }
        }
        
        for(int i=0; i<routes.length; i++) {
            String[] cur = routes[i].split(" ");
            int[] point = map.get(cur[0]);
            move(arr, startX, startY, point, Integer.parseInt(cur[1]));
        }
        answer[0] = startX;
        answer[1] = startY;
        return answer;
    }
    public void move(String[][] arr, int x, int y, int[] point, int count) { //재귀탐색
        if(count == 0) {
            startX = x;
            startY = y;
            return;
        }
        int nextX = x+point[0];
        int nextY = y+point[1];
        if(nextX>=0 && nextX<arr.length && nextY>=0 && nextY<arr[0].length) {
            if(!arr[nextX][nextY].equals("X"))
                move(arr, nextX, nextY, point, count-1);
        }
    }
}