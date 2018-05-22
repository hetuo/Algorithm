class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // if (nums == null || nums.length == 0)
        //     return nums;
        // int[] result = new int[nums.length - k + 1];
        // Deque<Integer> numsDeque = new LinkedList<Integer>();
        // Deque<Integer> maxDeque = new LinkedList<Integer>();
        // int n = 0;
        // for (int i = 0; i < nums.length; i++){
        //     if (numsDeque.size() != k){
        //         numsDeque.add(nums[i]);
        //         if (maxDeque.size() == 0)
        //             maxDeque.add(nums[i]);
        //         else if (nums[i] > maxDeque.getLast())
        //             maxDeque.add(nums[i]);
        //         else
        //             maxDeque.add(maxDeque.getLast());
        //     }else {
        //         result[n++] = maxDeque.getLast();
        //         int head = numsDeque.pollFirst();
        //         do{
        //             maxDeque.pollFirst();
        //         }while (maxDeque.size() > 0 && maxDeque.peekFirst() == head);
        //         numsDeque.add(nums[i]);
        //         int max = 0;
        //         if (maxDeque.size() > 0)                    
        //             max = nums[i] > maxDeque.getLast() ? nums[i] : maxDeque.getLast();
        //         else
        //             max = getMax(numsDeque); 
        //         while (maxDeque.size() < k)
        //             maxDeque.add(max);
        //     }
        // }
        // if (maxDeque.size() > 0)
        //     result[n] = maxDeque.getLast();
        // return result;
        
        if (nums == null || nums.length == 0)
            return nums;
        int[] result = new int[nums.length - k + 1];
        int n = 0;
        Deque<Integer> q = new ArrayDeque<Integer>();
        for (int i = 0; i < nums.length; i++){
            while (!q.isEmpty() && q.peekFirst() < i - k + 1)
                q.pollFirst();
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i])
                q.pollLast();
            q.offer(i);
            if (i >= k - 1)
                result[n++] = nums[q.peekFirst()];

        }
        return result;
    }
    
    private int getMax(Deque<Integer> deque){
        int max = deque.getFirst();
        for(int i : deque)
            if (i > max)
                max = i;
        return max;
    }
}
