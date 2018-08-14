class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        List<String> uncommon = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        String[] array = (A + " " + B).split(" ");
        for (String word : array){
            if (word.length() > 0)
                map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet())
            if (entry.getValue() == 1)
                uncommon.add(entry.getKey());
        if (uncommon.size() == 0)
            return new String[0];
        String[] res = new String[uncommon.size()];
        res = uncommon.toArray(res);
        return res;
    }
}
