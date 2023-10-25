class Solution {
    public int kthGrammar(int n, int k) {
        if(n==1) {
            return 0;
        }
        int parent = kthGrammar(n-1, (k+1)/2);
        if(k%2 == 0) {
            return parent == 1? 0 : 1;
        } else {
            return parent;
        }
    }
}

/*

class Solution {
    String curr = "0";
    public int kthGrammar(int n, int k) {       
        solve(curr, 1, n);
        return curr.charAt(k-1) - '0';
    }

    void solve(String curr, int row, int n){
        if(row == n){
            return;
        }
        String str = "";
        for(char c : curr.toCharArray()){
            if(c == '0'){
                str += "01";
            }else{
                str += "10";
            }
        }
        solve(str, row+1, n);
    }
}

*/