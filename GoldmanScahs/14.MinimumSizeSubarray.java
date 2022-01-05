package ArshGoyal;

import java.util.Scanner;

/**
 *
 * @author AISHWARIYA
 */
public class MinimumSizeSubarray {
   
    // Returns length of smallest subarray with sum greater than x.
    // If there is no subarray with given sum, then returns n+1
    static int smallestSubWithSum(int arr[], int n, int x)
    {
        //  Initialize length of smallest subarray as n+1
        int min_len = n + 1;

        // Pick every element as starting point
        for (int start = 0; start < n; start++)
        {
            // Initialize sum starting with current start
            int curr_sum = arr[start];

            // If first element itself is greater
            if (curr_sum > x)
                return 1;

            // Try different ending points for curremt start
            for (int end = start + 1; end < n; end++)
            {
                // add last element to current sum
                curr_sum += arr[end];

                // If sum becomes more than x and length of
                // this subarray is smaller than current smallest
                // length, update the smallest length (or result)
                if (curr_sum > x && (end - start + 1) < min_len)
                    min_len = (end - start + 1);
            }
        }
        return min_len;
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
        Scanner inp=new Scanner(System.in);
        int n1=inp.nextInt();
        int arr1[] = new int[n1];
        for(int i=0;i<n1;i++){
            arr1[i]=inp.nextInt();
        }
        int x = inp.nextInt();
       
        int res1 = smallestSubWithSum(arr1, n1, x);
        if (res1 == n1+1)
           System.out.println("Not Possible");
        else
           System.out.println(res1);

        int n2=inp.nextInt();
        int arr2[] = new int[n2];
        for(int i=0;i<n2;i++){
            arr2[i]=inp.nextInt();
        }
       
        int x1 =inp.nextInt();
        int res2 = smallestSubWithSum(arr2, n2, x);
        if (res2 == n2+1)
           System.out.println("Not Possible");
        else
           System.out.println(res2);
        int n3=inp.nextInt();
        int arr3[] = new int[n3];
        for(int i=0;i<n3;i++){
            arr3[i]=inp.nextInt();
        }
       
        int x2 = inp.nextInt();
        int res3 = smallestSubWithSum(arr3, n3, x);
        if (res3 == n3+1)
           System.out.println("Not Possible");
        else
           System.out.println(res3);
    }
}

