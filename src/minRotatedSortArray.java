//import java.util.*;

public class minRotatedSortArray {

//    here we are using binary search to find minimum value tc -> O(logN) better than linear search
    public static int findMin(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            //logic
            int mid = left + (right - left) / 2;
            if(arr[mid] > arr[right]){
                left = mid + 1;
            }else{
                right  = mid;
            }
        }
        return arr[right];
    }

    public static void main(String[] args){
        int[] arr = {8, -1, 1, 2, 3, 4, 5, 6, 7};
        int min = findMin(arr);
        System.out.println(min+"");
    }
}
