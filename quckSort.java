class Solution {
    public void quckSort(int[] arr,int left,int right){
        if(left>right)
            return;
        
        int i = left,j=right;
        int base = arr[left];//基准位

        //基准值在左，所以先左后右
        while(i<j){
            //先看右边，依次往左递减
            while (base <= arr[j] && i<j)
                j--;
            
            //后看左边，依次往右递加
            while (base >= arr[i] && i<j)
                i++;
            
            if (i<j) {
                int t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        
        int temp = arr[left];
        arr[left] = arr[i];
        arr[i] = temp;
        
        quckSort(arr,left,j-1);
        quckSort(arr,j+1,right);
    }
}
