import java.util.*;

public class minimumLimitsOfBallsInBag {


    public static boolean isValid(int[] arr, int penalty, int maxOp){
        int ops = 0;
        for(int i = 0; i < arr.length; ++i){
            if(arr[i] > penalty){
                if(arr[i] % penalty == 0){
                    ops += (arr[i] / penalty) - 1;
                }else{
                    ops += (arr[i] / penalty);
                }
            }
        }
        if(ops <= maxOp){
            return true;
        }
        return false;
    }

    public static int solve(int n, int maxOp, int[] arr){
        int ans = -1;
        //maxop is the maximum operation we can performs try
        //arr[i] -> no of balls in ith bag
        // penalty is the maximum no. of ball in a bag try to minimize it
        //lowest penlty we can have it 1
        // highest penalty we can have is the maximum no of ball in a bag present in the array
        int low = 1;
        int high = getMax(arr);

        while(low <= high) {
            int mid = low + (high - low)  / 2;
            //mid is the max Penalty right now
            if(isValid(arr, mid, maxOp)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int getMax(int[] arr){
        int m = Integer.MIN_VALUE;
        for (int j : arr) {
            m = Math.max(m, j);
        }
        return m;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        int[] arr;
        arr= new int[n];
        for(int i = 0; i < n; i++)arr[i]=input.nextInt();
        System.out.println(solve(n,m,arr));
    }
}
