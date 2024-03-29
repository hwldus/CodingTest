import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        while(n>0) {
            if(n%5 == 0) {
                count += n/5;
                System.out.println(count);
                return;
            }
            else if(n<3) {
                System.out.println(-1);
                return;
            }
            else {
                n -= 3;
                count++;
            }
        }
        System.out.println(count);
    }
}