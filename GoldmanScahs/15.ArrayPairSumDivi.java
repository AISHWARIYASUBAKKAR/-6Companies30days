QuestionLink:https://practice.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem3257/1
 import java.util.HashMap;
import java.util.Scanner;
/**
 *
 * @author AISHWARIYA
 */
public class ArrayPairSumDivisibilty {
   

// Returns true if arr[0..n-1] can be divided into pairs
// with sum divisible by k.
static boolean canPairs(int ar[], int k)
{
// An odd length array cannot be divided into pairs
if (ar.length % 2 == 1)
return false;

// Create a frequency array to count occurrences
// of all remainders when divided by k.
HashMap<Integer, Integer> hm = new HashMap<>();

// Count occurrences of all remainders
for (int i = 0; i < ar.length; i++) {
int rem = ((ar[i] % k) + k) % k;
if (!hm.containsKey(rem)) {
hm.put(rem, 0);
}
hm.put(rem, hm.get(rem) + 1);
}

// Traverse input array and use freq[] to decide
// if given array can be divided in pairs
for (int i = 0; i < ar.length; i++) {
// Remainder of current element
int rem = ((ar[i] % k) + k) % k;

// If remainder with current element divides
// k into two halves.
if (2 * rem == k) {
// Then there must be even occurrences of
// such remainder
if (hm.get(rem) % 2 == 1)
return false;
}

// If remainder is 0, then there must be two
// elements with 0 remainder
else if (rem == 0) {
// Then there must be even occurrences of
// such remainder
if (hm.get(rem) % 2 == 1)
return false;
}

// Else number of occurrences of remainder
// must be equal to number of occurrences of
// k - remainder
else {
if (hm.get(k - rem) != hm.get(rem))
return false;
}
}
return true;
}

// Driver code
public static void main(String[] args)
{
    Scanner inp=new Scanner(System.in);
    int n=inp.nextInt();
    int arr[] = new int[n];

    
    for(int i=0;i<n;i++){
        arr[i]=inp.nextInt();
    }
int k = inp.nextInt();

// Function call
boolean ans = canPairs(arr, k);
if (ans)
System.out.println("True");
else
System.out.println("False");
}
}

