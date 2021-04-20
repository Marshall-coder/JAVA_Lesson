package Examples.exam_system;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    //属性
    private String username;
    private String password;

    public Student(String username,String password){
        this.username=username;
        this.password=password;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    //学生需要考试--方法
    //  参数是一套试题    返回值是---学生作答的所有选项"A" "D" "B" "C" "D"
    public String[] exam(ArrayList<Question> paper){
        String[] answers=new String[paper.size()];//存储学生的选项
        Scanner input=new Scanner(System.in);

        for(int i=0;i<paper.size();i++){
            Question question=paper.get(i);
            System.out.println((i+1)+"."+ question.getTitle());
            System.out.println("请输入您认为的正确选项?");
            answers[i]=input.nextLine();//接受学生输入的选项
        }
        return answers;

    }

}
