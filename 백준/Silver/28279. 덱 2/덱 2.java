import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(n-->0) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if(num==1) {
                int i = Integer.parseInt(st.nextToken());
                deque.offerFirst(i);
            } else if(num==2) {
                int i = Integer.parseInt(st.nextToken());
                deque.offerLast(i);
            } else if(num==3) {
                if(!deque.isEmpty()) sb.append(deque.pollFirst() + "\n");
                else sb.append(-1 + "\n");
            } else if(num==4) {
                if(!deque.isEmpty()) sb.append(deque.pollLast() + "\n");
                else sb.append(-1 + "\n");
            } else if(num==5) {
                sb.append(deque.size() + "\n");
            } else if(num==6) {
                if(deque.isEmpty()) sb.append(1 + "\n");
                else sb.append(0 + "\n");
            } else if(num==7) {
                if(!deque.isEmpty()) sb.append(deque.peekFirst() + "\n");
                else sb.append(-1 + "\n");
            } else if(num==8) {
                if(!deque.isEmpty()) sb.append(deque.peekLast() + "\n");
                else sb.append(-1 + "\n");
            }
        }
        System.out.println(sb);
    }
}