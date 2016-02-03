package ExerciseOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Michael Johansson(mj223gn) on 2016-02-03.
 */
public class TranspositionMain {


    public static void main(String[] args) throws FileNotFoundException {

        //File file = new File("C:\\User\\Michael\\text.txt");
        //Scanner fileScanner = new Scanner(file);

        String text = "We are ready";

        while(text.length()%4 != 0){
            text = text + " ";
        }

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < text.length(); i += 4)
            list.add(text.substring(i, i + 4));
        System.out.println(list);


        for (int i = 0; i <= list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {

                System.out.print(list.get(j).substring(i, i + 1));

            }
        }
    }


}
