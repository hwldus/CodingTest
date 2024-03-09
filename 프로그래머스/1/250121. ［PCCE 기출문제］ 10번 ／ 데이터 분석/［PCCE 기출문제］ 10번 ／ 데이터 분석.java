import java.util.*;

class Solution {
    public ArrayList<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        ArrayList<int[]> list = new ArrayList<>();
        String[] str = {"code", "date", "maximum", "remain"};
        int extIndex=0, sortIndex=0;
        for(int i=0; i<4; i++) {
            if(ext.equals(str[i])) 
                extIndex = i;
            if(sort_by.equals(str[i])) 
                sortIndex = i;
        }
        for(int i=0; i<data.length; i++) {
            if(data[i][extIndex] < val_ext)
                list.add(data[i]);
        }
        final int sIndex = sortIndex;
        Collections.sort(list, ((o1, o2) -> o1[sIndex] - o2[sIndex]));
        return list;
    }
}