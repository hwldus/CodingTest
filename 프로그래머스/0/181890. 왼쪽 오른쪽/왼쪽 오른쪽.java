class Solution {
    public String[] solution(String[] str_list) {
        String[] answer = {};
        for(int i=0; i<str_list.length; i++) {
            if(str_list[i].equals("l")) {
                answer = new String[i];
                for(int j=0; j<i; j++) {
                    answer[j] = str_list[j];
                }
                break;
            }
            if(str_list[i].equals("r")) {
                answer = new String[str_list.length-i-1];
                for(int j=0; j<str_list.length-i-1; j++) {
                    answer[j] = str_list[i+j+1];
                }
                break;
            }
        }
        return answer;
    }
}