import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        String s;
        while (true) {
            s = bufferedReader.readLine();
            if (s.equals("."))
                break;
            stringBuilder.append(judge(s)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    public static String judge(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[')
                stack.push(c);
            else if(c == ')') {
                if(stack.empty() || stack.peek() != '(')
                    return "no";
                else
                    stack.pop();
            }
            else if(c == ']') {
                if(stack.empty() || stack.peek() != '[')
                    return "no";
                else
                    stack.pop();
            }
        }
        if (stack.empty())
            return "yes";
        else
            return "no";
    }
}