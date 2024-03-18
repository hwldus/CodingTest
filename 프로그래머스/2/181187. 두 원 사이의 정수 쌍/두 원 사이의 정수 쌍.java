class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        for(int i=1; i<=r2; i++) {
            int start = (int) Math.ceil(Math.sqrt((long)r1*r1 - (long)i*i)); //올림(내접 변 길이)
            int end = (int) Math.floor(Math.sqrt((long)r2*r2 - (long)i*i)); //내림(외접 변 길이)
            answer += end-start+1; //start~end 정수 쌍 개수
        }
        return answer*4;
    }
}