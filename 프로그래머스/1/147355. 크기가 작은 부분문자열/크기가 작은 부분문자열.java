class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        for(int i=0; i<t.length()-len+1; i++) {
            String s = t.substring(i,i+p.length());
            if(Long.parseLong(s) <= Long.parseLong(p))
                answer++;
        }
        return answer;
    }
}