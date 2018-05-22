class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] medians = new double[nums.length - k + 1];
        PriorityQueue<Double> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Double> right = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++){
            if (left.size() <= right.size()){
                right.add((double)nums[i]);
                left.add(right.poll());
            } else{
               left.add((double)nums[i]);
                right.add(left.poll());
            }
            if (i >= k - 1){
                medians[i - k + 1] = k % 2 == 0 ? (right.peek() + left.peek()) / 2.0 : left.peek();
                if (nums[i -k + 1] <= medians[i - k + 1])
                    left.remove((double)nums[i - k + 1]);
                else
                    right.remove((double)nums[i - k + 1]);
            }
        }
        return medians;
    }
}
