package ExerciseOne;

import java.io.FileNotFoundException;

/**
 * @author Peter Danielsson
 *         pd222dj@student.lnu.se
 */
public class SubstitutionMain
{
    public static void main(String[] args) throws FileNotFoundException {
        Substitution sub = new Substitution();

        sub.decrypt("C:\\temp2\\encrypt_output.txt", 10);
    }

}
