package ZRandom_InterviewMain;
/*
@Author: Daniel Vanshtein
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WhoWillBeInterviewed$ {

    public static DateTimeFormatter df = DateTimeFormatter.ofPattern("EEEE - MMM, dd"); // MADE A PUBLIC STATIC FORMATTER SO I CAN USE ANYWHERE IN MY CLASS
    public static DateTimeFormatter df2 = DateTimeFormatter.ofPattern("MM/dd"); // MADE A PUBLIC STATIC FORMATTER SO I CAN USE ANYWHERE IN MY CLASS


    public static void main(String[] args) throws FileNotFoundException {//HAVE TO THROW EXCEPTION for the input file in case the filePath given is wrong
        Random rand = new Random();
        FileInputStream file = new FileInputStream("src/ZRandom_InterviewMain/group28Names");//created a fileStream Object "File" that we will be reading.


        Scanner sc = new Scanner(file);//make a scanner specifically to read that file...NOT SYSTEM.IN


        ArrayList<String> group28NamesArrayList = new ArrayList<>(); // making an arrayList to put all our names in

        while (sc.hasNext()) {
            group28NamesArrayList.add(sc.nextLine());
        }

        System.out.println("The Possible Names are: \n");
        System.out.println("================================");
        for (String each : group28NamesArrayList) System.out.println(each);
        System.out.println("================================");
        System.out.println("\n");

        //IDEA TO ADD HOW MANY PEOPLE WE WANT TO TAKE FROM THE LIST, OR DO WE WANT ALL the names to be put into the random hat

        ArrayList<String> tempArrayList = new ArrayList<>();//tempArrayList for printing out our random names and making sure none of them are printed TWICE

        while (!group28NamesArrayList.isEmpty()) {//creating condition for ALL the names to be read from the ArrayList
            int randInt = rand.nextInt(group28NamesArrayList.size());//initializing a random number using our RandomClass object "rand"
            tempArrayList.add(group28NamesArrayList.get(randInt));//adds the element in the random index that it generated
            group28NamesArrayList.remove(randInt);//removes the element that was just chosen.
        }

        ArrayList<LocalDate> dateArrayList = new ArrayList<>();
        LocalDate today = LocalDate.now();


        for (int j = 0; j < 9; j++) {//need to use today keyword
            if (LocalDate.now().getDayOfWeek() == DayOfWeek.SUNDAY) {
                if (j == 0) {
                    dateArrayList.add((today.plusDays((1))));
                } else if (j == 1) {
                    dateArrayList.add((today.plusDays(1)));
                } else if (j == 2) {
                    dateArrayList.add((today.plusDays(2)));
                } else if (j == 3) {
                    dateArrayList.add((today.plusDays((2))));
                } else if (j == 4) {
                    dateArrayList.add((today.plusDays(4)));
                } else if (j == 5) {
                    dateArrayList.add((today.plusDays((4))));
                } else if (j == 6) {
                    dateArrayList.add((today.plusDays((5))));
                } else if (j == 7) {
                    dateArrayList.add((today.plusDays((5))));
                } else {
                    dateArrayList.add((today.plusDays((1))));
                }

            }
            if (LocalDate.now().getDayOfWeek() == DayOfWeek.MONDAY) {
                if (j == 0) {
                    dateArrayList.add((today.plusDays((0))));
                } else if (j == 1) {
                    dateArrayList.add((today.plusDays(0)));
                } else if (j == 2) {
                    dateArrayList.add((today.plusDays(1)));
                } else if (j == 3) {
                    dateArrayList.add((today.plusDays((1))));
                } else if (j == 4) {
                    dateArrayList.add((today.plusDays(3)));
                } else if (j == 5) {
                    dateArrayList.add((today.plusDays((3))));
                } else if (j == 6) {
                    dateArrayList.add((today.plusDays((4))));
                } else if (j == 7) {
                    dateArrayList.add((today.plusDays((4))));
                } else {
                    dateArrayList.add((today.plusDays((7))));
                }
            }
            if (LocalDate.now().getDayOfWeek() == DayOfWeek.TUESDAY) {
                if (j == 0) {
                    dateArrayList.add((today.plusDays((0))));
                } else if (j == 1) {
                    dateArrayList.add((today.plusDays(0)));
                } else if (j == 2) {
                    dateArrayList.add((today.plusDays(2)));
                } else if (j == 3) {
                    dateArrayList.add((today.plusDays((2))));
                } else if (j == 4) {
                    dateArrayList.add((today.plusDays(3)));
                } else if (j == 5) {
                    dateArrayList.add((today.plusDays((3))));
                } else if (j == 6) {
                    dateArrayList.add((today.plusDays((6))));
                } else if (j == 7) {
                    dateArrayList.add((today.plusDays((6))));
                } else {
                    dateArrayList.add((today.plusDays((7))));
                }
                System.out.println(dateArrayList.get(j).getDayOfWeek());
            }
            if (LocalDate.now().getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                if (j == 0) {
                    dateArrayList.add((today.plusDays((1))));
                } else if (j == 1) {
                    dateArrayList.add((today.plusDays(1)));
                } else if (j == 2) {
                    dateArrayList.add((today.plusDays(2)));
                } else if (j == 3) {
                    dateArrayList.add((today.plusDays((2))));
                } else if (j == 4) {
                    dateArrayList.add((today.plusDays(5)));
                } else if (j == 5) {
                    dateArrayList.add((today.plusDays((5))));
                } else if (j == 6) {
                    dateArrayList.add((today.plusDays((6))));
                } else if (j == 7) {
                    dateArrayList.add((today.plusDays((6))));
                } else {
                    dateArrayList.add((today.plusDays((8))));
                }
                System.out.println(dateArrayList.get(j).getDayOfWeek());
            }
            if (LocalDate.now().getDayOfWeek() == DayOfWeek.THURSDAY) {
                if (j == 0) {
                    dateArrayList.add((today.plusDays((0))));
                } else if (j == 1) {
                    dateArrayList.add((today.plusDays(0)));
                } else if (j == 2) {
                    dateArrayList.add((today.plusDays(1)));
                } else if (j == 3) {
                    dateArrayList.add((today.plusDays((1))));
                } else if (j == 4) {
                    dateArrayList.add((today.plusDays(4)));
                } else if (j == 5) {
                    dateArrayList.add((today.plusDays((4))));
                } else if (j == 6) {
                    dateArrayList.add((today.plusDays((5))));
                } else if (j == 7) {
                    dateArrayList.add((today.plusDays((5))));
                } else {
                    dateArrayList.add((today.plusDays((7))));
                }
                System.out.println(dateArrayList.get(j).getDayOfWeek());
            }
            if (LocalDate.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
                if (j == 0) {
                    dateArrayList.add((today.plusDays(0)));
                } else if (j == 1) {
                    dateArrayList.add((today.plusDays(0)));
                } else if (j == 2) {
                    dateArrayList.add((today.plusDays(3)));
                } else if (j == 3) {
                    dateArrayList.add((today.plusDays(3)));
                } else if (j == 4) {
                    dateArrayList.add((today.plusDays(4)));
                } else if (j == 5) {
                    dateArrayList.add((today.plusDays(4)));
                } else if (j == 6) {
                    dateArrayList.add((today.plusDays(6)));
                } else if (j == 7) {
                    dateArrayList.add((today.plusDays(6)));
                } else {
                    dateArrayList.add((today.plusDays(7)));
                }
                System.out.println(dateArrayList.get(j).getDayOfWeek());
            }


        }//end of for loop
        System.out.println();

        System.out.println("The lucky wieners for the cycle of " + today.format(df2) +" to "+dateArrayList.get(dateArrayList.size()-1).format(df2)+ " are:");

        System.out.println("================================");
        for (int z = 0; z < tempArrayList.size(); z++) {
            String each = tempArrayList.get(z);
            System.out.print((z+1) + " " + each + " ");//our print statement that will print the new randomized arrayList.
            System.out.print(dateArrayList.get(z).format(df));
            System.out.println();//break line
        }

    }
}







/* //
    if (assignedDate.plusDays(i).getDayOfWeek().getValue() != 3 && assignedDate.plusDays(i).getDayOfWeek().getValue() != 6 &&
                        assignedDate.plusDays(i).getDayOfWeek().getValue() != 7) {
                    dateArrayList.add(assignedDate.plusDays(i));

                } else if (assignedDate.plusDays(i).getDayOfWeek().getValue() == 3 || assignedDate.plusDays(i).getDayOfWeek().getValue() == 7) {
                    dateArrayList.add(assignedDate.plusDays(i + 1));
                } else if (assignedDate.plusDays(i).getDayOfWeek().getValue() == 6) {
                    dateArrayList.add(assignedDate.plusDays(i + 2));
                }
                OR



commented it out, left for my refrence for now
        if(assignedDate.getDayOfWeek().getValue() != 3 && assignedDate.getDayOfWeek().getValue() != 6 &&
                    assignedDate.getDayOfWeek().getValue() != 7){
                return assignedDate;

            }else if (assignedDate.getDayOfWeek().getValue() == 3){
            return null;
        }else{
            return null;
        }
*/




