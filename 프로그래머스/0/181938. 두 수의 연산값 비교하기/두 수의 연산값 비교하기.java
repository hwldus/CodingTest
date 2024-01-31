class Solution {
    public int solution(int a, int b) {
        int r1 = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int r2 = 2*a*b;
        if(r1 >= r2) return r1;
        else return r2;
        
    }
}