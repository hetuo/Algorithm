class Solution {
    

    
    public int numBusesToDestination(int[][] routes, int S, int T) {   
        if (S == T)
            return 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> startRoute = new ArrayList<>();
        List<Set<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i < routes.length; i++){
            Set<Integer> set = new HashSet<>();
            for (int r : routes[i])
                set.add(r);
            list.add(set);
            if (set.contains(S))
                startRoute.add(i);
            if (!graph.containsKey(i))
                graph.put(i, new ArrayList<Integer>());
            for (int j = i + 1; j < routes.length; j++){
                for (int r : routes[j])
                    if (set.contains(r)){
                        graph.get(i).add(j);
                        if (!graph.containsKey(j))
                            graph.put(j, new ArrayList<Integer>());
                        graph.get(j).add(i);
                        break;
                    }
            }
        }    
        int min = Integer.MAX_VALUE;
        boolean found = false;
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> visited = new HashSet<>();        
        for (int start : startRoute){
            queue.offer(start);
            visited.add(start);
            int count = 1;
            if (list.get(start).contains(T))
                return count;          
            while (!queue.isEmpty()){
                int size = queue.size();
                while (size > 0){
                    int bus = queue.poll();
                    List<Integer> connected = graph.get(bus);
                    
                    for (int i : connected){
                        if (!visited.contains(i)){
                            if (list.get(i).contains(T))
                            {
                                count += 1;
                                found = true;
                                break;
                            }
                            visited.add(i);
                            queue.add(i);
                        }
                    }
                    size--;
                    if (found)
                        break;
                }
                if (found)
                    break;
                count += 1;
            }
            if (found)
                min = Math.min(count, min);
            queue.clear();
            visited.clear();
            found = false;
        }
        if (min == Integer.MAX_VALUE)
            return -1;
        return min;        
    }
    
}
