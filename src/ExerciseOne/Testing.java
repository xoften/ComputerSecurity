package ExerciseOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Peter Danielsson on 2016-02-03.
 * pd222dj@student.lnu.se
 */
public class Testing {
    public static void main(String[] args) throws FileNotFoundException{

        System.out.println((int) '*');
        System.out.println((int) 'M');

        System.out.println((int) ' ');
        System.out.println((int) '#');

        System.out.println((int) 's');

        Scanner in = new Scanner(new File("C:\\temp\\john.txt"));

        /*String line = in.nextLine();
        for (int i = 0; i < line.length(); i++)
        {
            System.out.println("Char: " + line.charAt(i) + " Value: " + (int) line.charAt(i));
        }
*/

        Substitution sub = new Substitution();
        sub.decrypt("C:\\temp\\john.txt", -60);
        sub.printOneFileLine("C:\\temp\\decrypt_output.txt");
    }

}
