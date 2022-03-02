package offer;

public class Offer04_二维数组中的查找 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int row = 0, col = matrix[0].length-1;
        while (row<matrix.length && col>=0){
            if(matrix[row][col] == target) return true;
            else if (matrix[row][col]<target) row++;
            else col--;
        }
        return false;
    }
}
