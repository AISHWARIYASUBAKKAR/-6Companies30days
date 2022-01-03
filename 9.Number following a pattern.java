QuestionLink:https://practice.geeksforgeeks.org/problems/number-following-a-pattern3126/1
import java.util.Scanner;


public class OverlappingRectangle {
    static class Point {

        int x, y;
    }

// Returns true if two rectangles (l1, r1) and (l2, r2) overlap 
 static  boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
        
           // To check if either rectangle is actually a line
          // For example :  l1 ={-1,0}  r1={1,1}  l2={0,-1}  r2={0,1}
   
          if (l1.x == r1.x || l1.y == r1.y || l2.x == r2.x || l2.y == r2.y) 
            {
                    // the line cannot have positive overlap
                return false;
            }
   
   
           // If one rectangle is on left side of other 
        if (l1.x >= r2.x || l2.x >= r1.x) {
            return false;
        }

        // If one rectangle is above other 
        if (r1.y >= l2.y || r2.y >= l1.y) {
            return false;
        }

        return true;
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        Point l1 = new Point(),r1 = new Point(),
                l2 = new Point(),r2 = new Point();
        Scanner inp=new Scanner(System.in);
        
        l1.x=inp.nextInt();
        l1.y=inp.nextInt();
        r1.x=inp.nextInt();
        r1.y=inp.nextInt();
        l2.x=inp.nextInt();
        l2.y=inp.nextInt();
        r2.x=inp.nextInt();
        r2.y=inp.nextInt();

        if (doOverlap(l1, r1, l2, r2)) {
            System.out.println("Rectangles Overlap");
        } else {
            System.out.println("Rectangles Don't Overlap");
        }
    }
}
    

