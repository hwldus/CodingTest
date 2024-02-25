import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> time = new ArrayList<>();
        for(int i=0; i<n; i++)
            time.add(Integer.parseInt(st.nextToken()));
        Collections.sort(time);
        int sum=0;
        int x=0;
        for(int i=0; i<n; i++) {
            x += time.get(i);
            sum += x;
        }
        System.out.println(sum);
    }
}