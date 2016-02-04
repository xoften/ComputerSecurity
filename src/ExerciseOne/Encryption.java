package ExerciseOne;

import java.util.Scanner;

/**
 * Created by Michael Johansson(mj223gn) on 2016-02-03.
 */
public class Encryption
{
    public static void main(String[] args)
    {
        String function;

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to this encryption program!");

        System.out.println("Choose which method to encrypt with: (s) for substitution and (t) for transposition: ");

        do
        {
            System.out.println("Choose which method to encrypt with: (s) for substitution and (t) for transposition: ");
            function = input.next();
        }
        while(!function.equalsIgnoreCase("s") && !function.equalsIgnoreCase("t"));


    }
}
