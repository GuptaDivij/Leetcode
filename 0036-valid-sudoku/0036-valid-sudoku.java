class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 3 checks - rows, columns, boxes
        // for the size nxn 
        int n = board.length; 

        // time - O(n^2)
        // space - O(n)

        // check the rows
        for(int i = 0; i<n; i++){
            HashSet<Character> setRows = new HashSet<>();
            for(int j = 0; j<n; j++){
                if(board[i][j] =='.') continue;
                if(setRows.contains(board[i][j])) return false;
                setRows.add(board[i][j]);
            }
        }

        // columns
        for(int j = 0; j<n; j++){
            HashSet<Character> setCols = new HashSet<>();
            for(int i = 0; i<n; i++){
                if(board[i][j] =='.') continue;
                if(setCols.contains(board[i][j])) return false;
                setCols.add(board[i][j]);
            }
        }

        // check for the boxes
        // n should always be a square number
        for(int i = 0; i<n; i+=Math.sqrt(n)){
            // basically now I am on the top left of the box
            // this should be the starting point of the box
            for(int j = 0; j<n; j+=Math.sqrt(n)){
                // i1 and j1 
                HashSet<Character> setBoxes = new HashSet<>();
                for(int i1 = i; i1<i+Math.sqrt(n); i1++){
                    for(int j1 = j; j1<j+Math.sqrt(n); j1++){
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