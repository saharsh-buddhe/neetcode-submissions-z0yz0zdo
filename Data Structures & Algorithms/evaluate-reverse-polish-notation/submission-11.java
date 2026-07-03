class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < tokens.length ; i++){
            String token = tokens[i];
            if(token.equals("+") || token.equals("-") ||token.equals("/") ||token.equals("*")) {
                int result = 0;
                int a = stack.pop();
                int b = stack.pop();

                if(token.equals("+")){
                    result = a + b;
                } else if(token.equals("-")){
                    result = b - a;
                } else if(token.equals("*")){
                    result = a * b;
                } else if(token.equals("/")){
                    result = b / a;
                }
                stack.push(result);
            } else{
                int number = Integer.parseInt(token);
                stack.push(number);
            }
        }

        return stack.pop();
    }
}
