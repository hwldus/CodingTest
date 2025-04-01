import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int i=0;
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        while(i<n) {
            if(list.isEmpty()) {
                list.add(arr[i]);
                i++;
            }
            else if(list.get(list.size()-1)<arr[i]){
                list.add(arr[i]);
                i++;
            }
            else {
                list.remove(list.size()-1);
            }
        }
        int[] stk = new int[list.size()];
        for(int j=0; j<list.size(); j++) {
            stk[j] = list.get(j);
        }
        return stk;
    }
}