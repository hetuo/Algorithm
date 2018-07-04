class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        char[] sa = S.toCharArray();
        for (char c : sa){
            if (stack.isEmpty() || c == '(')
                stack.push(-1);         
            else if (stack.peek() != -1){
                int num = 2 * stack.pop();
                stack.pop();
                if (!stack.empty() && stack.peek() != -1)
                    num += stack.pop();
                stack.push(num);
                
            } else {
                stack.pop();
                if (!stack.empty() && stack.peek() != -1)
                    stack.push(stack.pop() + 1);
                else
                    stack.push(1);
            }
        }
        return stack.pop();
    }
}
