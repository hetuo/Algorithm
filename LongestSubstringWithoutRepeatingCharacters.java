class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int[] map = new int[256];
        int start = 0, end = 0, max = 1;
        while(end < s.length()){
            if (map[s.charAt(end)] == 0){
                map[s.charAt(end)] += 1;
                end += 1;
            } else {
                // System.out.println(start + ":" + end);
                map[s.charAt(end)] += 1;
                if (end - start > max)
                    max = end - start;
                while (map[s.charAt(end)] > 1){
                    map[s.charAt(start)] -= 1;
                    start += 1;
                }
                end += 1;
            }
        }
        return max > end - start ? max : end - start;
    }
}
