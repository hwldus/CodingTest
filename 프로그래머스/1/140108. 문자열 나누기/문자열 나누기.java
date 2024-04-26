class Solution {
    public int solution(String s) {
        int answer = 0;
        char x = s.charAt(0);
        int xCount = 0;
        int diff = 0;
        for(int i=0; i<s.length(); i++) {
            if(xCount == diff) {
                answer++;
                x = s.charAt(i);
            }
            if(x == s.charAt(i))
                xCount++;
            else 
                diff++;
        }
        return answer;
    }
}