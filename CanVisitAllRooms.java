class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        
        dfs(rooms, set, 0);
        return set.size() == rooms.size();
    }
    
    private void dfs(List<List<Integer>> rooms, Set<Integer> set, int r){
        set.add(r);
        for (int i : rooms.get(r)){
            if (!set.contains(i))
                dfs(rooms, set, i);
        }
    }
}
