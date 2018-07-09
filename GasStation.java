class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        
        for (int i = 0; i < n; i++){
            int tank = 0;
            int s = 0;
            int j = i;
            while (s < n){
                j = s + i;
                if (j >= n)
                    j -= n;
                tank += gas[j];
                if (tank < cost[j])
                    break;
                tank -= cost[j];
                s += 1;
            }
            if (s == n)
                return i;
                
        }
        
        return -1;
    }
}
