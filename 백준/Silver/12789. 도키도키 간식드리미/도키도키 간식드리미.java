import java.io.*;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(n-->0) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }
        int first = 1;
        while(!queue.isEmpty()) {
            if(queue.peek() == first) {
                queue.poll();
                first++;
            } else if(!stack.isEmpty() && stack.peek() == first) {
                stack.pop();
                first++;
            } else {
                stack.push(queue.poll());
            }
        }
        while(!stack.isEmpty()) {
            if(stack.peek() == first) {
                stack.pop();
                first++;
            } else {
                System.out.println("Sad");
                return;
            }
        }
        System.out.println("Nice");
    }
}