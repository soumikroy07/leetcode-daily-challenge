class Solution {
   public int[] sortArray(int[] nums) {
        int n=nums.length;
        int l=0, r=n-1;
        mergeSort(nums,l,r);
        return nums;
    }
     void mergeSort(int arr[],int l, int r){
        if(l<r){
            int mid=l+(r-l)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }
    }
     void merge(int arr[],int l,int mid,int r){
        int n1=mid-l+1,n2=r-mid;
        int[] left=new int[n1];
        int[] right=new int[n2];
        for(int i=0;i<n1;i++){
            left[i]=arr[l+i];
        }
        for(int i=0;i<n2;i++){
            right[i]=arr[i+mid+1];
        }
        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                arr[k]=left[i];
                i++;
            }
            else{
                arr[k]=right[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k++]=left[i++];
        }
        while(j<n2){
            arr[k++]=right[j++];
        }
    }
}