Question Link:https://practice.geeksforgeeks.org/problems/ugly-numbers2254/1/
import java.util.Scanner;


public class UglyNumber {
    static int Div(int x,int y){ 
        while(x%y==0) 
            x=x/y; 
        return x; 
    } 
    /* Function to get the ugly 
       number*/
    static int uglyNo(int n){ 
        int i=1; 
        int count=1;  
        while(n>count){ 
            i++; 
            int p=i;
            p=Div(p,2); 
            p=Div(p,3); 
            p=Div(p,5); 
            if(p==1){ 
                count++;
            }
        } 
        return i; 
    } 
    public static void main(String args[]){ 
        Scanner inp=new Scanner(System.in);
        int n=inp.nextInt();
        int num = uglyNo(n); 
        System.out.println(num); 
    } 
}
    
