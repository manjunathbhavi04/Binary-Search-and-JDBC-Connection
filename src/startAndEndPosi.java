import java.util.*;
public class startAndEndPosi {
    public static int firstOccur(int[] arr, int key){
        int start = -1;
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                if (mid == 0 || arr[mid - 1] != key) {
                    start = mid;
                    return start;
                } else {
                    right = mid - 1;
                }
            }else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int lastOccur(int[]arr, int key){
        int end = -1;
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                if (mid == arr.length - 1 || arr[mid + 1] != key) {
                    end = mid;
                    return end;
                } else {
                    left = mid + 1;
                }
            }else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = {1, 2, 3, 3, 4, 4, 8, 8, 9};
        int key = 8;
        int start = firstOccur(arr, key);
        int end = lastOccur(arr, key);
        System.out.println(start+" "+end);

    }
}
