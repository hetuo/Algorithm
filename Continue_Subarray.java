class Solution {

  public boolean continueSubarray(List<Integer> list, Set<Integer> set) {
    
    if (list == null || list.size() == 0 || set == null || set.length() == 0 || list.size() < set.length())
      return false;
    
    for (int i = 0, j = set.length - 1; j < list.size() - 1;){
      if (!set.contains(list.get(i))){
        i = i + 1;
        j = i + set.length - 1;
      }else if (i == j)
        return true;
      else
        i++;
    }
    
    return false;
  }
}
