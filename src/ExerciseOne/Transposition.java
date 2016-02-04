package ExerciseOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Michael Johansson(mj223gn) on 2016-02-03.
 */
public class Transposition {

    private final int blockSize = 4;

    public Transposition() {

    }

    public void getInput() throws FileNotFoundException {

        String function;
        String filePath;
        Scanner in = new Scanner(System.in);

        // User input
        do
        {
            System.out.print("Encrypt (e) or Decrypt (d) ?: ");
            function = in.next();
        }
        while(!function.equalsIgnoreCase("d") && !function.equalsIgnoreCase("e"));

        System.out.print("Filepath: ");
        filePath = in.next();

        if(function.equalsIgnoreCase("e")){
            this.TranspositionEncrypt(filePath);
        }
        else if(function.equalsIgnoreCase("d")){
            this.TranspositionDecrypt(filePath);
        }
    }

    public void TranspositionEncrypt(String filePath) throws FileNotFoundException {
        File plainText = new File(filePath);

        //list to save read in characters
        ArrayList<Character> chars1 = new ArrayList<>();
        //file to read text from

        //Scanner to read from file
        Scanner fileScanner = new Scanner(plainText);
        //scanner use delimiter "" so that " " also reads
        fileScanner.useDelimiter("");

        //while scanner has next add the char to the list
        while (fileScanner.hasNext()) {
            chars1.add(fileScanner.next().charAt(0));
        }

        //String that writes adds all chars2 in the list.
        String text = "";
        for (int i = 0; i < chars1.size(); i++)
            text = text + chars1.get(i);

        //we set the size of our blocks

        int blockSize = 4;

        //if the text dont fill upp all slots in the blocks we fill them up with " "
        while (text.length() % blockSize != 0) {
            text = text + " ";
        }
        //list that we add our blocks in. we take out substrings size of the blocks from text and add them.
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < text.length(); i += blockSize) {
            list.add(text.substring(i, i + blockSize));

        }

        //print to file.
        PrintWriter pw = new PrintWriter(plainText.getParent() + "\\Transposition_Encrypt.txt");

        /**we take the first letter i each block in list and add them after each other så (0.0) + (1.0) +..... (n.0)
         * then we take the next row in each block so (0.1) + (1.1)+....(n.1)
         */
        for (int i = 0; i <= blockSize - 1; i++) {
            for (int j = 0; j < list.size(); j++) {
                pw.print(list.get(j).charAt(i));


            }

        }
        pw.close();
    }

    /**
     * DECRYPT
     */

    public void TranspositionDecrypt(String filePath) throws FileNotFoundException {


        //list to hold all read in chars
        ArrayList<Character> chars2 = new ArrayList<>();

        //file to read from
        File cipherText = new File(filePath);
        //scanner to read file
        Scanner fileReader = new Scanner(cipherText);
        fileReader.useDelimiter("");

        PrintWriter pw2 = new PrintWriter(cipherText.getParent()+"\\Transposition_Decrypt.txt");

        //while the reader has next we add the character to the list.
        while (fileReader.hasNext()) {
            chars2.add(fileReader.next().charAt(0));

        }

        //we calculate how many blocks we have.
        int numberOfBlocks = chars2.size() / blockSize;

        /**
         * Then we we start with the first character in each block. så we write position 0 + numberOfBlocks + numberOfBlocks
         * until ...+numberOfBlocks > size of our list. then we start with the second character and so on until we done this with all our
         * blocks.
         */
        for (int i = 0; i < numberOfBlocks; i++) {
            for (int j = i; j < chars2.size(); j += numberOfBlocks) {
                pw2.print(chars2.get(j));
            }
        }
        pw2.close();
    }
}



