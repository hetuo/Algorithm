class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        } 
        return findHelper(nums, 0, nums.length - 1);
    }
    
    private int findHelper(int[] nums, int left, int right) {
        if (left > right) return - 1;
        
        int midIndex = left + ((right - left) / 2);
        int mid = nums[midIndex];
        int pre = midIndex == 0 ? Integer.MIN_VALUE : nums[midIndex - 1];
        int post = midIndex == nums.length - 1 ? Integer.MIN_VALUE : nums[midIndex + 1];
        
        if (mid > pre && mid > post || nums.length == 1) return midIndex;
        
        else if (mid < pre) return findHelper(nums, left, midIndex - 1);//left side has the peak
        
        else return findHelper(nums, midIndex + 1, right);//right side has the peak
    }
}
