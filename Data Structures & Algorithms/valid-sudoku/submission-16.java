class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i<board.length; i++){
            HashSet<Character> seen = new HashSet<>();
            for(int j = 0; j < board[i].length;j++){
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

        for(int i = 0; i<board.length; i++){
            HashSet<Character> seen = new HashSet<>();
            for(int j = 0; j < board[i].length;j++){
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

        for(int rowNum = 0 ; rowNum<3; rowNum++){
            for(int colNum = 0 ;colNum<3; colNum++){
                HashSet<Character> seen = new HashSet<>();
                for(int r = 0 ; r<3; r++){
                    for(int c = 0; c<3; c++){
                        char cell = board[3*rowNum + r][3*colNum + c];
                        if (cell == '.'){
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
