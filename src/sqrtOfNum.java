import java.util.Scanner;

public class sqrtOfNum {

    public static long sqrtRoot(int n){
        long potentialNum = 1;
        long l = 1;
        long r = n;
        while(l <= r){
            long mid = l + (r - l) / 2;
            if(mid * mid > n){
                r = mid - 1;
            }
            if(mid * mid < n){
                potentialNum = mid;
                l = mid + 1;
            }
            if(mid * mid  == n){
                return mid;
            }
        }
        return potentialNum;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(sqrtRoot(n));
    }
}
