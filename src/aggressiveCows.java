import java.util.*;

public class aggressiveCows {

    public static boolean isValidToPlace(int[] arr, int cows, int dist){
        int lastPlaced = arr[0];
        int countCows = 1;
        for(int i = 1; i  <arr.length; ++i){
            if(arr[i] - lastPlaced >= dist){
                countCows++;
                lastPlaced = arr[i];
            }
            if(countCows >= cows){
                return true;
            }
        }
        return false;
    }

    public static int aggressiveCow(int[] arr, int cows){
        Arrays.sort(arr);
        int low = 1; //least possible dist two cows can be at is 1 because 1 cow occupies one stall
        int high  = arr[arr.length - 1] - arr[0]; // maximum dist two cows can be at the end stalls
        //Binary Search on Answer mid is the answer which we get from low and high
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isValidToPlace(arr, cows, mid)){
                low = mid + 1; //trying to get more distance because were placed
            }else{
                high = mid  - 1; // some cows are left with the dist so we decrease the distance between them
            }
        }
        return high;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(aggressiveCow(nums,k));
    }
}
