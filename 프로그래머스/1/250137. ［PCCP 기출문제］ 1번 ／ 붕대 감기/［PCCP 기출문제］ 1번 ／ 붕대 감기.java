class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0]; //시간
        int x = bandage[1]; //1초당 체력 회복량
        int y = bandage[2]; // 추가 회복량
        int life = health; //최대 체력
        int count = 0; //연속성공 횟수
        int attackIndex = 0; //인덱스(몬스터가 공격하는 시간)
        for(int i=1; i<=attacks[attacks.length-1][0]; i++) {
            if(i != attacks[attackIndex][0]) { //몬스터가 공격하지 않을 때
                life += x;
                count++;
                if(count == t) {
                    life += y;
                    count = 0;
                }
                if(life>health) 
                    life = health;
            }
            else {
                count = 0;
                life -= attacks[attackIndex][1];
                attackIndex++;
                if(life<=0)
                    return -1;
            }
        }
        return life;
    }
}