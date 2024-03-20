import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Stack<String[]> stop = new Stack<>();
        Arrays.sort(plans,(a,b)->toSec(a[1])-toSec(b[1])); //오름차순 정렬
        int size = plans.length;
        int x = 0;
        int index = 0;
        int total = 0; //끝나는 시간(시작+진행)
        String subject = ""; //과목
        int time = 0; //시작 시각
        int period = 0; //진행 시간
        int next = 0;

        while(size != index) {
            subject = plans[index][0];
            time = toSec(plans[index][1]);
            period = Integer.parseInt(plans[index][2]);
            total = time+period;
            if(size-1 != index) {
                next = toSec(plans[index+1][1]);
                if(total > next) {
                    stop.push(new String[]{subject,total-next+""});
                    total = next;
                    index++;
                    continue;
                }
            }
            answer[x++] = subject; //과제완료
            while(!stop.isEmpty()) {
                int remain = next - total;
                String[] study = stop.pop();
                int re_p = Integer.parseInt(study[1]);
                if(remain>=re_p) {
                    answer[x++] = study[0];
                    total += re_p;
                }
                else {
                    stop.push(new String[]{study[0], re_p-remain+""});
                    break;
                }
            }
            index++;
        }
        while(!stop.isEmpty())
            answer[x++] = stop.pop()[0];

        return answer;
    }
    public int toSec(String time) {
        String[] t = time.split(":");
        int h = Integer.parseInt(t[0])*60;
        int m = Integer.parseInt(t[1]);
        return h+m;
    }
}