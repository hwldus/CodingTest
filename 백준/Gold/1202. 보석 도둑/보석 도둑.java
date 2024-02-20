import java.io.*;
import java.util.*;

class Jewel implements Comparable<Jewel> {
    int weight, price;
    public Jewel(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }
    @Override
    public int compareTo(Jewel j) {
        return this.weight - j.weight; // 음수: this, 양수: j 리턴 => 오름차순(보석무게)
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //보석
        int k = Integer.parseInt(st.nextToken()); //가방

        ArrayList<Jewel> jewels = new ArrayList<>(); //보석
        int[] bag = new int[k]; //가방 개수

        for(int i=0; i<n; i++) { //보석 정보를 리스트에 삽입
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(weight, price)); // 보석(무게, 가격)단위로 array에 삽입
        }
        for(int i=0; i<k; i++)
            bag[i] = Integer.parseInt(br.readLine());

        Arrays.sort(bag); // 가방 무게 오름차순
        Collections.sort(jewels); // 보석 무게 오름차순

        long result=0;
        int j=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<k; i++) {
            while(true) {
                if(j>=n) break;
                Jewel x = jewels.get(j);
                if(bag[i] < jewels.get(j).weight) break; //보석 무게<가방무게 => 최소힙저장
                pq.add(x.price);
                j++; //보석 탐색 수
            }
            if(!pq.isEmpty())
                result += pq.poll(); // 최소 힙 맨 앞에 있는 숫자(가장 비싼 보석)
        }
        System.out.println(result);
    }
}