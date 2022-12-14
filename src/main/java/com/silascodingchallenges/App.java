package com.silascodingchallenges;

import com.silascodingchallenges.challenges.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */

//cd Desktop/Revature/coding-challenges
//git add src
//git commit -m "added new challenge"
//git push

//cd Desktop/Revature/coding-challenges;git add src;git commit -m "added new challenge";git push

public class App 
{
    public static void evenOrOdd(int in)
    {
        if(in % 2 == 0) {
            System.out.println("Even");
        }
        else {
            System.out.println("Odd");
        }
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

    public static String pigLatin(String word)
    {
        //String builder and string buffer are better for times where we know we'll be manipulating a string a lot

        //String is immutable

        //StringBufferis m,utabnle and thread safe

        //StringBuilder is mutable and not thread safe- most efficient but don't use with threads unless using Java constructs to make it safe

        /*
         * String temp = word.substring(1)
         * StringBuilder sb = new StringBuilder(word);
         * sb.deleteCharAt(0);
         * sb.append(word.charAt(0));
         * sb.append("ay");
         * return ab.toString();
         */
        return word.substring(1).concat(word.charAt(0) + "ay");//not super readable I suppose
    }
    
    public static void main( String[] args )
    {
        Scanner scan = new Scanner(System.in);
        String select;
        Boolean running = true;
        
        while(running) {
            System.out.println("Welcome to Silas' coding challenges! Please select an option below.\n1) Even or Odd\n2) Is it prime?\n3) Pig Latin!\n4) Pig Latin 2.0!\n5) Sort an array\n6) FizzBuzz\n0) Close");
            select = scan.nextLine();
            switch(select)
            {
                case "1":
                    System.out.print("Even or Odd? enter a test number: ");
                    int in = scan.nextInt();
                    App.evenOrOdd(in);
                    scan.nextLine();
                    scan.nextLine();
                    break;
                case "2":        
                    System.out.print("Is it prime? enter a test number: ");
                    int inp = scan.nextInt();
                    System.out.println(App.isPrime(inp, inp/2 + 1));
                    scan.nextLine();
                    scan.nextLine();
                    break;
                case "3":
                    System.out.println("Convert a word to pig latin!");
                    String pig = scan.nextLine();
                    System.out.println(App.pigLatin(pig)); 
                    scan.nextLine();
                    break;
                case "4":
                    PigLatin pig2 = new PigLatin();
                    System.out.println("Convert a sentence to pig latin!\n");
                    System.out.println("Enter a sentence to be converted to Pig Latin below. The only valid punctuation is at the end of the sentence.\n");
                    String line = scan.nextLine();
                    System.out.println(pig2.encode(line));
                    scan.nextLine();
                    break;
                case "5":
                    
                    SimpleSort sort = new SimpleSort();
                    List<Integer> toSort = new ArrayList<Integer>();
                    System.out.println("Enter 5 numbers to be sorted");
                    for(int i = 0; i <5; i++) {
                        toSort.add(scan.nextInt());
                    }
                    scan.nextLine();
                    scan.nextLine();
                    System.out.println(sort.sort(toSort));
                    break;
                case "6":
                    FizzBuzz fb = new FizzBuzz();
                    System.out.println("Enter an integer and see what happens!");
                    System.out.println(fb.exec(scan.nextInt()));
                    scan.nextLine();
                    scan.nextLine();
                    break;
                case "0":
                    running = false;
                    scan.close();
                    System.out.println("See ya later");
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }
        
    }
}
