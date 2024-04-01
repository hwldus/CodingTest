import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        long[] dp = new long[41];
        dp[1] = 1;
        for(int i=2; i<=40; i++)
            dp[i] = dp[i-2] + dp[i-1];
        for(int i=0; i<t; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x==0) {
                sb.append("1 0\n");
                continue;
            }
            sb.append(dp[x-1]+" "+dp[x]+"\n");
        }
        System.out.println(sb);
    }
}