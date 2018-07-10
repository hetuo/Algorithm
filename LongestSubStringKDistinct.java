class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] map = new int[256];
        char[] sArray = s.toCharArray();
        int start = 0;
        int count = 0;
        int res = 0;
        for (int i = 0; i < sArray.length; i++){
            if (map[sArray[i]] == 0)
                count += 1;
            map[sArray[i]] += 1;
            if (count > k){
                while (--map[sArray[start]] > 0){
                    start++;
                }
                start++;
                count--;
            }
            // System.out.println(i + ":" + start);
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}
