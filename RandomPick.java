class Solution {
    
    private List<Interval> list;

    public Solution(int N, int[] blacklist) {
        list = new ArrayList<Interval>();
        if (blacklist == null || blacklist.length == 0)
            list.add(new Interval(0, N - 1));
        else
            createIntervals(N, blacklist);
    }
    
    public int pick() {
        int n = list.size();
        Interval interval = list.get(randomWithRange(0, n - 1));
        return randomWithRange(interval.start, interval.end);
    }
    
    private int randomWithRange(int min, int max){
        if (max == min)
            return max;
        int range = Math.abs(max - min) + 1;
        return (int)(Math.random() * range) + Math.min(min, max);
    }
    
    private void createIntervals(int n, int[] b){
        Arrays.sort(b);
        int start = 0;
        for (int i = 0; i < b.length; i++){
            int end = b[i] - 1;
            if (end >= start)
                list.add(new Interval(start, end));
            start = b[i] + 1;
        }
        if (start <= n - 1)
            list.add(new Interval(start, n - 1));
    }
    
    private class Interval{
        int start;
        int end;
        
        public Interval(int start, int end){
            this.start = Math.min(start, end);
            this.end = Math.max(start, end);
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */
