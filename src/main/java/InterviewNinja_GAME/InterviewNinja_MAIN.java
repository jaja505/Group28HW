package InterviewNinja_GAME;

/*
@Authors: Daniel Vanshtein and Steph Galvez
 */

//EXPECTED RELEASE DATE: 02/01/21**********************

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
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;


public class InterviewNinja_MAIN {

    //PART I - Question format setup
    //Custom class object array created
    //Located in the "MAIN" class for accessibility
    public static ArrayList<QuestionAndSolution> wholeQuestionsWithSolutionList = new ArrayList<>();

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
    }

    //PART II - The timer setup
    public static void questionAndTimeWindowSetup(String str, String time) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver1 = new ChromeDriver();


        Dimension d1 = new Dimension(1800, 500);
        driver1.manage().window().setSize(d1);
        driver1.get("https://watsgucci.github.io/");// from a different project/repo. This is the github domain i created thats given to me from my github account!. HTML file is in watsgucci.github.io repo.

        //=================================================================================
        //TYPEWRITER STARTS
        //=================================================================================
        for (int i = 0; i < str.length(); i++) {
            String eachChar = str.charAt(i) + "";
            driver1.findElement(By.name("questionText")).sendKeys((eachChar));
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                System.out.println("Sleep interrupted doodoo head" + e.getMessage());
            }
        }

        //=================================================================================
        //driver2 (timer) is initiated
        //=================================================================================
        WebDriver driver2 = new ChromeDriver();
        Dimension d2 = new Dimension(1800, 500);
        Point p2 = new Point(0, 550);
        driver2.manage().window().setPosition(p2);
        driver2.manage().window().setSize(d2);
        driver2.get("https://timer.onlineclock.net/");//goes to URL

