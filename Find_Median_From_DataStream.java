class MedianFinder {
    
    private PriorityQueue<Double> left;
    private PriorityQueue<Double> right;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        this.left = new PriorityQueue<>(Collections.reverseOrder());
        this.right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (left.size() <= right.size()){
            right.add((double)num);
            left.add(right.poll());
        } else{
            left.add((double)num);
            right.add(left.poll());
        }
    }
    
    public double findMedian() {
        if (left.size() == right.size())
            return (left.peek() + right.peek()) / 2.0;
        else
            return left.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
