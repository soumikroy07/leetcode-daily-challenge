class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        
        if(len1 > len2) return findMedianSortedArrays(nums2, nums1);
        
        int start = 0, end = len1;
        
        while(start <= end){
            int cut1 = start + (end - start)/2;
            int cut2 = (len1+len2+1)/2 - cut1;
            
            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1-1];
            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2-1];
            int right1 = (cut1 == len1) ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = (cut2 == len2) ? Integer.MAX_VALUE : nums2[cut2];
            
            if(left1 > right2){
                end = cut1 - 1;
            }else if(left2 > right1){
                start = cut1 + 1;
            }else{
                if((len1+len2)%2 == 0){
                    return ((Math.max(left1,left2))+Math.min(right1,right2)) / 2.0;
                }else{
                    return Math.max(left1,left2);
                }
            }
        }
        
        return 0.0;
    }
}