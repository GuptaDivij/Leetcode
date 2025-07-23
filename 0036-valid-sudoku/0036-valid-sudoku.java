class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check for rows
        for(int i = 0; i<9; i++){
            HashSet<Character> setRows = new HashSet<>();
            for(int j = 0; j<9; j++){
                if(board[i][j] =='.') continue;
                if(setRows.contains(board[i][j])) return false;
                setRows.add(board[i][j]);
            }
        }

        // check for columns
        for(int j = 0; j<9; j++){
            HashSet<Character> setCols = new HashSet<>();
            for(int i = 0; i<9; i++){
                if(board[i][j] =='.') continue;
                if(setCols.contains(board[i][j])) return false;
                setCols.add(board[i][j]);
            }
        }

        // check for the boxes
        for(int i = 0; i<9; i+=3){
            for(int j = 0; j<9; j+=3){
                HashSet<Character> setBoxes = new HashSet<>();
                for(int i1 = i; i1<i+3; i1++){
                    for(int j1 = j; j1<j+3; j1++){
                        if(board[i1][j1] =='.') continue;
                        if(setBoxes.contains(board[i1][j1])) return false;
                        setBoxes.add(board[i1][j1]);
                    }
                }
            }
        }
        return true;
    }
}