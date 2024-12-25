import java.util.*;

class Solutions {

    public static boolean isValid(int[] arr, int maxW, int days){
        long currW = 0;
        int d = 1;
        for(int i = 0; i < arr.length; ++i){
            if(currW + arr[i] <= maxW){
                currW += arr[i];
            }else if(arr[i] <= maxW){
                d++;
                currW = arr[i];
            }else{
                return false;
            }
        }
        if(d <= days){
            return true;
        }
        return false;
    }

    public static int solve(int[]arr, int k){
        //k are the no. of days we can take to transport the weight
        int res = -1;
        int low = 1;
        int high = sumOfW(arr);
        while(low<=high){
            int mid = low + (high - low)  / 2;
            //mid is the maxW each day we can carry
            if (isValid(arr, mid, k)) {
                res = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return res;
    }

    public static int sumOfW(int[]arr){
        int sum = 0;
        for(int i = 0;i < arr.length; ++i){
           sum += arr[i];
        }
        return sum;
    }
}

public class capacityToShipPackage {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i=0;i<n;i++){
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        System.out.println(Solutions.solve(A,B));
    }
}
