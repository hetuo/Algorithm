class Solution {
    public boolean isIsomorphic(String s, String t) {  
        int [] lastS = new int[256];
        int [] lastT = new int[256];
        for (int i = 0; i < s.length(); i++){
            char sc = s.charAt(i), tc = t.charAt(i);
            if (lastS[sc] != lastT[tc]){
                return false;
            }
            lastS[sc] = i + 1;
            lastT[tc] = i + 1;
        }
        return true;
        
        
/*        char start = ' ';
        Map<Character, Character> map = new HashMap<>();
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        for (int i = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                sArray[i] = map.get(s.charAt(i));
                continue;
            }
            map.put(s.charAt(i), start);
            sArray[i] = start;
            start = (char)(start + 1);
        }
        map.clear();
        start = ' ';
        for (int i = 0; i < t.length(); i++){
            if (map.containsKey(t.charAt(i))){
                tArray[i] = map.get(t.charAt(i));
                continue;
            }
            map.put(t.charAt(i), start);
            tArray[i] = start;
            start = (char)(start + 1);
        }
        
       // System.out.println(Arrays.toString(sArray));
       // System.out.println(Arrays.toString(tArray));
        s = new String(sArray);
        t = new String(tArray);
        return s.equals(t); */
    }
}
