import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1,o2)->o1[1]-o2[1]); //e 기준 오름차순 정렬
        int t = 0;
        for(int i=0; i<targets.length; i++) {
            if(t <= targets[i][0]) {
                t = targets[i][1];
                answer++;
            }
        }
        return answer;
    }
}