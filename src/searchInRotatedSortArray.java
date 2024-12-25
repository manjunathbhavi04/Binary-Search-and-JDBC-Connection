import com.sun.security.jgss.GSSUtil;

public class searchInRotatedSortArray {

    public static int search(int[] arr, int key, int low, int high){
        int left = low;
        int right = high;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == key){
                return mid;
            }
            if(arr[mid] < key){
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }
        return -1;
    }

    public static int findMinIndex(int[] arr){
        int l = 0;
        int r = arr.length - 1;
        while(l < r){
            int m = l + (r - l) / 2;
            if(arr[m] > arr[r]) {
                l = m + 1;
            }else {
                r = m;
            }
        }
        return r;
    }

    public static void main(String[] args){

        //first find the index of the smallest number then divide the array in two parts and search
        //in any part where the element lies in between else return -1
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int key = 2;
        int l = 0, r = arr.length - 1;
        int idx = findMinIndex(arr);
        if(idx != 0 && key >= arr[0] && key<=arr[idx - 1]){
            r = idx - 1;
        }else if(key >= arr[idx] && key <= arr[arr.length - 1]){
            l = idx;
        }else{
            System.out.println(-1);
            return;
        }
        int index = search(arr, key, l, r);
        System.out.println(index);
    }
}
