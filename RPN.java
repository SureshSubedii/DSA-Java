class RPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.matches("-?\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {
                int firstValue = stack.pop();
                int secondValue = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(secondValue + firstValue);
                        break;
                    case "-":
                        stack.push(secondValue - firstValue);
                        break;
                    case "*":
                        stack.push(secondValue * firstValue);
                        break;
                    case "/":
                        stack.push(secondValue / firstValue);
                        break;
                }
            }

        }
        return stack.pop();

    }
}
