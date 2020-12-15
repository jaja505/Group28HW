package Atilla;

import Population.Person;
import Population.Population;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeWork1 {

    public static void main(String[] args) {

        ArrayList<Person> allPeople = new ArrayList<>(Arrays.asList(Population.createPopulation(20)));


    /*
    1)  a - Create ArrayList of Person type and name it singlePeople
        b - Add all single people from allPeople to singlePeople (hint: isMarried = false)

    2)  a - Create ArrayList of Person type and name it parents
        b - Add all people that have kids from allPeople to parents (hint: numbOfChildren > 0)

    3)  a - Create ArrayList of Person type and name it noEngineers
        b - Add all people from allPeople to noEngineers
        c - remove all people that are "software engineer" (hint: occupation.equals("software engineer"))
        Very optional:
        d - if any relatives associated remove them too. (hint: look out for spouseId and childId)

    4)  a - change occupation from "doctor" to "Artist" in allPeople
     */


        ArrayList<Person> singlePerson = new ArrayList<>();

        for (Person each: allPeople) {

            if(!each.isMarried){

                singlePerson.add(each);

            }
        }

        System.out.println("Single people are :"+singlePerson);
        System.out.println("=====================================");


        ArrayList<Person> parents = new ArrayList<>();

        for (Person each:allPeople) {

            if(each.numbOfChildren > 0){

                parents.add(each);


            }
        }

        System.out.println("people that have kids: "+parents);
        System.out.println("=====================================");


        ArrayList<Person> noEngineers = new ArrayList<>();

        for (Person each:allPeople) {

            if(!each.occupation.equals("Engineer")){

                noEngineers.add(each);


            }
        }

        System.out.println("People that are not engineers: "+noEngineers);
        System.out.println("=====================================");

        noEngineers.removeIf(p->p.occupation.equals("software engineer"));

        System.out.println("No one in this list is software engineer: "+noEngineers);
        System.out.println("=====================================");




    }
}
