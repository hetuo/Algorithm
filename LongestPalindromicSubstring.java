class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        
        boolean[][] dp = new boolean[n][n];
        for (int start = n - 1; start >= 0; start--)
            for (int end = start; end < n; end++){
                dp[start][end] = s.charAt(start) == s.charAt(end) && (end - 1 < start + 1 || dp[start + 1][end - 1]);
                if (dp[start][end] && end - start + 1 > res.length())
                    res = s.substring(start, end + 1);
            }
        return res;
    }
}
