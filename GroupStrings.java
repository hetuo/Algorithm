class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<Integer, List<String>> map = new HashMap<>();
        for (String str : strings){
            if (!map.containsKey(str.length()))
                map.put(str.length(), new ArrayList<String>());
            map.get(str.length()).add(str);
        }
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()){
            if (entry.getKey() == 1)
                result.add(entry.getValue());
            else
                group(entry.getValue(), result);
        }
        return result;
    }
    
    private void group(List<String> list, List<List<String>> result){
        char[] array = new char[list.get(0).length() - 1];
        Map<String, List<String>> map = new HashMap<>();
        for (String str : list){
            for (int i = 1; i < str.length(); i++){
                if (str.charAt(i) - str.charAt(i - 1) < 0)
                    array[i - 1] = (char)(str.charAt(i) - str.charAt(i - 1) + 26 + 'a');
                else
                    array[i - 1] = (char)(str.charAt(i) - str.charAt(i - 1) + 'a');
            }
            String key = Arrays.toString(array);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<String>());
            map.get(key).add(str);
        }
        for (List<String> value : map.values())
            result.add(value);
    }
}
