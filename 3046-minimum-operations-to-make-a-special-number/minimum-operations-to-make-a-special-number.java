class Solution {
    public int minimumOperations(String num) {
        int count1 = 0, count2 = 0, count3 = 0, count4 = 0, flag = 0;
        int n = num.length();

        //00
        for(int i=n-1; i>=0; i--){
            if(num.charAt(i) == '0' && flag == 0){
                flag++;
            }else if(num.charAt(i) == '0' && flag == 1){
                flag++;
                break;
            }else{
                count1++;
            }
        }
        flag = 0;

        //25
        for(int i=n-1; i>=0; i--){
            if(num.charAt(i) == '5' && flag == 0){
                flag++;
            }else if(num.charAt(i) == '2' && flag == 1){
                flag++;
                break;
            }else{
                count2++;
            }
        }

        if(flag != 2){
            count2 = n;
        }
        flag = 0;

        //50
        for(int i=n-1; i>=0; i--){
            if(num.charAt(i) == '0' && flag == 0){
                flag++;
            }else if(num.charAt(i) == '5' && flag == 1){
                flag++;
                break;
            }else{
                count3++;
            }
        }

        if(flag != 2){
            count3 = n;
        }
        flag = 0;

        //75
        for(int i=n-1; i>=0; i--){
            if(num.charAt(i) == '5' && flag == 0){
                flag++;
            }else if(num.charAt(i) == '7' && flag == 1){
                flag++;
                break;
            }else{
                count4++;
            }
        }

        if(flag != 2){
            count4 = n;
        }
        flag = 0;

        return Math.min(Math.min(count1, count2), Math.min(count3, count4));

    }
}