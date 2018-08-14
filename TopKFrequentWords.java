class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> entryA, Map.Entry<String, Integer> entryB){
                if (entryA.getValue() == entryB.getValue()){
                    return entryA.getKey().compareTo(entryB.getKey());
                }
                return entryB.getValue() - entryA.getValue();
            }
        });
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            heap.add(entry);
        }
        for (int i = 0; i < k && heap.size() > 0; i++)
            result.add(heap.poll().getKey());
        return result;
    }
}
