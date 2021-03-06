/*
* 有效的括号
* */
package mianshizhinan.zifuchuan;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class zf5 {

    public static void main(String[] args) {
        String s = "{()}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();        // 右括号遇到匹配的左括号出栈
            } else {
                stack.push(ch);     // 左括号依次进栈
            }
        }
        return stack.isEmpty();
    }
}
