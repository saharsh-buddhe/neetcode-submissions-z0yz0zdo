class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < tokens.length; i++) {
           String token = tokens[i];
           int result = 0;

           if(token.equals("+") || token.equals("-") ||token.equals("/") ||token.equals("*")){
           
            int b = stack.pop();
           int a = stack.pop();
            if(token.equals("+")){
                result = a + b;
            }
             else if(token.equals("*")){
                result = a * b;
            }
            else if(token.equals("-")){
                result = a - b;
            }
            else if(token.equals("/")){
                result = a / b;
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
