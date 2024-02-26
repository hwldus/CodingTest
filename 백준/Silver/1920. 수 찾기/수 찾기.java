import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(a);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(binarySearch(a, x))
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    private static boolean binarySearch(int[] arr, int x) {
        int left = 0;
        int right = arr.length-1;
        while(left<=right) {
            int mid = (left+right) / 2;
            if(arr[mid] == x) return true;
            else if(arr[mid] < x)
                left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}