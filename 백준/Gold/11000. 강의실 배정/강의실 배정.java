import java.io.*;
import java.util.*;

class Lecture implements Comparable<Lecture>{
    int s, t;
    public Lecture(int s, int t) {
        this.s = s;
        this.t = t;
    }
    public int compareTo(Lecture c) {
        if(this.s == c.s)
            return this.t - c.t; //끝나는시간 오름차순
        return this.s - c.s; //시작시간 오름차순
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Lecture[] lectures = new Lecture[n];
        int s, t;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(s,t);
        }
        Arrays.sort(lectures);
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //끝나는 시간
        pq.add(lectures[0].t);
        for(int i=1; i<n; i++) {
            if(pq.peek()<=lectures[i].s) pq.poll();
            pq.add(lectures[i].t);
        }
        System.out.println(pq.size());
    }
}
