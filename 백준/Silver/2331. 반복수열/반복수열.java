import java.io.*;
import java.util.*;

public class Main {
    static int A,P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        List<Integer> arr = new ArrayList<>();
        Map<Integer, Integer> hash = new HashMap<>();
        while(!hash.containsKey(A)) {
            hash.put(A, arr.size());
            arr.add(A);
            A = getNext(A);
        }
        System.out.println(hash.get(A));
    }
    private static int getNext(int num) {
        int result = 0;
        while(num != 0) {
            int x = num%10;
            num /= 10;
            result += Math.pow(x,P);
        }
        return result;
    }
}