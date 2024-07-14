import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int[] operator;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        operator = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        dfs(arr[0],1);
        System.out.println(max);
        System.out.println(min);
    }
    private static void dfs(int num, int index) {
        if(index == n) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }
        for(int i=0; i<4; i++) {
            if(operator[i] > 0) {
                operator[i]--;
                switch (i) {
                    case 0:
                        dfs(num+arr[index], index +1);
                        break;
                    case 1:
                        dfs(num-arr[index], index+1);
                        break;
                    case 2:
                        dfs(num*arr[index], index+1);
                        break;
                    case 3:
                        dfs(num/arr[index], index+1);
                        break;
                }
                operator[i]++;
            }
        }
    }
}