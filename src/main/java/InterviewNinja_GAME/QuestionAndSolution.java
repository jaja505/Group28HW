package InterviewNinja_GAME;

public class QuestionAndSolution {

    /*
    Constructor: public Questions(){
    variables: isSolvedCount, time, topic, solution

     */
    public int isSolvedCount = 0;
    public int numberOfQuestion;

    public String questionPart, solutionPart;
    public String time;
    public String topic;




    public QuestionAndSolution(int numberOfQuestion) {//constructor format
        this.numberOfQuestion = numberOfQuestion;


    }

    public void questionAnswered() {
        isSolvedCount++;

    }



    /*
    CREATE A METHOD TO TAKE THE TIME OUT OF THE QUESTION...FOR EXAMPLE:
          The question will have this format below:
          String testQuestion = "testQuestion [2 min.]";

          testQuestion = testQuestion.substring(testQuestion.indexOf("min.") - 2, testQuestion.indexOf("min"));

          System.out.println(testQuestion);
     */



    @Override
    public String toString() {
        return questionPart +"\n"+
                " isSolvedCount=" + isSolvedCount +
                ", numberOfQuestion='" + numberOfQuestion + '\'' +
                '}';
    }


}
