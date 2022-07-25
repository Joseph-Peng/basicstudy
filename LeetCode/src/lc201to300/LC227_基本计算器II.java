package lc201to300;

import java.util.Stack;

public class LC227_基本计算器II {

    public int calculate(String s) {
        s = s + "+0";
        char preOperation = '+';
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                num = num * 10 + (c-'0');
            } else {
                switch (preOperation) {
                    case '+': stack.push(num); break;
                    case '-': stack.push(-1 * num); break;
                    case '*': stack.push(stack.pop() * num); break;
                    case '/': stack.push(stack.pop() / num); break;
                    default:
                }
                preOperation = c;
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }
}
