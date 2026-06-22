class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++){
            HashSet<Character> seen = new HashSet<>();
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                if(seen.contains(board[i][j])){
                    return false;
                } else{
                    seen.add(board[i][j]);
                }     
            }
        }

        for (int i = 0 ; i<board.length; i++){
            HashSet<Character> seen = new HashSet<>();
            for (int j = 0; j < board.length ; j++){
                if(board[j][i] == '.'){
                    continue;
                }
                if(seen.contains(board[j][i])){
                    return false;
                } else{
                    seen.add(board[j][i]);
                }
            }
        }

        for (int boxRow = 0; boxRow < 3; boxRow++){
            for(int boxCol = 0 ; boxCol < 3; boxCol++){
                HashSet<Character> seen = new HashSet<>();
                for(int r = 0; r<3; r++){
                    for (int c= 0; c<3; c++){
                        char cell = board[boxRow*3 + r][boxCol*3 + c];
                        if(cell == '.'){
                            continue;
                        }
                        if(seen.contains(cell)){
                            return false;
                        } else{
                            seen.add(cell);
                        }
                    }
                }
            }
        }
        return true;
    }
}
