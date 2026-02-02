class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s== null || s.length() == 0){
            return 0;
        }

        int sign = 1, start = 0;
        long sum = 0L;
        if(s.charAt(0) == '-'){
            sign = -1;
            start++;
        }else if(s.charAt(0) == '+'){
            sign = 1;
            start++;
        }

        for(int i=start; i<s.length(); i++){
            char c = s.charAt(i);
            if(!Character.isDigit(c)){
                return (int)sum * sign;
            }
            sum = sum  * 10 + (c - '0');
            if(sign == 1 && sum > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }

            if(sign == -1 && (-1) * sum < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }

        return (int)sum * sign;
    }
}