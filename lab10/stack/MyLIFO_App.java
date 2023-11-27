package lab10.stack;

import java.util.Stack;

public class MyLIFO_App {
    public static <E> void reserve(E[] array) {
        Stack<E> stack = new Stack<>();
        for(E e : array) {
            stack.push(e);
        }
        for(int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
    }
     // This method checks the correctness of the
    //given input
    // i.e. ()(())[]{(())} ==> true, ){[]}() ==>
    //false
    public static boolean isCorrect(String input) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    // This method evaluates the value of an
    // expression
    // i.e. 51 + (54 *(3+2)) = 321
    public static void processAnOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        int op1 = operandStack.pop();
        int op2 = operandStack.pop();
        if (op == '+') {
            operandStack.push(op2 + op1);
        }
        else if (op == '-') {
            operandStack.push(op2 - op1);
        }
        else if (op == '*') {
            operandStack.push(op2 * op1);
        }
        else if (op == '/') {
            operandStack.push(op2 / op1);
        }
    }
    public static String insertBlanks(String s) {
        String result = "";
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')' ||
                s.charAt(i) == '+' || s.charAt(i) == '-' ||
                s.charAt(i) == '*' || s.charAt(i) == '/') {
                result += " " + s.charAt(i) + " ";
            }
            else {
                result += s.charAt(i);
            }
        }
        return result;
    }
    public static int evaluateExpression(String expression) {
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        expression = insertBlanks(expression);
        String[] tokens = expression.split(" ");
        for(String token : tokens) {
            if (token.length() == 0) {
                continue;
            }
            else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                while(!operatorStack.isEmpty() && 
                    (operatorStack.peek() == '+' ||
                    operatorStack.peek() == '-' ||
                    operatorStack.peek() == '*' ||
                    operatorStack.peek() == '/')) {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));
            }
            else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
                while(!operatorStack.isEmpty() && 
                    (operatorStack.peek() == '*' ||
                    operatorStack.peek() == '/')) {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));
            }
            else if (token.trim().charAt(0) == '(') {
                operatorStack.push('(');
            }
            else if (token.trim().charAt(0) == ')') {
                while(operatorStack.peek() != '(') {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.pop();
            }
            else {
                operandStack.push(new Integer(token));
            }
        }
        while(!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack);
        }
        return operandStack.pop();

    }
}
