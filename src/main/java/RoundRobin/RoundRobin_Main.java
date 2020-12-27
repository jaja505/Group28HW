package RoundRobin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/*
1. Number of players needs to be asked
2. What type of game did yu wanna play? Wild Card? Hot Seat(Time is subtracted)? Topic Based? Random Round Robin? Think of MORE STYLES

==================
First we throw out the question
After 5 seconds the timer starts
Once timer is done its going to close the driver
Then it will print the solution
Then it will ask the user if they want to continue??WORK ON THIS PART

 */

public class RoundRobin_Main {

    public static ArrayList<QuestionAndSolution> wholeQuestionsWithSolutionList = new ArrayList<>(); //CREATED OUR CUSTOM CLASS OBJECT ARRAY


    public static void main(String[] args) throws FileNotFoundException {
/*
@Liv
        ArrayList<People> group = People.assembleGroup();
        System.out.println(group);
*/
/*
DONT TOUCH THIS!!!
        questionWindowSetup("hello world");
*/
        try {
            FileInputStream file1 = new FileInputStream("src/main/java/RoundRobin/Questions.txt");
            populateQuestionList(file1); // method to print the question
        } catch (FileNotFoundException e) {
            System.err.println("File path is wrong dude, Go To File1 and Change its path! I wont Load the questions till you change it");
            System.exit(0);
        }


        Scanner scan = new Scanner(System.in);

        System.out.println("How many players?");
        int players = scan.nextInt();

        System.out.println("What type of game do you want to play?");
        System.out.println("[1] Round Robin Style");
        System.out.println("[2] Topic Based Style");


        int typeOfGame = scan.nextInt();

        if (typeOfGame == 1) {
//*****TASK:  *****NEED TO ADD A LIMIT HOW MANY TIMES THE SAME QUESTION CAN BE IN THE LOOP. ONLY ALLOWED 2 OF THE SAME QUESTION PER GAME.

            boolean isNotOver = true;

            while (true) { //it will give player a random question and ask if he wants to keep playing

                Random rand = new Random();
                ArrayList<QuestionAndSolution> tempQuestionsWithSolutionList = new ArrayList<>(); //CREATED OUR CUSTOM CLASS OBJECT ARRAY FOR QUESTIONS SELECTED


                for (int i = 0; i < 1; i++) {//Controls how many questions are printed out

                    int randInt = rand.nextInt(wholeQuestionsWithSolutionList.size());//initializing a random number using our RandomClass object "rand"
                    wholeQuestionsWithSolutionList.get(randInt).questionAnswered();

                    int x = wholeQuestionsWithSolutionList.get(randInt).isSolvedCount;

                    System.out.println((wholeQuestionsWithSolutionList.get(randInt).questionPart) + " " + wholeQuestionsWithSolutionList.get(randInt).isSolvedCount);

                    if (wholeQuestionsWithSolutionList.get(randInt).isSolvedCount >= 2) {
                        wholeQuestionsWithSolutionList.remove(wholeQuestionsWithSolutionList.get(randInt));
                    }
                    // System.out.println(wholeQuestionsWithSolutionList.get(randInt).isSolvedCount);




                    System.out.println("=====================================================================================================");


                }
                if (wholeQuestionsWithSolutionList.isEmpty()) {
                    System.out.println("No more Questions. Thanks for playing");
                    isNotOver = false;
                    break;
                }
                System.out.println("Do you want to continue? (yes or no)");

                String continueYesOrNo = scan.next();
                if (continueYesOrNo.equals("yes")) {
                    continue;
                } else {
                    System.out.println("Thanks for playing!");
                    break;
                }
            }
        }


    }


    public static void populateQuestionList(FileInputStream file1) {
        Random rand1 = new Random();

        Scanner scanner = new Scanner(file1);

        ArrayList<String> interviewQuestions = new ArrayList<>(); //to add all the interview questions

        while (scanner.hasNext()) {
            interviewQuestions.add(scanner.nextLine());

        }


        for (int i = 0; i < interviewQuestions.size(); i++) {
            wholeQuestionsWithSolutionList.add(new QuestionAndSolution((i + 1)));
            wholeQuestionsWithSolutionList.get(i).questionPart = interviewQuestions.get(i).substring(interviewQuestions.get(i).indexOf("]") + 2, interviewQuestions.get(i).indexOf("-"));
            wholeQuestionsWithSolutionList.get(i).solutionPart = interviewQuestions.get(i).substring(interviewQuestions.get(i).indexOf("-") + 2);
            wholeQuestionsWithSolutionList.get(i).time = interviewQuestions.get(i).substring(interviewQuestions.get(i).indexOf("min.") - 2, interviewQuestions.get(i).indexOf("min."));
            wholeQuestionsWithSolutionList.get(i).topic = interviewQuestions.get(i).substring(interviewQuestions.get(i).indexOf("[") + 1, interviewQuestions.get(i).indexOf("]"));


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

    /*
/*
DONT TOUCH THIS!!!
    public static void questionWindowSetup(String str){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://watsgucci.github.io/");
        driver.findElement(By.name("questionText")).sendKeys(str);


    }

*/


}



