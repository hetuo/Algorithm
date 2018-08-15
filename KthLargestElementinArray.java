class Solution {
    
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int position = partition(nums, left, right);
            if(position < k) {
                left = position + 1;
            } else if (position > k) {
                right = position - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int left, int right) {
        int i = left;
        int j = right + 1;
        while(true) {
            while(i < right && less(a[++i], a[left]));
            while(j > left && less(a[left], a[--j]));
            if(i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, left, j);
        return j;
    }

    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(int v, int w) {
        return v < w;
    }
}
