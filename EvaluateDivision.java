class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if (values == null || values.length == 0)
            return new double[0];
        double[] result = new double[queries.length];
        Map<String, String> parents = new HashMap<>();
        Map<String, Double> map = new HashMap<>();
        
        for (int i = 0; i < equations.length; i++){
            String x1 = equations[i][0];
            String x2 = equations[i][1];
            
            parents.putIfAbsent(x1, x1);
            parents.putIfAbsent(x2, x2);
            map.putIfAbsent(x1, 1.0);
            map.putIfAbsent(x2, 1.0);
            
            String r1 = find(parents, map, x1);
            String r2 = find(parents, map, x2);
            parents.put(r2, r1);
            map.put(r2, map.get(x1) * values[i] / map.get(x2));
        }
        
        for (int i = 0; i < queries.length; i++){
            String x1 = queries[i][0];
            String x2 = queries[i][1];
            if (!parents.containsKey(x1) || !parents.containsKey(x2)){
                result[i] = -1;
                continue;
            }
            String r1 = find(parents, map, x1);
            String r2 = find(parents, map, x2);
            if (r1.equals(r2)){
                result[i] = (double)(map.get(x2) / map.get(x1));
            } else
                result[i] = -1;
        }
        
        return result;
    }
    
    
    
    private String find(Map<String, String> parents, Map<String, Double> map, String str){
        String parent = parents.get(str);
        if (str.equals(parent))
            return str;
        String pre = parent;
        parent = find(parents, map, parent);
        parents.put(str, parent);
        map.put(str, map.get(pre) * map.get(str));
        return parent;
    }
    
    
}
