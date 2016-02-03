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

        String function;
        int key = -1;
        String filePath;

        Scanner in = new Scanner(System.in);

        // User input
        do
        {
            System.out.print("Encrypt (e) or Decrypt (d) ?: ");
            function = in.next();
        }
        while(!function.equalsIgnoreCase("d") && !function.equalsIgnoreCase("e"));


        boolean validKey = false;

        // Make sure a valid key is provided
        while (!validKey)
        {
            System.out.print("Enter a key (0-255): ");
            String keyInput = in.next();
            if (keyInput.matches("[0-9]+"))
            {
                key = Integer.parseInt(keyInput);
                if (key >= 0 && key <= 255)
                {
                    validKey = true;
                }
            }
        }

        System.out.print("Filepath: ");
        filePath = in.next();

        File inputFile = new File(filePath);


        // Decryption function
        if (function.equalsIgnoreCase("d"))
        {
            System.out.println("Decrypting to C:\\temp\\decrypt_output.txt");
            PrintWriter decryptOutput = new PrintWriter("C:\\temp\\decrypt_output.txt");
            Scanner fileReader = new Scanner(inputFile);
            fileReader.useDelimiter("");

            while (fileReader.hasNext())
            {
                int charValue = (int) fileReader.next().charAt(0);
                int decryptValue = (charValue - key);

                // adjust Char Value so it's within valid key range, if necessary
                if (decryptValue < 0)
                {
                    decryptValue += 256;
                }
                // For debugging purposes
                //System.out.println(charValue + "goes" + decryptValue);

                // Write to file
                char decryptChar = (char) decryptValue ;
                decryptOutput.print(decryptChar);
            }

            fileReader.close();
            decryptOutput.close();

        }

        // Encryption function
        if (function.equalsIgnoreCase("e"))
        {
            System.out.println("Encrypting to C:\\temp\\encrypt_output.txt");
            PrintWriter encryptOutput = new PrintWriter("C:\\temp\\encrypt_output.txt");

            Scanner fileReader = new Scanner(inputFile);
            fileReader.useDelimiter("");

            while (fileReader.hasNext())
            {
                int charValue = (int) fileReader.next().charAt(0);
                // For debugging purposes
                //System.out.println(charValue + "goes " + ((charValue + key) % 256));

                // Write to file
                char encryptChar = (char) ((charValue + key) % 256 );
                encryptOutput.print(encryptChar);
            }

            fileReader.close();
            encryptOutput.close();
        }

    }
}
