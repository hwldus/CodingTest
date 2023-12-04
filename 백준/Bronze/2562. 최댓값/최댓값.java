import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[9];
        int max = arr[0];
        int index=0;
        for(int i=0;i<arr.length;i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] > max) {
                max = arr[i];
                index = i+1;
            }
        }
        sb.append(max+"\n"+index);
        System.out.println(sb);
    }
}
