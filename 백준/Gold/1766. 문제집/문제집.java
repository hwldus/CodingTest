import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] numArrayList = new ArrayList[n+1]; //먼저 풀어야 하는 문제
        int[] inDegree = new int[n+1]; //1부터 시작 (일반적인 난이도)

        for(int i=1; i<=n; i++)
            numArrayList[i] = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            numArrayList[n1].add(n2);
            inDegree[n2]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0)
                pq.offer(i);
        }
        while(!pq.isEmpty()) {
            int current = pq.poll();
            sb.append(current).append(" ");
            for(int next : numArrayList[current]) {
                inDegree[next]--;
                if(inDegree[next]==0)
                    pq.offer(next);
            }
        }
        System.out.println(sb);
    }
}