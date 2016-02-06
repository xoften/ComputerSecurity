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

        sub.bruteForce("C:\\temp\\Ola.txt", "Secret");

    }
}
