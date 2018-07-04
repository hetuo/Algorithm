class Solution {
    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0)
            return true;
        int[] array = new int[2];
        for (int i : bills){
            int a = i - 5;
            if (a == 15){
                if (array[1] >= 1 && array[0] >= 1){
                    array[1]--;
                    array[0]--;
                } else if (array[0] >= 3){
                    array[0] -= 3;
                } else
                    return false;
            } else if (a == 5){
                if (array[0] >= 1){
                    array[0]--;
                    array[1]++;
                } else
                    return false;
            } else
                array[0]++;
            
        }
        
        return true;
    }
}
