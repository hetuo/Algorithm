class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0)
            return res;
        Stack<Integer> stack = new Stack<>();
        boolean b = backtrack(S.toCharArray(), 0, 1, stack);
        if (!b)
            return res;
        Stack<Integer> tempStack = new Stack<>();
        while(!stack.empty()) {
            tempStack.push(stack.pop());
        }
        while(!tempStack.empty()) {
            res.add(tempStack.pop());
        }
        return res;
    }
    
    private boolean backtrack(char[] array, int index, int len, Stack<Integer> stack) {
        if (index >= array.length) 
            return stack.size() >= 3 ? true : false;
        for (; len <= array.length - index; len++) {
            if (array[index] == '0' && len > 1)
                break;
            int num = 0, i = 0;
            while (i < len){
                num += (array[index + i] - '0') * Math.pow(10, len - i - 1);
                i++;
            }
            // System.out.println(num);
            if (stack.size() >= 2) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second);
                stack.push(first);
                if (num == first + second) {
                    stack.push(num);
                    boolean res = backtrack(array, index + len, len, stack);
                    if (res)
                        return true;
                    stack.pop();
                } else if (num > first + second)
                    return false;
            } else {
                stack.push(num);
                boolean res = backtrack(array, index + len, len, stack);
                if (res)
                    return true;
                stack.pop();
            }
        }
        return false;
    }
}
