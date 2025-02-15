//Task 1 : Write a Java program to copy the alternative elements in the array.
import java.util.*;
class task1{
    public static void main(String[] args) {
        ArrayList <Integer> arr = new ArrayList<>();
        ArrayList <Integer> copyArray = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your array size: ");
        int size = sc.nextInt();
        System.out.println("Enter your Array: ");
        for (int i=0;i<size;i++){
            arr.add(sc.nextInt());
            if(i%2==0){
                copyArray.add(arr.get(i));
            }
        }
        System.out.println("The copy array is: ");
        System.out.println(copyArray);        
    }
}