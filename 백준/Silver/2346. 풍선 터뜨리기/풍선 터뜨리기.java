import java.io.*;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<int[]> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        sb.append("1 ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(st.nextToken());
        for(int i=1; i<n; i++)
            deque.offer(new int[] {(i+1), arr[i]});
        int next = arr[0];
        while(!deque.isEmpty()) {
            if(next>0) {
                for(int i=1; i<next; i++)
                    deque.offer(deque.poll());
                int[] newArr = deque.poll();
                next = newArr[1];
                sb.append(newArr[0]+" ");
            }
            else {
                for(int i=1; i<-next; i++)
                    deque.offerFirst(deque.pollLast());
                int[] newArr = deque.pollLast();
                next = newArr[1];
                sb.append(newArr[0]+" ");
            }
        }
        System.out.println(sb);
    }
}