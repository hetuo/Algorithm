class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length())
            return "";
        int[] map = new int[256]; 
        for (char c : t.toCharArray())
            map[c]++;
        int counter = t.length(), start = 0, end = 0, len = Integer.MAX_VALUE, head = 0;
        while (end < s.length()){
            if (map[s.charAt(end++)]-- > 0) 
                counter--;
            while (counter == 0){
                if (end - start < len){
                    len = end - start;
                    head = start;
                }
                if (map[s.charAt(start++)]++ == 0)
                    counter++;
            }
                
        }
        // System.out.println(head + " " + len);
        return len == Integer.MAX_VALUE ? "" : s.substring(head, head + len);
    }
}
