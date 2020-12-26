package RoundRobin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class People {





    public static ArrayList assembleGroup() throws FileNotFoundException {
        Random rand = new Random();
        FileInputStream file = new FileInputStream("src/main/java/RoundRobin/GroupNames");//created a fileStream Object "File" that we will be reading.

        Scanner sc = new Scanner(file);//make a scanner specifically to read that file...NOT SYSTEM.IN

        ArrayList<String> groupNamesList = new ArrayList<>(); // making an arrayList to put all our names in
        while (sc.hasNext()) {
            groupNamesList.add(sc.nextLine());
        }
       return groupNamesList;
    }


}
