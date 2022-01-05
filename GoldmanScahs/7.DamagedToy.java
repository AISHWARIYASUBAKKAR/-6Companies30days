QuestionLink:https://www.geeksforgeeks.org/distributing-m-items-circle-size-n-starting-k-th-position/

import java.util.Scanner;

/**
 *
 * @author AISHWARIYA
 */
public class DamagedToy {
  
	// n ==> Size of circle
	// m ==> Number of items
	// k ==> Initial position
	static int lastPosition(int n, int m, int k)
	{

		// n - k + 1 is number of positions
		// before we reach beginning of circle
		// If m is less than this value, then
		// we can simply return (m-1)th position
		if (m <= n - k + 1)
			return m + k - 1;

		// Let us compute remaining items before
		// we reach beginning.
		m = m - (n - k + 1);

		// We compute m % n to skip all complete
		// rounds. If we reach end, we return n
		// else we return m % n
		return (m % n == 0) ? n : (m % n);
	}

	// Driver Program to test above function
	public static void main(String arg[])
	{
            Scanner inp=new Scanner(System.in);
		int n = inp.nextInt();
		int m = inp.nextInt();
		int k = inp.nextInt();
		System.out.print(lastPosition(n, m, k));
	}
}

