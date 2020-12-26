package ZRandom_InterviewMain;

//Author: Stephanie G.

/*
  Proposed new features:
   1. add a timer feature to the program.
      1.1. adjust timer to reflect complexity of the questions, as some questions might take 1 to 2 min to answers, while others might take up to 5 min.
      1.2. Open an official timer on the web using selenium. Ask in the console if the interviewee is ready and then based on input, open a browser and start a timer.
   2. Combine group28Names class so both programs functionalities can run at the same time
   3. Create an arrayList that stores questions that have been utilized twice
 */


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

        for(int i =0;i<1;i++) {//Controls how many questions are printed out
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
