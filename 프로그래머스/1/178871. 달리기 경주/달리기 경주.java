import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();
        for(int i=0; i<players.length; i++) 
            rank.put(players[i],i);
        
        for(String player : callings) {
            int playerRank = rank.get(player); //선수의 현재 순위
            String front = players[playerRank-1]; //앞 선수 이름
            
            rank.replace(front, playerRank);//앞 선수의 위치 변경
            players[playerRank] = front;
            
            rank.replace(player, playerRank-1) ; //현재 선수의 순위를 앞으로 변경
            players[playerRank-1] = player;
        }
        return players;
    }
}