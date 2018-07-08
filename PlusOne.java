class Solution {
    public int[] plusOne(int[] digits) {
        
        return backtracking(digits, digits.length - 1);
    }
    
    int[] backtracking(int[] digits, int index){
        if (digits[index] < 9){
            digits[index] += 1;
            return digits;
        }
        if (index == 0){
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }else {
            digits[index] = 0;
            return backtracking(digits, index - 1);
        }
    }
}
