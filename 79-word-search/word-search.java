class Solution {
    boolean dp[][];
    public boolean exist(char[][] board, String word) {
        dp = new boolean[board.length+1][board[0].length+1];
        boolean ans = false;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                ans = ans || help(board, i, j, word, 0);
            }
        }
        return ans;
    }

    boolean help(char board[][], int i, int j, String word, int k){
        if(k == word.length()){
            return true;
        }

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(k)){
            return false;
        }

        if(dp[i][j]){
            return false;
        }

        boolean ans1 = false, ans2 = false;
        char ch = board[i][j];
        if(board[i][j] == word.charAt(k)){
            board[i][j] = '#';
            if(help(board, i+1, j, word, k+1) || help(board, i-1, j, word, k+1)
                    || help(board, i, j+1, word, k+1) || help(board, i, j-1, word, k+1)){
                        ans1 = true;
                    }
            board[i][j] = ch;
        }else{
            if(help(board, i+1, j, word, k) || help(board, i-1, j, word, k)
                    || help(board, i, j+1, word, k) || help(board, i, j-1, word, k)){
                        ans2 = true;
                    }
        }

        dp[i][j] = ans1 || ans2;

        return ans1 || ans2;
    }
}