package Examples.test_reflect_ioc;
//考试的题目类

public class Question {

    private String title;//题目
    private String answer;//答案

    public Question(){}
    public Question(String title, String answer) {
        this.title = title;
        this.answer = answer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }


    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public String getAnswer(){
        return answer;
    }

    public String toString(){
        return new String(title+answer);
    }
}
