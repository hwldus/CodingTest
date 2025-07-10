class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];
        for(int i=0; i<num_list.length; i++) {
            if(i>=n) {
                answer[i-n] = num_list[i];
            }
            else {
                answer[num_list.length-n+i] = num_list[i];
            }
        }
        return answer;
    }
}