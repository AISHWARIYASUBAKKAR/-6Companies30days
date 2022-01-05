import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
/**
 *
 * @author AISHWARIYA
 */
public class RepeatMiss {
    public static void main(String[] args)
{
Scanner inp=new Scanner(System.in);
int n=inp.nextInt();
int[] arr = new int[n];
for(int i=0;i<n;i++){
    arr[i]=inp.nextInt();
}

Map<Integer, Boolean> numberMap
= new HashMap<>();

int max = arr.length;

for (Integer i : arr) {

if (numberMap.get(i) == null) {
numberMap.put(i, true);
}
else {
System.out.println("Repeating = " + i);
}
}
for (int i = 1; i <= max; i++) {
if (numberMap.get(i) == null) {
System.out.println("Missing = " + i);
}
}
}
}


