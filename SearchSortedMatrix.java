public class SearchSortedMatrix{

    public static void main(String []args){
        int[][] matrix = {{1, 3, 5, 7},
                          {10, 11, 16, 20},
                          {23, 30, 24, 50}};
        boolean result = searchMatrix(matrix, 5);
        System.out.println(result);
    }
    
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row_len = matrix.length;
        int col_len = matrix[0].length;
    
        if(row_len==0||col_len==0)
            return false;
        
        int row = 0;
        int col = matrix[0].length-1;
    
        while(row<row_len && col>=0){
            if(matrix[row][col]==target)
                return true;
            else if(matrix[row][col]>target)
                col--;
            else
                row++;
        }
    
        return false;
    }
}