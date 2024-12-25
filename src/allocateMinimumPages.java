import java.util.*;

class Solution{

    public int noOfStudents(int[] arr, int max){
        int students = 1;
        int currPages = 0;
        for(int i = 0; i < arr.length; ++i) {
            if (currPages + arr[i] <= max) {
                currPages += arr[i];
            } else {
                students++;
                currPages = arr[i];
            }
        }
        return students;
    }

    public int MinimumPages(int[] arr, int k){
        if(k > arr.length) return -1;
        if(k == 1) return sumOfPages(arr);
        if(k == arr.length) return getMax(arr);

        int low = getMax(arr);
        int high = sumOfPages(arr);
        int result = -1;
        //Binary Search on Answer
        while(low <= high){
            int mid = low + (high - low) / 2;
            // mid is the maximum pages one student can read
            // first we will get the students req to distribite the books using the mid
            int students = noOfStudents(arr, mid);

            if(students > k){
                low = mid + 1;
            }else {
                result = mid;
                high = mid - 1;
            }
        }
        return result;
    }
    public int sumOfPages(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; ++i){
            sum += arr[i];
        }
        return sum;
    }

    public int getMax(int[] arr){
        int m = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; ++i){
            if(arr[i] > m){
                m = arr[i];
            }
        }
        return m;
    }

}

public class allocateMinimumPages {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int B = sc.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++)
            A[i] = sc.nextInt();

        Solution Obj = new Solution();
        System.out.println(Obj.MinimumPages(A,B));
    }
}

//4 2
//12 34 67 90
