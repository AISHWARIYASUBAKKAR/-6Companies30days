QuestionLink:https://practice.geeksforgeeks.org/problems/count-the-subarrays-having-product-less-than-k1708/1/

import java.util.Scanner;

/**
 *
 * @author AISHWARIYA
 */
public class ProductCount {
 
	static int countsubarray(int array[], int n, int k)
	{
		int count = 0;
		int i, j, mul;

		for (i = 0; i < n; i++) {

			// Counter for single element
			if (array[i] < k)
				count++;

			mul = array[i];

			for (j = i + 1; j < n; j++) {

				// Multiple subarray
				mul = mul * array[j];

				// If this multiple is less
				// than k, then increment
				if (mul < k)
					count++;
				else
					break;
			}
		}

		return count;
	}

	// Driver Code
	public static void main(String args[])
	{
            Scanner inp=new Scanner(System.in);
            int n=inp.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=inp.nextInt();
            }
            
  
		int k = inp.nextInt();
		

		int count = countsubarray(arr, n, k);
		System.out.print(count);
	}
}

