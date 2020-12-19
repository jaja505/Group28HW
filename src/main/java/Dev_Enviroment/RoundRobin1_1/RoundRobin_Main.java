package Dev_Enviroment.RoundRobin1_1;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class RoundRobin_Main {

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<People> group = People.assembleGroup();
        System.out.println(group);


    }
}
