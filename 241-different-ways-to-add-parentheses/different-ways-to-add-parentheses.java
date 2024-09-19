class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<expression.length(); i++){
            char c = expression.charAt(i);
            if(c == '+' || c=='-' || c=='*'){
                String a = expression.substring(0, i);
                String b = expression.substring(i+1, expression.length());
                List<Integer> left = diffWaysToCompute(a);
                List<Integer> right = diffWaysToCompute(b);
                
                for(int x : left){
                    for(int y : right){
                        if(c == '*'){
                            ans.add(x*y);
                        }else if(c == '+'){
                            ans.add(x+y);
                        }else if(c == '-'){
                            ans.add(x - y);
                        }
                    }
                }
            }
            
        }
        
        if(ans.size() == 0) ans.add(Integer.valueOf(expression));
        return ans;
    }
}