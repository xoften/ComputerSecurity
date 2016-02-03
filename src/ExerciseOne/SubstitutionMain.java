package ExerciseOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Peter Danielsson
 *         pd222dj@student.lnu.se
 */
public class SubstitutionMain
{
    public static void main(String[] args) throws FileNotFoundException {

        int key = 10;

        File originalText = new File("C:\\temp\\text.txt");
        Scanner in = new Scanner(originalText);
        in.useDelimiter("");
        PrintWriter encrypt = new PrintWriter("C:\\temp\\encryption.txt");
        while (in.hasNext())
        {
            int charValue = (int) in.next().charAt(0);
            char encryptChar = (char) (charValue + key);
            encrypt.print(encryptChar);
        }

        in.close();
        encrypt.close();


        Scanner in2 = new Scanner(new File("C:\\temp\\encryption.txt"));


        PrintWriter decrypt = new PrintWriter("C:\\temp\\decryption.txt");

        in2.useDelimiter("");

        while (in2.hasNext())
        {
            int charValue = (int) in2.next().charAt(0);
            char decryptChar = (char) (charValue - key);
            decrypt.print(decryptChar);
        }

        in2.close();
        decrypt.close();
    }
}
