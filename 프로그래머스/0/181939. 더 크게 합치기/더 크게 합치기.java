class Solution {
    public int solution(int a, int b) {
        String r1 = String.valueOf(a) + String.valueOf(b);
        String r2 = String.valueOf(b) + String.valueOf(a);
        int ab = Integer.parseInt(r1);
        int ba = Integer.parseInt(r2);
        
        if(ab >= ba) return ab;
        else return ba;
    }
}