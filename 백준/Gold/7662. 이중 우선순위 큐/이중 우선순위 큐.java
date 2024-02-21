import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            while(k-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char flag = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if(flag == 'I') map.put(num, map.getOrDefault(num, 0)+1);
                else if (flag == 'D') {
                    if(!map.isEmpty()) {
                        if(num==1) { //최댓값 삭제
                            int maxKey = map.lastKey();
                            if(map.get(maxKey)==1) map.remove(maxKey);
                            else map.put(maxKey, map.get(maxKey)-1);
                        }
                        else if(num==-1) { //최솟값 삭제
                            int minKey = map.firstKey();
                            if(map.get(minKey)==1) map.remove(minKey);
                            else map.put(minKey, map.get(minKey)-1);
                        }
                    }
                }
            }
            if(map.isEmpty()) sb.append("EMPTY\n");
            else sb.append(map.lastKey() + " " + map.firstKey() + "\n");
        }
        System.out.println(sb);
    }
}
