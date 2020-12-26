package RoundRobin;

import javax.swing.plaf.metal.MetalIconFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RoundRobin_Main {

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<People> group = People.assembleGroup();
        System.out.println(group);

        try {
            FileInputStream file1 = new FileInputStream("src/main/java/RoundRobin/Questions.txt");
            questionList(file1); // method to print the question
        } catch (Exception e) {
            System.err.println("File path is wrong dude, Go To File1 and Change its path! I wont Load the questions till you change it");
        }





/*
1. Number of players needs to be asked
2. What type of game did yu wanna play? Wild Card? Topic Based? Random? Think of MORE STYLES


 */

    }


    public static void questionList(FileInputStream file1) {
        Random rand1 = new Random();

        Scanner scanner = new Scanner(file1);

        ArrayList<String> interviewQuestions = new ArrayList<>(); //to add all the interview questions

        while (scanner.hasNext()) {
            interviewQuestions.add(scanner.nextLine());

        }

        ArrayList<QuestionAndSolution> wholeQuestionsWithSolutionList = new ArrayList<>(); //CREATED OUR CUSTOM CLASS OBJECT ARRAY

        for(int i=0; i< interviewQuestions.size();i++){
            wholeQuestionsWithSolutionList.add(new QuestionAndSolution((i+1)));
            wholeQuestionsWithSolutionList.get(i).questionPart = interviewQuestions.get(i).substring(interviewQuestions.get(i).indexOf("]")+2, interviewQuestions.get(i).indexOf("-"));//CHANGE

        }

        for(QuestionAndSolution each : wholeQuestionsWithSolutionList){
            System.out.println(each.questionPart);
        }

/*
        ArrayList<String> tempInterviewQuestions = new ArrayList<>();

        for (int i = 0; i < 1; i++) {//Controls how many questions are printed out
            int randInt = rand1.nextInt(interviewQuestions.size());//initializing a random number using our RandomClass object "rand"
            tempInterviewQuestions.add(interviewQuestions.get(randInt));//adds the element in the random index that it generated
            interviewQuestions.remove(randInt);//removes the element that was just chosen.
        }
        System.out.println();

        System.out.println("Today's questions are:");

        for (int i = 0; i < tempInterviewQuestions.size(); i++) {
            String each = tempInterviewQuestions.get(i);
            System.out.println((i + 1) + " " + each + " ");
        }
*/

    }
}
