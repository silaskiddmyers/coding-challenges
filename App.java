import java.util.Scanner;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void evenOrOdd()
    {
        System.out.print("Even or Odd? enter a test number: ");
        Scanner scan = new Scanner(System.in);
        int in = scan.nextInt();
        if(in % 2 == 0) {
            System.out.println("Even");
        }
        else {
            System.out.println("Odd");
        }
        scan.close();
    }

/*     public static Boolean isPrime(int testNum)
    {
        for(int i = 2; i < testNum/2;i++) {
            if (testNum % i == 0) {
                return false;
            }
        }
        return true;
    } */

    public static Boolean isPrime(int testNum, int curr)
    {
        if(curr == 1)
            return true;
        if(testNum % curr  == 0)
            return false;
        return isPrime(testNum, curr - 1);
    }
    
    public static void main( String[] args )
    {
        //App.evenOrOdd();
        System.out.print("Is it prime? enter a test number: ");
        Scanner scan = new Scanner(System.in);
        int in = scan.nextInt();
        System.out.println(App.isPrime(in, in/2 + 1));
        scan.close();
    }
}
