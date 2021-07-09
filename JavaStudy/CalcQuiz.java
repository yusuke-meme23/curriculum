import java.util.Random;
class CalcQuiz {
    String question;
    String answer;

    CalcQuiz (){
        createQuestion();
    }
    void createQuestion(){
        Random rnd = new Random();
        int a = rnd.nextInt(100);
        int b = rnd.nextInt(100);
        question = a + "×" + b + "=?";
        answer = Integer.toString(a*b);
    }
    String getQuestion(){
            return question;
    }
    String getAnswer(){
            return answer;
    }
}

