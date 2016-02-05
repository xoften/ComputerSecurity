package ExerciseOne;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Encryption/Decryption program with Transposition and Substitution funtionality
 * (Uses the Transposition- and Substitution classes)
 * @author Peter Danielsson (pd222dj@student.lnu.se), Michael Johansson (mj223gn@student.lnu.se)
 *
 */
public class CryptoMain
{
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("***************************");
        System.out.println("*    1337 Crypto v 1.0    *");
        System.out.println("***************************");
        System.out.println();
        System.out.println("Choose an encryption method by entering the corresponding number:");
        System.out.println("1. Transposition");
        System.out.println("2. Substitution");
        System.out.println("3. Exit Program");

        Scanner in = new Scanner(System.in);

        String input;

        // Keep asking until valid input
        do
        {
            System.out.print(": ");
            input = in.next();
        }
        while (!input.equals("1") && !input.equals("2") && !input.equals("3"));


        // Run the corresponding encryption choice or exit program
        try
        {
            if (input.equals("1"))
            {
                Transposition trans = new Transposition();
                trans.getInput();
            }
            else if (input.equals("2"))
            {
                Substitution sub = new Substitution();
                sub.getInput();
            }
            else
            {
                System.out.println("Exiting program...");
            }
        }
        catch(FileNotFoundException e)
        {
            System.err.println("File not found! Exiting Program...");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
