import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for(int i=0; i<n; i++)
            words[i] = br.readLine();

        //Comparator
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() != s2.length())
                    return s1.length() - s2.length(); //길이 짧은 순
                else
                    return s1.compareTo(s2); //사전순
            }
        });
        
        for(int i=0; i<n; i++) {
            if(i>0 && words[i].equals(words[i-1]))
                continue;
            sb.append(words[i]).append('\n');
        }
        System.out.println(sb);
    }
}