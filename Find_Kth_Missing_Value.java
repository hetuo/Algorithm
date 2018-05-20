Class Solution {

  public int findKthMissingValue(int[] A, int[] B, int k){
      if (A == null || A.length == 0 || B == null || B.length ==0 || A.length < k)
        return -1;
      
      Set<Integer> set = new HashSet<>();
      for (int i : B)
        set.add(i);
      for (int i = 0; i < A.length; i++){
        if (!set.contains(A[i]))
          k--;
        if (k == 0)
          return A[i]
      }
      return -1
  }
}
