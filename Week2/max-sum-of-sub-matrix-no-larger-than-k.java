public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length ==0 || matrix[0]==null||matrix[0].length ==0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int [][] Area = new int [row][col];
        for (int r =0 ; r < row; r++){
            for(int c = 0; c< col; c++){
                int area = matrix[r][c];
                if(r-1>=0) area += Area[r-1][c];
                if(c-1>=0) area += Area[r][c-1];
                if( r-1>=0 && c-1>=0) area -= Area[r-1][c-1];
                Area[r][c] = area;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int r1 = 0; r1 < row; r1++){
            for(int c1 = 0; c1< col; c1++){
                for(int r2= r1; r2 < row; r2++){
                    for(int c2 = c1; c2 < col; c2++){
                        int area = Area[r2][c2];
                        if(r1-1>=0) area -=Area[r1-1][c2];
                        if(c1-1>=0) area -=Area[r2][c1-1];
                        if(r1-1>=0 && c1-1>=0) area += Area[r1-1][c1-1];
                        if( area <=k) max = Math.max(max, area);
                    }
                }
            }
        }
        return max;
        
    }
}
