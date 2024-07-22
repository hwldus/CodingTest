import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        Arrays.fill(answer, -1);
        for(int i=0; i<queries.length; i++) {
            int[] q = queries[i];
            int s = q[0];
            int e = q[1];
            int k = q[2];
            for(int j=s; j<=e; j++) {
                if(k<arr[j]) {
                    answer[i] = answer[i] == -1 ? arr[j] : Math.min(answer[i], arr[j]);
                }
            }
        }
        return answer;
    }
}