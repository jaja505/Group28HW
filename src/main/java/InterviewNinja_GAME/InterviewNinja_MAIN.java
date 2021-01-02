package InterviewNinja_GAME;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/*
1. Number of players needs to be asked
2. What type of game did yu wanna play? Wild Card? Hot Seat(Time is subtracted)? Topic Based? Random Round Robin? Think of MORE STYLES
3. MAKE TIMER AND QUESTION IN ONE WINDOW USING JAVA TIMER TO UPDATE THE TEXTBOX IN HTML.



==================
First we throw out the question
After 5 seconds the timer starts
Once timer is done its going to close the driver
Then it will print the solution
Then it will ask the user if they want to continue??WORK ON THIS PART

 */

public class InterviewNinja_MAIN {

    public static ArrayList<QuestionAndSolution> wholeQuestionsWithSolutionList = new ArrayList<>(); //CREATED OUR CUSTOM CLASS OBJECT ARRAY


    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
/*
@Liv
        ArrayList<People> group = People.assembleGroup();
        System.out.println(group);
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
        //NEW GAME MODE 3 - SET THE TIME YOU WANT FOR EACH QUESTION...
        //NEW GAME MODE 4 - HOT SEAT, ALL QUESTION TIMES ARE HALVED.


        int typeOfGame = scan.nextInt();

        if (typeOfGame == 1) {


            while (true) { //it will give player a random question and ask if he wants to keep playing

                Random rand = new Random();
                ArrayList<QuestionAndSolution> tempQuestionsWithSolutionList = new ArrayList<>(); //CREATED OUR CUSTOM CLASS OBJECT ARRAY FOR QUESTIONS SELECTED


                for (int i = 0; i < 1; i++) {//Controls how many questions are printed out

                    int randInt = rand.nextInt(wholeQuestionsWithSolutionList.size());//initializing a random number using our RandomClass object "rand"
                    wholeQuestionsWithSolutionList.get(randInt).questionAnswered();
                    questionAndTimeWindowSetup(wholeQuestionsWithSolutionList.get(randInt).questionPart, wholeQuestionsWithSolutionList.get(randInt).time); // RUNS


//task = NEED TO CHANGE THIS STATEMENT BELOW TO PREDICATE FORM!
                    if (wholeQuestionsWithSolutionList.get(randInt).isSolvedCount >= 2) {
                        wholeQuestionsWithSolutionList.remove(wholeQuestionsWithSolutionList.get(randInt));
                    }
                    // System.out.println(wholeQuestionsWithSolutionList.get(randInt).isSolvedCount);

                    //Question and answer to be displayed after browsers .quit
                    System.out.println("=====================================================================================================");

                    System.out.println(wholeQuestionsWithSolutionList.get(randInt).questionPart);
                    System.out.println(wholeQuestionsWithSolutionList.get(randInt).solutionPart);

                    System.out.println("=====================================================================================================");
                }


                if (wholeQuestionsWithSolutionList.isEmpty()) {
                    System.out.println("No more Questions. Thanks for playing");
                    break;
                }
                System.out.println(">>> Do you want to continue?");
                System.out.print("Yes or No: ");
                String continueYesOrNo = scan.next();
                if (continueYesOrNo.equalsIgnoreCase("yes") || continueYesOrNo.equalsIgnoreCase("y") || continueYesOrNo.equalsIgnoreCase("1")) {
                    continue;
                } else {
                    System.out.println("Thanks for playing!");
                    break;
                }
            }
        }


    }


    public static void populateQuestionList(FileInputStream file1) {


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


    public static void questionAndTimeWindowSetup(String str, String time) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver1 = new ChromeDriver();


        Dimension d1 = new Dimension(1800, 500);
        driver1.manage().window().setSize(d1);
        driver1.get("https://watsgucci.github.io/");// from a different project/repo. This is the github domain i created thats given to me from my github account!. HTML file is in watsgucci.github.io repo.
        driver1.findElement(By.name("questionText")).sendKeys(str);
        Thread.sleep(5000);

        //=================================================================================

        WebDriver driver2 = new ChromeDriver();
        Dimension d2 = new Dimension(1800, 500);
        Point p2 = new Point(0, 550);
        driver2.manage().window().setPosition(p2);
        driver2.manage().window().setSize(d2);
        driver2.get("https://timer.onlineclock.net/");//goes to URL
        Select dropDown = new Select(driver2.findElement(By.id("minutesSelect")));//FORM SOURCE CODE
//WORK ON THE TIMER
        dropDown.selectByVisibleText(time.concat("Minutes"));

        while (driver2.getCurrentUrl().equals("https://timer.onlineclock.net/")) {
            driver2.getCurrentUrl();

            if (driver2.getCurrentUrl().equals("https://timer.onlineclock.net/alarm.html")) {
                driver2.quit();
                break;
            }

        }

        driver2.quit();
        driver1.quit();
    }

}
