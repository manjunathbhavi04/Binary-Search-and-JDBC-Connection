public class peakIndexMountain {
    public static int peak(int[] arr){
        // there is only one peak in the array so when we find a peak we return it
        int l = 0;
        int r = arr.length - 1;
        while(l <= r){
            int m = l + (r - l) / 2;
            if(arr[m]>arr[m-1] && arr[m]>arr[m+1]){
                return m;
            }
            //now either we go left or right
            //we go left if m - 1 element is bigger than current mid
            // we are doing this because the above condition failed so anyone condition we be true to go left or right
            if(arr[m] > arr[m - 1]){
                l = m + 1; // going right
            }
            if(arr[m - 1] > arr[m]){
                r = m - 1; // going left
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[] arr = {0, 10, 20, 2};
        System.out.println(peak(arr));
    }
}
