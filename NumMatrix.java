class NumMatrix {
    
    private int[][] sumMatrix;
    private int[][] matrix;
    
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        int row = matrix.length;
        int col = matrix[0].length;
        sumMatrix = new int[row][col];
        this.matrix = new int[row][col];
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++){
                this.matrix[i][j] = matrix[i][j];
                sumMatrix[i][j] += matrix[i][j];
                if (i - 1 >= 0)
                    sumMatrix[i][j] += sumMatrix[i - 1][j];
                if (j - 1 >= 0)
                    sumMatrix[i][j] += sumMatrix[i][j - 1];
                if (i - 1 >= 0 && j - 1 >= 0)
                    sumMatrix[i][j] -= sumMatrix[i - 1][j - 1];
            }
        
    }


    public void update(int row, int col, int val) { 
        for (int i = row; i < sumMatrix.length; i++)
            for (int j = col; j < sumMatrix[0].length; j++){
                sumMatrix[i][j] += val - matrix[row][col];
            }
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = sumMatrix[row2][col2];
        if (col1 - 1 >= 0)
            sum -= sumMatrix[row2][col1 - 1];
        if (row1 - 1 >= 0)
            sum -= sumMatrix[row1 - 1][col2];
        if (col1 - 1 >= 0 && row1 - 1 >= 0)
            sum += sumMatrix[row1 - 1][col1 - 1];
        return sum;
    }
    
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
