public class SetMatrixZeroesTrialOne{

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
    
        boolean[] col = new boolean[col_len];
        boolean[] row = new boolean[row_len];
    
        for(int i=0;i<col_len;i++){
            for(int j=0;j<row_len;j++){
                if(matrix[i][j]==0){
                    col[i]=true;
                    row[j]=true;
                }
            }
        }
    
        for(int i=0;i<col_len;i++){
            for(int j=0;j<row_len;j++){
                if(col[i] || row[j])
                    matrix[i][j]=0;
            }
        }
    }
}