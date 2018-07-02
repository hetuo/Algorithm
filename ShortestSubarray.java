class Solution {
    public static int shortestSubarray(int[] A, int K) {
        int n = A.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++)
            sum[i + 1] = sum[i] + A[i];
        Deque<Integer> dq = new ArrayDeque<>();
        int res = n + 1;
        for (int i = 0; i < n + 1; i++){
            while(dq.size() > 0 && sum[i] - sum[dq.peekFirst()] >= K)
                res = Math.min(res, i - dq.pollFirst());
            while (dq.size() > 0 && sum[i] < sum[dq.peekLast()])
                dq.pollLast();
            dq.add(i);
        }
        return res > n ? -1 : res;
    }
}
 
