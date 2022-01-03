Question Link:https://practice.geeksforgeeks.org/problems/print-anagrams-together/1/
Given an array of strings, return all groups of strings that are anagrams. The groups must be created in order of their appearance in the original array. 
Look at the sample case for clarification.
    
Example 1:
Input:
N = 5
words[] = {act,god,cat,dog,tac}
Output: 
god dog
act cat tac
Explanation:
There are 2 groups of
anagrams "god", "dog" make group 1.
"act", "cat", "tac" make group 2.
    
Example 2:
Input:
N = 3
words[] = {no,on,is}
Output: 
no on
is
Explanation:
There are 2 groups of
anagrams "no", "on" make group 1.
"is" makes group 2. 

Your Task:
The task is to complete the function Anagrams() that takes a list of strings as input and returns a list of groups such that each group consists of all the strings that are 
anagrams.


Expected Time Complexity: O(N*|S|*log|S|), where |S| is the length of the strings.
Expected Auxiliary Space: O(N*|S|), where |S| is the length of the strings.


Constraints:
1<=N<=100

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class AnagramsTogether {
    
  static final int NO_OF_CHARS = 26;
    
    // Class to represent a Trie Node
    static class TrieNode
    {
        boolean isEnd;  // indicates end of word
        
        // 26 slots each for 'a' to 'z'
        TrieNode[] child = new TrieNode[NO_OF_CHARS];
        
        // head of the index list
        LinkedList<Integer> head; 
        
        // constructor
        public TrieNode() 
        {
            isEnd = false;
            head = new LinkedList<>();
            for (int i = 0; i < NO_OF_CHARS; ++i)
                child[i] = null;
        }
    }
     
    // A utility function to insert a word to Trie
    static TrieNode insert(TrieNode root,String word,
                                int index, int i)
    {
        // Base case
        if (root == null)
        {
            root = new TrieNode();
        }
        
        if (i < word.length() )
        {
            int index1 = word.charAt(i) - 'a';
            root.child[index1] = insert(root.child[index1],
                                       word, index, i+1 );
        }
        else  // If end of the word reached
        {
            // Insert index of this word to end of
            // index linked list
            if (root.isEnd == true)
            {
                root.head.add(index);
            }
            else // If Index list is empty
            {
                root.isEnd = true;
                root.head.add(index);
            }
        }
        return root;
    }

    // This function traverses the built trie. When a leaf 
    // node is reached, all words connected at that leaf 
    // node are anagrams. So it traverses the list at leaf  
    // node and uses stored index to print original words
    static void printAnagramsUtil(TrieNode root, 
                                      String wordArr[])
    {
        if (root == null)
            return;
     
        // If a lead node is reached, print all anagrams
        // using the indexes stored in index linked list
        if (root.isEnd)
        {
            // traverse the list
            for(Integer pCrawl: root.head)
                System.out.println(wordArr[pCrawl]);
        }
     
        for (int i = 0; i < NO_OF_CHARS; ++i)
            printAnagramsUtil(root.child[i], wordArr);
    }
     
    // The main function that prints all anagrams together. 
    // wordArr[] is input sequence of words.
    static void printAnagramsTogether(String wordArr[], 
                                               int size)
    {
        // Create an empty Trie
        TrieNode root = null;
     
        // Iterate through all input words
        for (int i = 0; i < size; ++i)
        {
            // Create a buffer for this word and copy the
            // word to buffer
            char[] buffer = wordArr[i].toCharArray();
           
            // Sort the buffer
            Arrays.sort(buffer);
     
            // Insert the sorted buffer and its original
            // index to Trie
            root = insert(root, new String(buffer), i, 0);
            
        }
        
        // Traverse the built Trie and print all anagrams
        // together
        printAnagramsUtil(root, wordArr);
    }
     
    // Driver program to test above functions
    public static void main(String args[])
    {
        
        Scanner inp=new Scanner(System.in);
        int n=inp.nextInt();
        String arr[]=new String[n];
        for(int i=0;i<n;i++){
            arr[i]=inp.next();
        }
        printAnagramsTogether(arr, n);
    }
}
