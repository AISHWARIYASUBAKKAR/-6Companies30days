package ArshGoyal;

import java.util.Scanner;

/**
 *
 * @author AISHWARIYA
 */
public class SqauresInChessBoard {
 

	// Function to return count of squares;
	static int SqauresInChessBoard(int n)
	{
		// A better way to write n*(n+1)*(2n+1)/6
		return (n * (n + 1) / 2) * (2 * n + 1) / 3;
	}
	
	// Driver code
	public static void main (String[] args)
	{
            Scanner inp=new Scanner(System.in);
            int n=inp.nextInt();
		
		System.out.println("Count of squares is "
						+SqauresInChessBoard(n));
	}
}
