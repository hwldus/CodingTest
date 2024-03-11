import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<keymap.length; i++) {
            for(int j=0; j<keymap[i].length(); j++) {
                if(map.containsKey(keymap[i].charAt(j))) {
                    int count = map.get(keymap[i].charAt(j));
                    if(count > (j+1))
                        map.put(keymap[i].charAt(j), j+1);
                }
                else
                    map.put(keymap[i].charAt(j),j+1);
            }
        }
        for(int i=0; i<targets.length; i++) {
            int count = 0;
            for(int j=0; j<targets[i].length(); j++) {
                char x = targets[i].charAt(j);
                Integer min = map.get(x);
                if(min != null)
                    count += min;
                else {
                    count = -1;
                    break;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}