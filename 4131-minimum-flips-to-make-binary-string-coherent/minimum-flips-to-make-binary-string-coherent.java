class Solution {
    public int minFlips(String s) {
        if(s.length() < 3){
            return 0;
        }

        if(s.length() == 3){
            if(s.equals("011") || s.equals("110")){
                return 1;
            }else{
                return 0;
            }
        }

        int one = 0, zero = 0;

        for(char c: s.toCharArray()){
            if(c == '0'){
                zero++;
            }else{
                one++;
            }
        }
        

        int cost1 = 0;
        if(one == 0){
            cost1 = 1;
        }else if(one > 1){
            cost1 = one - 1;
        }

        int cost2 = 0;
        boolean left = false, right = false;
        if(one >= 2){
            if(s.charAt(0) == '1'){
                left = true;
            }
            if(s.charAt(s.length()-1) == '1'){
                right = true;
            }
            if(left && right){
                cost2 = one - 2;
            }else if(left || right){
                cost2 = one - 1;
            }else{
                cost2 = one + 2;
            }
        }else{
            cost2 = Integer.MAX_VALUE;
        }

        System.out.print(zero + " " + one + " " + cost1 + " " + cost2);

        return Math.min(Math.min(zero, one), Math.min(cost1, cost2));
    }
}

//011 , 110