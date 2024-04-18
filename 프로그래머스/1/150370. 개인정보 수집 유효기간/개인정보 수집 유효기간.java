import java.time.LocalDate;
import java.util.HashMap;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        int[] result = new int[privacies.length];
        int count = 0;
        HashMap<String, Integer> term = new HashMap<>();
        for(int i=0; i<terms.length; i++) {
            String[] temp = terms[i].split(" ");
            term.put(temp[0], Integer.valueOf(temp[1]));
        }
        String[] t = today.split("\\.");
        int[] now = new int[3];
        for(int i=0; i<3; i++)
            now[i] = Integer.valueOf(t[i]);
        LocalDate date = LocalDate.of(now[0], now[1], now[2]);
        for(int i=0; i<privacies.length; i++) {
            String[] tmp = privacies[i].split(" ");
            String day = tmp[0];
            String name = tmp[1];
            int during = term.get(name);
            
            String[] s = day.split("\\.");
            int[] signs = new int[3];
            for(int j=0; j<3; j++) 
                signs[j] = Integer.valueOf(s[j]);
            LocalDate signday = LocalDate.of(signs[0],signs[1],signs[2]);
            LocalDate expire = signday.plusMonths(during).minusDays(1);
            if(date.isAfter(expire)) {
                result [count]=i+1;
                count++;
            }
        }
        answer = new int[count];
        for(int i=0; i<count; i++)
            answer[i] = result[i];
        
        return answer;
    }
}