//TODO FIX FOR 1 MINUTE!!!!!! -Daniel

        Select dropDown = new Select(driver2.findElement(By.id("minutesSelect")));//FORM SOURCE CODE
        //WORK ON THE TIMER
        dropDown.selectByVisibleText(time.concat("Minutes"));

        //ADD TO LOOP A BUTTON IN HTML THAT WILL HELP US CLOSE THE BROWSERS IF THE PERSON ANSWERS THE QUESTION EARLIER THAN TIMER.
        //OR MAYBE TEXT IN THE INPUT FIELD FOR IT TO DETECT A STOP

        //Still Working... to Good Job! Closing Browsers Now... // ELEMENT = ""


        while (driver2.getCurrentUrl().equals("https://timer.onlineclock.net/")) {
            driver2.getCurrentUrl();

            if (driver2.getCurrentUrl().equals("https://timer.onlineclock.net/alarm.html") || driver1.findElement(By.xpath("//div[@id='myDIV']")).getText().contains("Good")) {
                driver2.quit();
                break;
            }


        }

        driver2.quit();
        driver1.quit();
    }

    //PART III - Player selection setup
    /*
TODO ADD PEOPLE SO THAT WE CAN KNOW THE ORDER OF THE PEOPLE WHO WILL GO. - Steph start the new custom class for people. Daniel work on it after. (DONE)
So in RoundRobin, if there are 5 players, we want to enter everyone names and then prompt the name later in the game when its that
person's turn.
 */

    public static void playersSelection() {

        ArrayList<String> playersNames = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        Random rand3 = new Random();


        System.out.println("How many players?");
        int players = scan.nextInt();
        int count = 0;
        for (int i = 0; i < players; i++) {
            if (players == 1) {
                System.out.println("You are playing SOLO");
                continue;
            } else {
                count++;
                System.out.println("Enter player " + count + " name");
                String playerName = scan.next();
                playersNames.add(playerName);
            }
        }

        System.out.println("Players order will be as follow: ");

        ArrayList<String> tempPlayersNames = new ArrayList<>();

        while (!playersNames.isEmpty()) {
            int randName = rand3.nextInt(playersNames.size());
            tempPlayersNames.add(playersNames.get(randName));
            playersNames.remove(randName);
        }
        System.out.println(tempPlayersNames);
    }



    //PART IV - Game setup
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        try {
            FileInputStream file1 = new FileInputStream("src/main/java/InterviewNinja_GAME/Questions.txt");
            populateQuestionList(file1); // method to populate an array with all the questions from Questions.txt
        } catch (FileNotFoundException e) {
            System.err.println("File path is wrong dude, Go To File1 and Change its path! I wont Load the questions/program till you change it");
            System.exit(0);
        }


        Scanner scan = new Scanner(System.in);


        System.out.println("\n" +
                "██╗███╗░░██╗████████╗███████╗██████╗░██╗░░░██╗██╗███████╗░██╗░░░░░░░██╗  ███╗░░██╗██╗███╗░░██╗░░░░░██╗░█████╗░\n" +
                "██║████╗░██║╚══██╔══╝██╔════╝██╔══██╗██║░░░██║██║██╔════╝░██║░░██╗░░██║  ████╗░██║██║████╗░██║░░░░░██║██╔══██╗\n" +
                "██║██╔██╗██║░░░██║░░░█████╗░░██████╔╝╚██╗░██╔╝██║█████╗░░░╚██╗████╗██╔╝  ██╔██╗██║██║██╔██╗██║░░░░░██║███████║\n" +
                "██║██║╚████║░░░██║░░░██╔══╝░░██╔══██╗░╚████╔╝░██║██╔══╝░░░░████╔═████║░  ██║╚████║██║██║╚████║██╗░░██║██╔══██║\n" +
                "██║██║░╚███║░░░██║░░░███████╗██║░░██║░░╚██╔╝░░██║███████╗░░╚██╔╝░╚██╔╝░  ██║░╚███║██║██║░╚███║╚█████╔╝██║░░██║\n" +
                "╚═╝╚═╝░░╚══╝░░░╚═╝░░░╚══════╝╚═╝░░╚═╝░░░╚═╝░░░╚═╝╚══════╝░░░╚═╝░░░╚═╝░░  ╚═╝░░╚══╝╚═╝╚═╝░░╚══╝░╚════╝░╚═╝░░╚═╝");
        System.out.println("________________________________________________________________________________________________________________________________________________________");


        System.out.println("What style of INTERVIEW NINJA do you want to play?");

        //*********************************************************
        //=========================================================
        System.out.println("\t[1] Round Robin Style - Multiplayer");
        /*
        RoundRobin Explanation: Gets a random question from the Questions.txt and sets a timer for it.
        Goes until list is finished and each question can only be asked 2 times
         */
        //*********************************************************
        //=========================================================

        System.out.println("\t[2] Topic Based Style - Multiplayer");
        /*
        1. Present user with a menu of topics
        2. Need to ask user what topic he would like to play...
        3. Game takes every question with that topic and adds it to an ArrayList
        4. Runs the randomQuestion generator...Questions are limited to being shown only 1 time!
         */


        //NEW GAME MODE 3 (single player)- SET THE TIME YOU WANT..and that sets the time FOR all the QUESTION...
        //NEW GAME MODE 4 (multiplayer) - HOT SEAT, ALL QUESTION TIMES ARE HALVED.
        System.out.println();
        System.out.print(">̶ Style Number: ");
        int typeOfGame = scan.nextInt();
        String styleChosen = "";
        styleChosen = (typeOfGame == 1) ? "ROUND ROBIN STYLE" : "TOPIC BASED STYLE"; //customizes the output message for style of game the user chose
        System.out.println("\n>̶ You have chosen " + styleChosen);

        //*********************************************************
        //=========================================================

        playersSelection();

        //*********************************************************
        //=========================================================


        if (typeOfGame == 1) {

            roundRobin:
            while (true) { //it will give player a random question and ask if he wants to keep playing

                Random rand = new Random();

                for (int i = 0; i < 1; i++) {//Controls how many questions are printed out

                    int randInt = rand.nextInt(wholeQuestionsWithSolutionList.size());//initializing a random number using our RandomClass object "rand"
                    wholeQuestionsWithSolutionList.get(randInt).questionAnswered();
                    questionAndTimeWindowSetup(wholeQuestionsWithSolutionList.get(randInt).questionPart, wholeQuestionsWithSolutionList.get(randInt).time); // RUNS
                    //****//Make it come out with a typeWriter effect, use a diff method with an, arrayList, for loop and sleep..make the sum of the milliseconds open the second window

//TODO task = NEED TO CHANGE THIS STATEMENT BELOW TO PREDICATE FORM! - Steph (DONE)

                    //Lambda expression: Predicate (removedIf();) used to removed questions that have been selected twice already
                    wholeQuestionsWithSolutionList.removeIf(p -> p.isSolvedCount >= 2);

                    /*
                    if (wholeQuestionsWithSolutionList.get(randInt).isSolvedCount >= 2) {
                        wholeQuestionsWithSolutionList.remove(wholeQuestionsWithSolutionList.get(randInt));
                    }

                    */

                    //Question and answer to be displayed after browsers .quit
                    System.out.println("===================================================================================================================================================");

                    System.out.println(wholeQuestionsWithSolutionList.get(randInt).questionPart);//prints the question
                    System.out.println(wholeQuestionsWithSolutionList.get(randInt).solutionPart);//prints out the solution
                    //***WRAP TEXT IN THE CONSOLE TO MAKE SOLUTIONS INTO MULTIPLE LINES INSTEAD OF A LONG RUNNING LINE
                    System.out.println("===================================================================================================================================================");
                }


                if (wholeQuestionsWithSolutionList.isEmpty()) {
                    System.out.println(">̶ No more Questions. Thanks for playing");
                    break;
                }
                System.out.println(">̶ Do you want to continue?");
                System.out.print("Yes or No: ");
                String continueYesOrNo = scan.next();
                continueYesOrNo = continueYesOrNo.toLowerCase();
                //***NEED TO DO MORE FORMATTING!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                if (continueYesOrNo.contains("yes") || continueYesOrNo.equalsIgnoreCase("y") || continueYesOrNo.equalsIgnoreCase("1")) {
                    continue roundRobin;
                } else {
                    System.out.println("Thanks for playing!");
                    break;
                }
               /* } else if (continueYesOrNo.contains("no") || continueYesOrNo.contains("n")) {
                    System.out.println("Thanks for playing!");
                    break;
                }
                */
            }
        }

        if (typeOfGame == 2) {
            System.out.println("===================================================================================================================================================");
            System.out.println("WELCOME TO INTERVIEW NINJA - TOPIC!\n");

            gameMenu:
            while (true) {

                System.out.println(">̶ Select topic to be quizzed on:");
                System.out.println("[1] Soft Skills");
                System.out.println("[2] Java");
                System.out.println("[3] Selenium");
                System.out.println("[4] Git & GitHub");
                System.out.println("[5] Jira");
                System.out.println("[6] Technical ");

                String topicSelection = scan.next();//SELECT USER INPUt OF STYLE

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

                    case "6":
                        topic = "TQ";
                        break;

                    default://added default to make sure an inappropriate input is handled
                        System.out.println("\n******************************************************************************************************************\nYour input is not valid...Please choose from the following menu...\n");
                        continue gameMenu;

                } // topic variable will be assigned based on the number the user inputted and assigned to topicSelection


                for (QuestionAndSolution each : wholeQuestionsWithSolutionList) { //To create an Array List based on Topic selection
                    if (each.topic.equals(topic)) {
                        topicQuestionsWithSolutionList.add(each);
                    }

                }

                for (int j = 0; j < topicQuestionsWithSolutionList.size(); j++) { //run a loop based on the Array List size


                    int randTopic = rand2.nextInt(topicQuestionsWithSolutionList.size());//initializing a random number using our RandomClass object "randTopic"
                    topicQuestionsWithSolutionList.get(randTopic).questionAnswered();
                    questionAndTimeWindowSetup(topicQuestionsWithSolutionList.get(randTopic).questionPart, topicQuestionsWithSolutionList.get(randTopic).time);


                    System.out.println("===================================================================================================================================================");

                    System.out.println(topicQuestionsWithSolutionList.get(randTopic).questionPart);//prints the question
                    System.out.println(topicQuestionsWithSolutionList.get(randTopic).solutionPart);//prints out the solution
                    //***WRAP TEXT IN THE CONSOLE TO MAKE SOLUTIONS INTO MULTIPLE LINES INSTEAD OF A LONG RUNNING LINE
                    System.out.println("===================================================================================================================================================");

                    if (topicQuestionsWithSolutionList.get(randTopic).isSolvedCount >= 1) {
                        topicQuestionsWithSolutionList.remove(topicQuestionsWithSolutionList.get(randTopic));
                        j--;
                    }
                }
                //TODO Talk about what to do about prompting user or add time between questions or maybe a countdown or gives a setAmount of questions before prompting - DECIDE ON DEFAULT SETTINGS(topic based style)

                if (topicQuestionsWithSolutionList.isEmpty()) {

                    System.out.println(">̶ No more Questions for this topic left in the ArrayList");
                    System.out.println(">̶ Do you want to try a different topic?");
                    System.out.print("Yes or No: ");
                    String continueYesOrNo = scan.next();

                    if (continueYesOrNo.contains("yes") || continueYesOrNo.contains("y") || continueYesOrNo.equalsIgnoreCase("1")) {
                        continue;
                    } else {
                        System.out.println("Thanks for playing!");
                        break; //ONLY WAY TO BREAK FROM WHILE LOOP
                    }

                }

            }

        }

    }
//TODO Add settings to each style.

}
