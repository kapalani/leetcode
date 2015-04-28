import java.util.HashSet;
import java.util.Set;


public class ValidSudoku {
	public static void main (String[] args) {
		char[][] board = {
		{'.', '.', '4', '.', '.', '.', '6', '3', '.'},
		{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
		{'5', '.', '.', '.', '.', '.', '.', '9', '.'},
		{'.', '.', '.', '5', '6', '.', '.', '.', '.'},
		{'4', '.', '3', '.', '.', '.', '.', '.', '1'},
		{'.', '.', '.', '7', '.', '.', '.', '.', '.'},
		{'.', '.', '.', '5', '.', '.', '.', '.', '.'},
		{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
		{'.', '.', '.', '.', '.', '.', '.', '.', '.'}};
		
		boolean result = isValidSudoku(board);
		System.out.println(result);
	}
	
	public static boolean isValidSudoku(char[][] board) {
        if (board == null) return false;
        
        if (board.length != 9 && board[0].length != 9) return false;
        
        HashSet<Character> set = new HashSet<Character>();
        set.add('1');
        set.add('2');
        set.add('3');
        set.add('4');
        set.add('5');
        set.add('6');
        set.add('7');
        set.add('8');
        set.add('9');
        
        //Check every row to be valid
        for (int i=0; i<9; i++) {
        	for (int j=0; j<9 ;j++) {
        		if (board[i][j] == '.')  continue;
        		if (set.contains(board[i][j])) {
        			set.remove(board[i][j]);
        		} else {
        			return false;
        		}
        	}
        	reInitializeSet(set);
        }
        
        //Check every col to be valid
        for (int j=0; j<9; j++) {
        	for (int i=0; i<9; i++) {
        		if (board[i][j] == '.') continue;
        		if (set.contains(board[i][j])) {
        			set.remove(board[i][j]);
        		} else {
        			return false;
        		}
        	}
        	reInitializeSet(set);
        }
        
        for (int i=0;i<9;i=i+3) {
        	
        	for (int j=0;j<9;j=j+3) {
        		boolean res = checkSubSquare(i, j, 3, set, board);
        		if (!res) return false;
            	reInitializeSet(set);
        	}
        }
        
        return true;
    }
	
	//Check for each subsquare to be valid
	private static boolean checkSubSquare(int i, int j, int step, Set<Character> set, char[][] board) {
		int tempI = i;
		for (; i < tempI + step; i++) {
			if (board[i][j] == '.') continue;
			if (set.contains(board[i][j])) {
				set.remove(board[i][j]);
			} else {
				return false;
			}
		}
		
		j++;
		i = tempI;
		
		for (; i < tempI + step; i++) {
			if (board[i][j] == '.') continue;
			if (set.contains(board[i][j])) {
				set.remove(board[i][j]);
			} else {
				return false;
			}
		}
		
		j++;
		i = tempI;
		
		for (; i < tempI + step; i++) {
			if (board[i][j] == '.') continue;
			if (set.contains(board[i][j])) {
				set.remove(board[i][j]);
			} else {
				return false;
			}
		}
		
		return true;
	}

	private static void  reInitializeSet(Set<Character> set) {
		set.add('1');
        set.add('2');
        set.add('3');
        set.add('4');
        set.add('5');
        set.add('6');
        set.add('7');
        set.add('8');
        set.add('9');
	}
}
