class Solution {
    public int diagonalSum(int[][] mat) {
        int diagonalSum = 0;
        
        for(int i=0; i<mat.length; i++){
            diagonalSum += mat[i][i] + mat[i][mat.length-1-i];
        }
        
        if(mat.length % 2 == 1) {
            diagonalSum -= mat[mat.length/2][mat.length/2];
        }
        
        return diagonalSum;
    }
}
