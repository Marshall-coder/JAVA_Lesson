package Examples.myself_annoation;

public class Question {//考试系统中Question对象
    //现在任意的实体对象(bean)都可以让MySpring创建

    private String title;
    private String answer;

    @MyAnnotation({"1+1=? A.1 B.2 C.6 D.8","B"})
    public Question(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
