import java.util.*;

public class Infix {
    public static void main(String[] args) {
        String infixExpression = "(a+b)*c+d/e^f-(g*h)";
        Map<String, Integer> variables = new HashMap<>();
        variables.put("a", 2);
        variables.put("b", 3);
        variables.put("c", 5);
        variables.put("d", 64);
        variables.put("e", 2);
        variables.put("f", 3);
        variables.put("g", 5);
        variables.put("h", 9);

        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);

        int result = evaluatePostfix(postfixExpression, variables);
        System.out.println("Result: " + result);
    }

    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        Map<Character, Integer> precedence = new HashMap<>();
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('^', 3);

        for (char c : infix.toCharArray()) {
            if (Character.isLetter(c)) {
                postfix.append(c);
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.pop(); // Pop and discard '('
            } else {
                while (!operatorStack.isEmpty() && precedence.get(c) <= precedence.getOrDefault(operatorStack.peek(), 0)) {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.push(c);
            }
        }

        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop());
        }

        return postfix.toString();
    }

    public static int evaluatePostfix(String postfix, Map<String, Integer> variables) {
        Stack<Integer> operandStack = new Stack<>();

        for (char c : postfix.toCharArray()) {
            if (Character.isLetter(c)) {
                int value = variables.get(String.valueOf(c));
                operandStack.push(value);
            } else {
                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();
                int result = performOperation(operand1, operand2, c);
                operandStack.push(result);
            }
        }

        return operandStack.pop();
    }

    public static int performOperation(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            case '^':
                return (int) Math.pow(operand1, operand2);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
