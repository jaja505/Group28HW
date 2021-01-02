package InterviewNinja_GAME;

/*
@Authors: Daniel Vanshtein and Steph Galvez and ....
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.Arrays;
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
            FileInputStream file1 = new FileInputStream("src/main/java/InterviewNinja_GAME/Questions.txt");
            populateQuestionList(file1); // method to print the question
        } catch (FileNotFoundException e) {
            System.err.println("File path is wrong dude, Go To File1 and Change its path! I wont Load the questions till you change it");
            System.exit(0);
        }


        Scanner scan = new Scanner(System.in);

        /* Commented out the players
        System.out.println("How many players?");
        int players = scan.nextInt();
        */
        System.out.println("\n" +
                "██╗███╗░░██╗████████╗███████╗██████╗░██╗░░░██╗██╗███████╗░██╗░░░░░░░██╗  ███╗░░██╗██╗███╗░░██╗░░░░░██╗░█████╗░\n" +
                "██║████╗░██║╚══██╔══╝██╔════╝██╔══██╗██║░░░██║██║██╔════╝░██║░░██╗░░██║  ████╗░██║██║████╗░██║░░░░░██║██╔══██╗\n" +
                "██║██╔██╗██║░░░██║░░░█████╗░░██████╔╝╚██╗░██╔╝██║█████╗░░░╚██╗████╗██╔╝  ██╔██╗██║██║██╔██╗██║░░░░░██║███████║\n" +
                "██║██║╚████║░░░██║░░░██╔══╝░░██╔══██╗░╚████╔╝░██║██╔══╝░░░░████╔═████║░  ██║╚████║██║██║╚████║██╗░░██║██╔══██║\n" +
                "██║██║░╚███║░░░██║░░░███████╗██║░░██║░░╚██╔╝░░██║███████╗░░╚██╔╝░╚██╔╝░  ██║░╚███║██║██║░╚███║╚█████╔╝██║░░██║\n" +
                "╚═╝╚═╝░░╚══╝░░░╚═╝░░░╚══════╝╚═╝░░╚═╝░░░╚═╝░░░╚═╝╚══════╝░░░╚═╝░░░╚═╝░░  ╚═╝░░╚══╝╚═╝╚═╝░░╚══╝░╚════╝░╚═╝░░╚═╝");
        System.out.println("_________________________________________________________________________________________________________________");
        System.out.println("What style of INTERVIEW NINJA do you want to play?");
        //=========================================================
        System.out.println("[1] Round Robin Style - Multiplayer");
        /*
        Gets a random question from the Questions.txt and sets a timer for it.
        Goes until list is finished and each question can only be asked 2 times
         */
        //=========================================================
        System.out.println("[2] Topic Based Style - Multiplayer");
        /*
        1. Present user with a menu of topics
        2. Need to ask user what topic he would like to play...
        3. Game takes every question with that topic and adds it to an ArrayList
        4. Runs the randomQuestion generator...Questions are limited to being shown only 1 time!
        5.

         */


        //NEW GAME MODE 3 (single player)- SET THE TIME YOU WANT..and that sets the time FOR all the QUESTION...
        //NEW GAME MODE 4 (multiplayer) - HOT SEAT, ALL QUESTION TIMES ARE HALVED.
        System.out.println();
        System.out.print(">̶ Style Number: ");
        int typeOfGame = scan.nextInt();
        System.out.println(">̶ You have chosen ROUND ROBIN");

        if (typeOfGame == 1) {


            while (true) { //it will give player a random question and ask if he wants to keep playing

                Random rand = new Random();
                //ArrayList<QuestionAndSolution> tempQuestionsWithSolutionList = new ArrayList<>(); //CREATED OUR CUSTOM CLASS OBJECT ARRAY FOR QUESTIONS SELECTED


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

                    System.out.println(wholeQuestionsWithSolutionList.get(randInt).questionPart);//prints the question
                    System.out.println(wholeQuestionsWithSolutionList.get(randInt).solutionPart);//prints out the solution
//**********FIGURE OUT HOW TO BREAK UP THE SOLUTION INTO NUMEROUS LINES.
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

        if (typeOfGame == 2) {

            System.out.println("Select topic to be quizzed on");
            System.out.println("[1] Soft Skills");
            System.out.println("[2] Java");
            System.out.println("[3] Selenium");
            System.out.println("[4] Git & GitHub");
            System.out.println("[5] Jira");

            String topicSelection = scan.next();
            Random rand2 = new Random();

            ArrayList<QuestionAndSolution> topicQuestionsWithSolutionList = new ArrayList<>(); //CREATED OUR CUSTOM CLASS OBJECT ARRAY FOR QUESTIONS SELECTED
            String topic = "";


            switch (topicSelection) {

                case "1":
                    topic = "SS";
                    break;

                case "2":
                    topic = "Java";
                    break;

                case "3":
                    topic = "Selenium";
                    break;

                case "4":
                    topic = "GH";
                    break;

                case "5":
                    topic = "Jira";
                    break;

            }


            for (QuestionAndSolution each : wholeQuestionsWithSolutionList) //To create an Array List based on Topic selection
                if (each.topic.equals(topicSelection)) {
                    topicQuestionsWithSolutionList.add(each);
                }

            System.out.println(topicQuestionsWithSolutionList);

            //for (int i = 0; i < 1; i++) {
              //  int randTopic = rand2.nextInt(topicQuestionsWithSolutionList.size());//initializing a random number using our RandomClass object "randTopic"

            //}

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

        //ADD TO LOOP A BUTTON IN HTML THAT WILL HELP US CLOSE THE BROWSERS IF THE PERSON ANSWERS THE QUESTION EARLIER THAN TIMER.
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
