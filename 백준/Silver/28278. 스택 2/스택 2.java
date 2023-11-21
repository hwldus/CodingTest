import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(n-->0){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if(num == 1) {
                int i = Integer.parseInt(st.nextToken());
                stack.push(i);
            } else if(num == 2) {
                if(!stack.isEmpty()) sb.append(stack.pop() + "\n");
                else sb.append(-1 + "\n");
            } else if(num == 3) {
                sb.append(stack.size() + "\n");
            }else if(num == 4) {
                if(stack.isEmpty()) sb.append(1 + "\n");
                else sb.append(0 + "\n");
            } else if(num == 5) {
                if(!stack.isEmpty()) sb.append(stack.peek() + "\n");
                else sb.append(-1 + "\n");
            }
        }
        System.out.println(sb);
    }
}