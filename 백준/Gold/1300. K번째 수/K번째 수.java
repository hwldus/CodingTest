import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        long low = 1;
        long high = k;
        while(low < high) {
            long mid = (low + high) / 2;
            long count = 0;
            for(int i=1; i<=n; i++)
                count += Math.min(mid/i, n); // 단 별 mid보다 작거나 같은 수의 개수(몫의 합) + n을 초과할 수 없음
            if(k <= count) //k가 더 작다는 것은 범위가 너무 커서 그런 것이므로 high 낮추기
                high = mid;
            else
                low = mid + 1; //low 높이기
        }
        System.out.println(low);
    }
}