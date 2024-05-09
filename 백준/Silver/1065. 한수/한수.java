import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int sum = 99;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n<100)
            System.out.println(n);
        else {
            for (int i = 100; i <= n; i++) {
                int x = i % 10; //일
                int y = (i / 10) % 10;//십
                int z = i / 100; //백
                if(x-y == y-z)
                    sum++;
            }
            System.out.println(sum);
        }
    }
}