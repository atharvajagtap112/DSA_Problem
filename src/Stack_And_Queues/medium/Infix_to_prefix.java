package Stack_And_Queues.medium;

import java.util.Stack;

public class Infix_to_prefix {
    static String reverse(String str) {
        String ans = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            ans += str.charAt(i);
        }
        return ans;
    }

    // Function to convert prefix expression to infix
    static String preToInfix(String pre_exp) {
        String str = reverse(pre_exp);
        String newString = "";  // Corrected missing semicolon

        // Convert '(' to ')' and vice versa in the reversed string
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                newString += '(';
            } else if (str.charAt(i) == '(') {
                newString += ')';
            } else {
                newString += str.charAt(i);
            }
        }

        String result = "";

        // Initialize an empty stack
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < newString.length(); ++i) {
            char c = newString.charAt(i);

            // If the scanned character is an operand, add it to output
            if (Character.isLetterOrDigit(c)) {
                result += c;
            }
            // If the scanned character is '(', push it to the stack
            else if (c == '(') {
                stack.push(c);
            }
            // If the scanned character is ')', pop and output from the stack until '(' is encountered
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                if(c=='^'){
                    while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
                        result += stack.pop();
                    }
                }
                else{
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
                    result += stack.pop();
                }}
                stack.push(c);
            }
        }

        // Pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression";
            }
            result += stack.pop();
        }

        return reverse(result);
    }

    // Function to return precedence of operators
    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

}
