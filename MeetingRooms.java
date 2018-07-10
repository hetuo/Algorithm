class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int result = 0;
        if (intervals == null || intervals.length == 0)
            return result;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                if (i1.start == i2.start)
                    return i1.end - i2.end;
                return i1.start - i2.start;
            }
        });
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                if (i1.end == i2.end)
                    return i1.start- i2.start;
                return i1.end - i2.end;
            }            
        });
        heap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++){
            Interval m = heap.poll();
            if (m.end <= intervals[i].start)
                heap.offer(intervals[i]);
            else{
                heap.offer(m);
                heap.offer(intervals[i]);
            }
        }
        return heap.size();
    }
}
