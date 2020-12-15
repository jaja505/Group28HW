package Stephanie;

import Population.Person;
import Population.Population;

import java.util.ArrayList;
import java.util.Arrays;

public class Exs1 {

    public static void main(String[] args) {


        ArrayList<Person> allPeople = new ArrayList<>(Arrays.asList(Population.createPopulation(200)));

        ArrayList<Person> singlePeople = new ArrayList<>();
        singlePeople.addAll(allPeople);
        singlePeople.removeIf(p -> (!p.isMarried));
        System.out.println("List of Single People: " + singlePeople);

        System.out.println("==================================================================");

        ArrayList<Person> parents = new ArrayList<>();
        parents.addAll(allPeople);
        parents.removeIf(p -> p.numbOfChildren < 0);
        System.out.println("List of Parents: " + parents);

        System.out.println("==================================================================");

        ArrayList<Person> noEngineers = new ArrayList<>();
        noEngineers.addAll(allPeople);
        noEngineers.removeIf(p -> p.occupation.equalsIgnoreCase("software engineer"));

        for(Person each: noEngineers){
            if(noEngineers.contains(each.childId)){
                noEngineers.removeAll(noEngineers);
            }
            if(noEngineers.contains(each.spouseId)){
                noEngineers.removeAll(noEngineers);
            }
        }

        System.out.println("List of No Engineers: " + noEngineers);


    /*
    1)  a - Create ArrayList of Person type and name it singlePeople
        b - Add all single people from allPeople to singlePeople (hint: isMarried = false)

    2)  a - Create ArrayList of Person type and name it parents
        b - Add all people that have kids from allPeople to parents (hint: numbOfChildren > 0)

    3)  a - Create ArrayList of Person type and name it noEngineers
        b - Add all people from allPeople to noEngineers
        c - remove all people that are "software engineer" (hint: occupation.equals("software engineer"))
        Very opnnntional:
        d - if any relatives associated remove them too. (hint: look out for spouseId and childId)

    4)  a - change occupation from "doctor" to "Artist" in allPeople
     */
    }
}
