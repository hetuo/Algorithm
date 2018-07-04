class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A == null || A.length() < 2 || B == null || B.length() < 2 || A.length() != B.length())
            return false;
        if (A.equals(B)){
            int array[] = new int[26];
            for (int i = 0; i < A.length(); i++){
                if (array[A.charAt(i) - 'a'] > 0)
                    return true;
                array[A.charAt(i) - 'a']++;
            }
            return false;
        } else{
            int first = -1, second = -1;
            for (int i = 0; i < A.length(); i++)
                if (A.charAt(i) != B.charAt(i)){
                    if (first == -1)
                        first = i;
                    else if (second == -1)
                        second = i;
                    else
                        return false;
                }
            if (first == -1 || second == -1)
                return false;
            if (A.charAt(first) == B.charAt(second) && A.charAt(second) == B.charAt(first))
                return true;
        }
        return false;
    }
}
