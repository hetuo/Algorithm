class Solution {
    
    int min = Integer.MAX_VALUE;
    
    public List<String> removeInvalidParentheses(String s) {
        List<String> r = new ArrayList<>();
        backtracking(r, s, 0, new HashSet<String>());
        return r;
    }
    
    private void backtracking(List<String> list, String s, int n, Set<String> set){
        if (n > min)
            return;
        if (isValid(s)){
            if (n < min){
                list.clear();
                list.add(s);
                min = n;
            }else if (n == min && !list.contains(s))
                list.add(s);
            return;
        }
        set.add(s);
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) != '(' && s.charAt(i) != ')')
                continue;
            String subs = s.substring(0, i) + s.substring(i + 1, s.length());
            if (set.contains(subs))
                continue;
            backtracking(list, subs, n + 1, set);
            //set.remove(subs);
        }
    }
    
    private boolean isValid(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          if (c == '(') count++;
          if (c == ')' && count-- == 0) return false;
        }
        return count == 0;
    }
}
