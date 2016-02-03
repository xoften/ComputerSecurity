package ExerciseOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Michael Johansson(mj223gn) on 2016-02-03.
 */
public class TranspositionMain {


    public static void main(String[] args) throws FileNotFoundException {
/**
 * ENCRYPT
 */ArrayList<Character> chars1 = new ArrayList<>();
        File plainText = new File("C:\\Users\\Michaels\\text.txt");
        Scanner fileScanner = new Scanner(plainText);
        fileScanner.useDelimiter("");

        while (fileScanner.hasNext()) {
            char lineE = fileScanner.next().charAt(0);
            System.out.print(lineE);
            chars1.add(lineE);

            String text = "";
            for (int i = 0; i < chars1.size(); i++)
                text = text + chars1.get(i);

            while (text.length() % 4 != 0) {
                text = text + " ";
            }

            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < text.length(); i += 4)
                list.add(text.substring(i, i + 4));
            System.out.println(list);


            PrintWriter pw = new PrintWriter("C:\\Users\\Michaels\\Ciphertext.txt");

            for (int i = 0; i <= 3; i++) {
                for (int j = 0; j < list.size(); j++) {
                    pw.print(list.get(j).charAt(i));
                    System.out.print(list.get(j).charAt(i));

                }

            }
            System.out.println();
            pw.close();

            /**
             * DECRYPT
             */
            ArrayList<Character> chars = new ArrayList<>();

            File cipherText = new File("C:\\Users\\Michaels\\Ciphertext.txt");
            Scanner fileReader = new Scanner(cipherText);

            fileReader.useDelimiter("");
            PrintWriter pw2 = new PrintWriter("C:\\Users\\Michaels\\PlainText.txt");

            while (fileReader.hasNext()) {
                char line = fileReader.next().charAt(0);
                System.out.print(line);
                chars.add(line);

            }
            System.out.println();
            for (Character charset : chars) {
                System.out.print(charset);
            }

            int numberOfBlocks = chars.size() / 4;

            for (int i = 0; i < numberOfBlocks; i++) {
                for (int j = i; j < chars.size(); j += numberOfBlocks) {
                    pw2.print(chars.get(j));
                }
            }
            pw2.close();
        }

    }
}
