class Solution {
    void mergesort(int[] arr,int low,int high){
         if (low >= high) {
            return;
        }

        
            int mid = low + (high - low) / 2;
            mergesort(arr,low,mid);
            mergesort(arr,mid+1,high);
            merge(arr,low,mid,high);
        
    }
    void  merge(int[] arr,int low,int mid,int high){
        int[] temp=new int[high-low+1];
        int i=low;
        int j=mid+1;
        int k=0;
        while(i<=mid &&j<=high){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i];
                i++;
            }else{
                temp[k++]=arr[j];
                j++;
            }
        }
         while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }
        for (i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }

    public int[] sortArray(int[] nums) {
        mergesort(nums, 0, nums.length - 1);

        return nums;
        
    }
}