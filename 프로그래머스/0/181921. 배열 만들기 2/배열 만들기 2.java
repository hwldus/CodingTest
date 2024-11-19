import java.util.*;
class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=l; i<=r; i++) {
            String num = String.valueOf(i);
            String[] nums = num.split("");
            int count = 0;
            for(int j=0; j<nums.length; j++) {
                if(nums[j].equals("0") || nums[j].equals("5"))
                    count++;
            }
            if(count == nums.length) {
                list.add(i);
            }
        }
        if(list.isEmpty()) {
            return new int[]{-1};
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
        return answer;
    }
}