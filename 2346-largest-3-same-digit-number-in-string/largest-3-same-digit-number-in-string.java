class Solution {
    public String largestGoodInteger(String num) {
        int count = 1, ans = -1;
        for(int i=1; i<num.length(); i++){
            if(num.charAt(i) == num.charAt(i-1)){
                count++;
            }else{
                count = 1;
            }

            if(count == 3 && ans < num.charAt(i) - '0'){
                ans = num.charAt(i) - '0';
            }
        }
        StringBuilder sb = new StringBuilder();
        if(ans != -1){
            for(int i=0; i<3; i++){
                sb.append(ans);
            }
        }
        return sb.toString();
    }
}