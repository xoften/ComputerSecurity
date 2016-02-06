package ExerciseOne;

import java.io.FileNotFoundException;

/**
 * Test-program for the Substitution class
 * Created by Peter Danielsson on 2016-02-06.
 * pd222dj@student.lnu.se
 */
public class SubstitutionMain
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Substitution sub = new Substitution();

        //System.out.println(sub.readOneFileLine("C:\\temp\\decrypt_output.txt").contains("Secret"));
        //sub.decrypt("C:\\temp\\Ola.txt", 3);
        sub.bruteForce("C:\\temp\\Ola.txt", "Secret");

    }
}
