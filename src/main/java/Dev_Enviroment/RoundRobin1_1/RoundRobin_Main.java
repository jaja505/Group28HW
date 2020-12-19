package Dev_Enviroment.RoundRobin1_1;

import java.util.ArrayList;

public class RoundRobin_Main {

    public static void main(String[] args) {
        //each question

        ArrayList<Question> questionArrayList = new ArrayList<>();
        Question q1 = new Question("Question 1");
        for (int i = 0; i < 10; i++) {
            questionArrayList.add(new Question("Question".concat((i + 1) + "")));
            System.out.println(questionArrayList.get(i));
        }

        //for making the count;
        q1.questionAnswered();
        q1.questionAnswered();
        if (q1.isSolvedCount == 2) {//for removing from list
            System.out.println(q1.isSolvedCount);
        }


    }
}
