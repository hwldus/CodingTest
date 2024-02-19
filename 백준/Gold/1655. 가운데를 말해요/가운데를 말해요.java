import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //오름차순
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); //내림차순
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(maxHeap.size()==minHeap.size()) //최대최소 크기 비교, 조정
                maxHeap.offer(num);
            else
                minHeap.offer(num);

            if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek()>minHeap.peek()) { //최대 최소 비교
                int max = maxHeap.poll();
                int min = minHeap.poll();
                maxHeap.offer(min);
                minHeap.offer(max);
            }
            sb.append(maxHeap.peek()).append('\n');
        }
        System.out.println(sb);
    }
}