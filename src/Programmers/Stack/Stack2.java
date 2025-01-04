package Programmers.Stack;

import java.util.Stack;

public class Stack2 {
    public static String solution(int decimal) {
        Stack<Integer> stack = new Stack<>();
        while (decimal > 0) {
            int remainder = decimal % 2;
            stack.push(remainder);
            decimal /= 2;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
