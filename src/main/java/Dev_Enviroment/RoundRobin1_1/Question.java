package Dev_Enviroment.RoundRobin1_1;

public class Question {

    /*
    Constructor: public Questions(){
    variables: isSolvedCount, time, topic, solution

     */
    public int isSolvedCount;
    public String numberOfQuestion;

    public Question(String numberOfQuestion) {//constructor format
        this.numberOfQuestion = numberOfQuestion;

    }

    public void questionAnswered() {
        isSolvedCount++;

    }

    @Override
    public String toString() {
        return numberOfQuestion +
                " isSolvedCount=" + isSolvedCount +
                ", numberOfQuestion='" + numberOfQuestion + '\'' +
                '}';
    }
}
