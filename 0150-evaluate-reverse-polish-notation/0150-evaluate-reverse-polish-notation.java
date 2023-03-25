class Solution {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String t : tokens) {
            if (isDigit(t)) {
                stack.push(Integer.parseInt(t));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result = 0;
                switch (t) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                }
                stack.push(result);
            }
        }
        return stack.pop();
    }

    private static boolean isDigit(String t) {
        try {
            Integer.parseInt(t);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}