import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n];
        int[] result = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            seq[i] = Integer.parseInt(st.nextToken());
        result[0] = seq[0];
        int length = 1;
        for(int i=1; i<n; i++) {
            int key = seq[i];
            if(result[length-1] < key) {
                length++;
                result[length-1] = key;
            }
            else {
                int low = 0;
                int high = length;
                while(low < high) {
                    int mid = (low+high) >>> 1; //중간값 계산 /보다 빠름
                    if(result[mid] < key)
                        low = mid + 1;
                    else
                        high = mid;
                }
                result[low] = key;
            }
        }
        System.out.println(length);
    }
}
