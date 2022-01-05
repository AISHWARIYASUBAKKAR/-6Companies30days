import java.util.Scanner;

/**
 *
 * @author AISHWARIYA
 */
public class GreatestCommonDiv {
    
 

	// Function that finds gcd of 2 strings
	static String gcd(String str1, String str2)
	{
		// If str1 length is less than
		// that of str2 then recur
		// with gcd(str2, str1)
		if (str1.length() < str2.length()) {
			return gcd(str2, str1);
		}

		// If str1 is not the
		// concatenation of str2
		else if (!str1.startsWith(str2)) {
			return "";
		}

		else if (str2.isEmpty()) {

			// GCD string is found
			return str1;
		}
		else {

			// Cut off the common prefix
			// part of str1 & then recur
			return gcd(str1.substring(str2.length()),
					str2);
		}
	}

	// Function to find GCD of array of
	// strings
	static String findGCD(String arr[], int n)
	{
		String result = arr[0];

		for (int i = 1; i < n; i++) {
			result = gcd(result, arr[i]);
		}

		// Return the GCD of strings
		return result;
	}

	// Driver Code
	public static void main(String[] args)
	{
		// Given array of strings
            Scanner inp=new Scanner(System.in);
            int n=inp.nextInt();
		String arr[]= new String[n];
		for(int i=0;i<n;i++){
                    arr[i]=inp.next();
                }

		// Function Call
		System.out.println(findGCD(arr, n));
	}
}


