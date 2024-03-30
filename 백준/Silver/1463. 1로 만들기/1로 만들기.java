import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int[] dp = new int[x+1];
        for(int i=2; i<=x; i++) {
            dp[i] = dp[i-1] + 1; // 1빼기
            if(i%2==0)
                dp[i] = Math.min(dp[i], dp[i/2]+1); //2나누기
            if(i%3==0)                
                dp[i] = Math.min(dp[i], dp[i/3]+1); //3나누기
        }
        System.out.println(dp[x]);
    }
}