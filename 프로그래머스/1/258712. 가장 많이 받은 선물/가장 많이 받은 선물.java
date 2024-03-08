import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<friends.length; i++)
            map.put(friends[i], i);
        int[] index = new int[friends.length];
        int[][] record = new int[friends.length][friends.length];
        
        for(String str:gifts) {
            String[] current = str.split(" ");
            index[map.get(current[0])]++;
            index[map.get(current[1])]--;
            record[map.get(current[0])][map.get(current[1])]++;
        }
        int answer = 0;
        for(int i=0; i<friends.length; i++) {
            int count = 0;
            for(int j=0; j<friends.length; j++) {
                if(i==j) continue;
                if(record[i][j] > record[j][i]) count++;
                else if(record[i][j]==record[j][i] && index[i]>index[j]) count++;
            }
            answer = Math.max(count, answer);
        }
        return answer;
    }
}