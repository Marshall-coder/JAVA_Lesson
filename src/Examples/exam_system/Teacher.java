package Examples.exam_system;

import java.util.ArrayList;

public class Teacher {
    //负责批改卷子
    //参数:学生作答的选项  ,和真实试卷
    public int checkPaper(ArrayList<Question> paper,String[] answers)  {
        System.out.println("老师正在批卷子,请稍等...");
        try {
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }
        int score=0;
        for(int i=0;i<paper.size();i++){
            Question question= paper.get(i);
           if(question.getAnswer().equalsIgnoreCase(answers[i])){//这是真实答案与学生答案作比较
               score+=100/paper.size();//其实是100/paper.size();

           }

        }
        return score;
    }

}
