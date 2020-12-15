package ZRandom_InterviewMain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class InterviewQuestionsAtRandom {

    public static void main(String[] args) throws FileNotFoundException {

        Random rand1 = new Random();
        FileInputStream file1 = new FileInputStream("src/main/java/ZRandom_InterviewMain/Questions.txt");

        Scanner scanner = new Scanner(file1);

        ArrayList<String> interviewQuestions = new ArrayList<>(); //to add all the interview questions

        while (scanner.hasNext()) {
            interviewQuestions.add(scanner.nextLine());
        }

        ArrayList<String> tempInterviewQuestions = new ArrayList<>();

        for(int i =0;i<3;i++) {
            int randInt = rand1.nextInt(interviewQuestions.size());//initializing a random number using our RandomClass object "rand"
            tempInterviewQuestions.add(interviewQuestions.get(randInt));//adds the element in the random index that it generated
            interviewQuestions.remove(randInt);//removes the element that was just chosen.
        }
        System.out.println();

        System.out.println("Today's questions are:");

        for (int i = 0; i < tempInterviewQuestions.size(); i++) {
            String each = tempInterviewQuestions.get(i);
            System.out.println((i + 1) + " " + each + " ");//our print statement that will print the new randomized arrayList.
            // System.out.print(dateArrayList.get(z).format(df));
            // System.out.println();//break line
        }
    }
}
