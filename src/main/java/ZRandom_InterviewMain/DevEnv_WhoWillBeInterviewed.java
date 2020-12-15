package ZRandom_InterviewMain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DevEnv_WhoWillBeInterviewed {

        public static void main(String[] args) throws FileNotFoundException {//HAVE TO THROW EXCEPTION for the input file in case the filePath given is wrong
            Random rand = new Random();
            FileInputStream file = new FileInputStream("src/main/java/ZRandom_InterviewMain/group28Names");//created a fileStream Object "File" that we will be reading.


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


            LocalDate todayDate = LocalDate.now();
            DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM, dd");
            System.out.println("The lucky winners for " + todayDate.format(df) + " are:");

            System.out.println("================================");
            //IDEA TO ADD HOW MANY PEOPLE WE WANT TO TAKE FROM THE LIST, OR DO WE WANT ALL the names to be put into the random hat

            ArrayList<String> tempArrayList = new ArrayList<>();//tempArrayList for printing out our random names and making sure none of them are printed TWICE

            while (!group28NamesArrayList.isEmpty()) {//creating condition for ALL the names to be read from the ArrayList
                int randInt = rand.nextInt(group28NamesArrayList.size());//initializing a random number using our RandomClass object "rand"
                tempArrayList.add(group28NamesArrayList.get(randInt));//adds the element in the random index that it generated
                group28NamesArrayList.remove(randInt);//removes the element that was just chosen.
            }

            DateTimeFormatter df2 = DateTimeFormatter.ofPattern("(E, MMM dd)"); //give visibility to the day

            LocalDate firstCycleOfDates = LocalDate.now();
            if (firstCycleOfDates.getDayOfWeek() == DayOfWeek.WEDNESDAY || firstCycleOfDates.getDayOfWeek() == DayOfWeek.SUNDAY) {
                firstCycleOfDates = firstCycleOfDates.plusDays(1);
            } else if (firstCycleOfDates.getDayOfWeek() == DayOfWeek.SATURDAY) {
                firstCycleOfDates = firstCycleOfDates.plusDays(2);
            }

            //*************************************************************************************************
            LocalDate secondCycleOfDates = firstCycleOfDates.plusDays(1);
            if (secondCycleOfDates.getDayOfWeek() == DayOfWeek.WEDNESDAY || secondCycleOfDates.getDayOfWeek() == DayOfWeek.SUNDAY) {
                secondCycleOfDates = secondCycleOfDates.plusDays(1);
            } else if (secondCycleOfDates.getDayOfWeek() == DayOfWeek.SATURDAY) {
                secondCycleOfDates = secondCycleOfDates.plusDays(2);
            }

            //*************************************************************************************************
            LocalDate thirdCycleOfDates = secondCycleOfDates.plusDays(1);
            if (thirdCycleOfDates.getDayOfWeek() == DayOfWeek.WEDNESDAY || thirdCycleOfDates.getDayOfWeek() == DayOfWeek.SUNDAY) {
                thirdCycleOfDates = thirdCycleOfDates.plusDays(1);
            } else if (thirdCycleOfDates.getDayOfWeek() == DayOfWeek.SATURDAY) {
                thirdCycleOfDates = thirdCycleOfDates.plusDays(2);
            }

            //*************************************************************************************************
            LocalDate fourthCycleOfDates = thirdCycleOfDates.plusDays(1);
            if (fourthCycleOfDates.getDayOfWeek() == DayOfWeek.WEDNESDAY || fourthCycleOfDates.getDayOfWeek() == DayOfWeek.SUNDAY) {
                fourthCycleOfDates = fourthCycleOfDates.plusDays(1);
            } else if (fourthCycleOfDates.getDayOfWeek() == DayOfWeek.SATURDAY) {
                fourthCycleOfDates = fourthCycleOfDates.plusDays(2);
            }

            //*************************************************************************************************
            LocalDate fifthCycleOfDates = fourthCycleOfDates.plusDays(1);
            if (fifthCycleOfDates.getDayOfWeek() == DayOfWeek.WEDNESDAY || fifthCycleOfDates.getDayOfWeek() == DayOfWeek.SUNDAY) {
                fifthCycleOfDates = fifthCycleOfDates.plusDays(1);
            } else if (fifthCycleOfDates.getDayOfWeek() == DayOfWeek.SATURDAY) {
                fifthCycleOfDates = fifthCycleOfDates.plusDays(2);
            }

            int i = 1;
            for (String each : tempArrayList) {
                if(i < 3){
                    System.out.println(i + " " + each + " " + firstCycleOfDates.format(df2));
                }else if(i < 5){
                    System.out.println(i + " " + each + " " + secondCycleOfDates.format(df2));
                }else if(i < 7){
                    System.out.println(i + " " + each + " " + thirdCycleOfDates.format(df2));
                }else if (i < 9){
                    System.out.println(i + " " + each + " " + fourthCycleOfDates.format(df2));
                }else{
                    System.out.println(i + " " + each + " " + fifthCycleOfDates.format(df2));
                }
                i++;
            }

        }

    }

