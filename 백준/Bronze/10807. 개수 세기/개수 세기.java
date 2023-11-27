import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<arr.length; i++) {
            if(m == arr[i]) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}