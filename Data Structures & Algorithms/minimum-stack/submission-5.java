class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public MinStack() {
    }
    
    public void push(int val) {
        stack.push(val);
        int currentMin;
        if(minStack.isEmpty()){
            currentMin = val;
        } else{
            currentMin = minStack.peek();
        }
        minStack.push(Math.min(val,currentMin));
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
