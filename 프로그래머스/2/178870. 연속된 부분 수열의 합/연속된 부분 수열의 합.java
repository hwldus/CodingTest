class Solution {
    public int[] solution(int[] sequence, int k) {
        int size = sequence.length;
        int left = 0;
        int sum = 0;
        int answer1 = 0;
        int answer2 = 0;
        for(int right=0; right<sequence.length; right++) {
            sum += sequence[right];
            while(sum > k) {
                sum -= sequence[left];
                left++;
            }
            if(sum == k) {
                if(size > right - left) {
                    size = right-left;
                    answer1 = left;
                    answer2 = right;
                }
                else if(size == right-left) {
                    answer1 = Math.min(answer1, left);
                    answer2 = Math.min(answer2, right);
                }
            }
        }
        return new int[]{answer1, answer2};
    }
}