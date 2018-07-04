class Solution {
    
    int max = 0;
    
    public int matrixScore(int[][] A) {
        int M = A.length, N = A[0].length, res = (1 << (N - 1)) * M;
        for (int j = 1; j < N; j++) {
            int cur = 0;
            for (int i = 0; i < M; i++) cur += A[i][j] == A[i][0] ? 1:0;
            res += Math.max(cur, M - cur) * (1 << (N - j - 1));
        }
        return res;
    }
    
    private void backtracking(int[][] A, int index){
        if (index >= Math.max(A.length, A[0].length)){
            // max = Math.max(max, calculate(A));
            return;
        }
        max = Math.max(max, calculate(A));
        for (int i = index; i < Math.max(A.length, A[0].length); i++){
            if (i < A.length){
                for (int j = 0; j < A[0].length; j++)
                    A[i][j] ^= 1;
                backtracking(A, i + 1);
                for (int j = 0; j < A[0].length; j++)
                    A[i][j] ^= 1;
            }
            if (i < A[0].length){
                for (int j = 0; j < A.length; j++)
                    A[j][i] ^= 1;
                backtracking(A, i + 1);
                for (int j = 0; j < A.length; j++)
                    A[j][i] ^= 1;
            }
        }
    }
    
    
    private int calculate(int[][] A) {  
        
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < A[0].length; j++)
                System.out.print(A[i][j] + ",");
            System.out.println();
        }
        
        int result = 0;
        for (int i = 0; i < A.length; i++){
            int n = 0;
            for (int j : A[i]){
                n = n << 1;
                n += j;
            }
            result += n;
        }
        
        System.out.println(result + "----------------");
        return result;
    }
}
