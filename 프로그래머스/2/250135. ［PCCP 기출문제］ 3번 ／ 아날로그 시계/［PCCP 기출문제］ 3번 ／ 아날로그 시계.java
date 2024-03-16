class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        int bonus=0;
        if(h1*3600 + m1*60 + s1==0 || h1*3600 + m1*60 + s1==43200) //오전 12시 or 오후 12시
            bonus = 1;
        return getCount(h2,m2,s2) - getCount(h1,m1,s1) + bonus;
    }
    
    public int getCount(int h1, int m1, int s1) {
        int total = h1*3600 + m1*60 + s1; //전부 초로 변환
        int m_alram = (total*59)/3600; //분침과 초침간 알람(초침이 먼저 움직이기 때문에 마지막 한번은 필요없음 그래서 59번)
        int h_alram = (total*719)/43200; //시침과 초침간 알람(분침과 마찬가지로 마지막 한번은 필요없음)
        int count = m_alram + h_alram;
        if(h1>=12) { //알람을 24시간 기준이 아닌 12시간 기준으로 했기 때문에 한번 중복(세 침 동시에)이 생기므로 1빼줘야함
            count--;
        }
        return count;
    }
}