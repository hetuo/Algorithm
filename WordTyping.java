class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int n = sentence.length;
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0, len = 0, prev = 0; i < n; i++){
            if (i > 0 && len > 0)
                len = len - (sentence[i - 1].length() + 1);
            while(len + sentence[prev % n].length() <= cols) 
                len += sentence[prev++ % n].length() + 1;
            dp[i] = prev;
        }
        for (int i = 0, k = 0; i < rows; i++){
            res += (dp[k] - k);
            k = dp[k] % n;
        }
        return res / n;
    }
}
