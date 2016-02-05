package ExerciseOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/** Provides basic substitution encryption functionality with a 8-bit key (256 different keys)
 * @author Peter Danielsson
 * pd222dj@student.lnu.se
 */
public class Substitution
{

    /**
     * Constructor, no arguments given
     * Nothing to initialize
     */
    public Substitution() throws FileNotFoundException
    {
    }

    /**
     * Receive all necessary input from user and call the corresponding decrypt/encrypt method
     * @throws FileNotFoundException
     */
    public void getInput() throws FileNotFoundException {

        // Create new Scanner object for user input
        Scanner in = new Scanner(System.in);

        // Variables for grabbing user input and calling the desired decrypt/encrypt method
        String function;
        String filePath;
        int key = -1;

        // Keep asking until a valid function has been provided
        do {
            System.out.print("Encrypt (e) or Decrypt (d) ?: ");
            function = in.next();
        }
        while (!function.equalsIgnoreCase("d") && !function.equalsIgnoreCase("e"));


        boolean validKey = false;

        // Keep asking until a valid key has been provided
        while (!validKey) {
            System.out.print("Enter a key (0-255): ");
            String keyInput = in.next();
            if (keyInput.matches("[0-9]+")) {
                key = Integer.parseInt(keyInput);
                if (key >= 0 && key <= 255) {
                    validKey = true;
                }
            }
        }

        // Ask for filepath
        System.out.print("Filepath: ");
        filePath = in.next();

        // Call corresponding encrypt/decrypt method
        if (function.equalsIgnoreCase("d"))
        {
            this.decrypt(filePath, key);
        }
        else if (function.equalsIgnoreCase("e"))
        {
            this.encrypt(filePath, key);
        }
    }

    /**
     *  Decrypt a file
     *  Creates a new file for decryption output named decrypt_output.txt in same directory as input file
     * @param filePath Full path to input file to decrypt
     * @param key decryption key
     * @throws FileNotFoundException
     */
    public void decrypt(String filePath, int key) throws FileNotFoundException
    {
        File inputFile = new File(filePath);

        Scanner fileReader = new Scanner(inputFile);
        fileReader.useDelimiter("");

        String inputPath = inputFile.getParent();
        System.out.println("Decrypting to " + inputPath + "\\decrypt_output.txt");
        PrintWriter decryptOutput = new PrintWriter(inputPath + "\\decrypt_output.txt");


        // Process all characters in file
        while (fileReader.hasNext()) {
            int charValue = (int) fileReader.next().charAt(0);
            int decryptValue = (charValue - key);

            // adjust Char Value so it's within valid key range, if necessary
            if (decryptValue < 0) {
                decryptValue += 256;
            }
            // For debugging purposes
            //System.out.println(charValue + "goes" + decryptValue);

            // Write to file
            char decryptChar = (char) decryptValue;
            decryptOutput.print(decryptChar);
        }

        fileReader.close();
        decryptOutput.close();

    }


    /**
     * Encrypt a file
     * Creates a new file for decryption output named encrypt_output.txt in same directory as input file
     * @param filePath Full path to input file to decrypt
     * @param key Encryption key
     * @throws FileNotFoundException
     */
    public void encrypt(String filePath, int key) throws FileNotFoundException
    {
        File inputFile = new File(filePath);
        Scanner fileReader = new Scanner(inputFile);
        fileReader.useDelimiter("");

        String inputPath = inputFile.getParent();
        System.out.println("Encrypting to " + inputPath + "\\encrypt_output.txt");
        PrintWriter encryptOutput = new PrintWriter(inputPath + "\\encrypt_output.txt");

        // Process all characters in file
        while (fileReader.hasNext()) {
            int charValue = (int) fileReader.next().charAt(0);
            // For debugging purposes
            //System.out.println(charValue + "goes " + ((charValue + key) % 256));

            // Write to file
            char encryptChar = (char) ((charValue + key) % 256);
            encryptOutput.print(encryptChar);
        }

        fileReader.close();
        encryptOutput.close();
    }

    /**
     * Print the first line of text in text file
     * @param filePath Full path to input file do decrypt
     * @throws FileNotFoundException
     */
    public void printOneFileLine(String filePath) throws FileNotFoundException {

        File inputFile = new File(filePath);
        Scanner in = new Scanner(inputFile);
        System.out.println(in.nextLine());

    }

}
