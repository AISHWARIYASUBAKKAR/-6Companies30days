import java.util.Random;
import java.util.Arrays;
public class MyClass {
    public static void main(String args[]) {
      int arr[]=new int[50];
      Random r=new Random();
      for(int i=0;i<arr.length;i++){
          arr[i]=r.nextInt(49);
      }
      int max[]=new int[10];
      //int j=1;
      int flag=0;
      int hold=arr[0];
      int max_so_far=arr[0]; //this will basically decrease over time
      for(int j=1;j<arr.length;j++){
          if(arr[j]>hold){
              max_so_far=arr[j];
              max[flag]=arr[j];
              //hold=arr[j];
              
          }
      }
      flag++;
      for(int j=1;j<arr.length;j++){
          if(arr[j]<max_so_far && arr[j]<hold){
              max_so_far=arr[j];
              max[flag]=arr[j];
              hold=arr[j];
              flag++;
          }
          if(flag>9){
              break;
          }
      }
      System.out.println("Initial Array\n");
      for(int i=0;i<arr.length;i++){
          System.out.print(arr[i]+" ");
      }
      System.out.println();
      for(int i=0;i<10;i++){
          System.out.println(max[i]+" ");
      }
      Arrays.sort(arr);
      Arrays.sort(max);
      System.out.println("\nSorted Array\n");
      for(int i=0;i<arr.length;i++){
          System.out.print(arr[i]+" ");
      }
      
      System.out.println();
      for(int i=0;i<=9;i++){
          System.out.println(max[i]+" ");
      }
    }
}