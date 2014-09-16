public class SetMatrixZeroesTrialTwo{

     public static void main(String []args){
        int matrix[][] = {{2, 2, 1},
                       {1, 0, 3},
                       {0, 2, 1}};
        setZeroes(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
              System.out.print(matrix[i][j]+" ");  
            }
            System.out.println();
        }
    }
    
    public static void setZeroes(int[][] matrix) {
    
        int col_len = matrix.length;
        int row_len = matrix[0].length;
    
        boolean first_row_zero = false;
        boolean first_col_zero = false;
        
        for(int i=0;i<col_len;i++){
            if(matrix[i][0]==0)
                first_col_zero = true;
        }
        
        for(int j=0;j<row_len;j++){
            if(matrix[0][j]==0)
                first_row_zero = true;
        }
    
        for(int i=1;i<col_len;i++){
            for(int j=1;j<row_len;j++){
                if(matrix[i][j]==0){
        matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
    
        for(int i=1;i<col_len;i++){
            for(int j=1;j<row_len;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        
        if(first_col_zero){
             for(int i=0;i<col_len;i++)
                matrix[i][0]=0;
        }
        
        if(first_row_zero){
            for(int j=0;j<row_len;j++)
                matrix[0][j]=0;
        }
    }
}
