package Examples.exam_system;
import java.util.*;
public class ExamMachine {
    //属性-----记录学生账号和密码,用集合map存储
    private HashMap<String,String> userBox=new HashMap<>();
    {
        userBox.put("王博","888");
        userBox.put("张三","666");
        userBox.put("李四","123");
    }




    //属性--题库，有好多Question类型的对象  每一个题目是一个对象
    //使用set集合，无重复
    //hash的不重复原理是equals和hashcode方法,自定义的类想要实现不重复,需要重写!这两个方法
    private HashSet<Question> questionBank=new HashSet<>();//题库属性
    //利用块,并且初始化集合内的题目对象

    {
        questionBank.add(new Question("以下选项哪个是Java基本数据类型?\n\tA.String\n\tB.Integer\n\tC.boolean\n\tD.Math","C")) ;
        questionBank.add(new Question("以下选项哪个不是Java基本数据类型?\n\tA.String\n\tB.int\n\tC.boolean\n\tD.double","A")) ;
        questionBank.add(new Question("以下选项哪个是Java引用数据类型?\n\tA.String\n\tB.int\n\tC.boolean\n\tD.char","A")) ;
        questionBank.add(new Question("以下选项哪个不是Java引用数据类型?\n\tA.String\n\tB.Integer\n\tC.boolean\n\tD.Math","C")) ;
        questionBank.add(new Question("以下选项哪个是java.util的包中的类?\n\tA.String\n\tB.Integer\n\tC.Scanner\n\tD.Math","C")) ;
        questionBank.add(new Question("以下选项哪个不是java.util的包中的类?\n\tA.Date\n\tB.Integer\n\tC.Calendar\n\tD.Random","B")) ;
        questionBank.add(new Question("以下选项哪个不是String类的方法?\n\tA.compareTo\n\tB.append\n\tC.substring\n\tD.concat","B")) ;
        questionBank.add(new Question("以下选项哪个是String类的方法?\n\tA.append\n\tB.delete\n\tC.insert\n\tD.concat","D")) ;
        questionBank.add(new Question("以下选项哪个不是接口中的属性修饰符?\n\tA.public\n\tB.static\n\tC.final\n\tD.abstract","D")) ;
        questionBank.add(new Question("以下选项哪个不是set集合的方法?\n\tA.set\n\tB.add\n\tC.remove\n\tD.iterator","A")) ;

    }

    //设计一个方法 随机生成试卷
    //参数 5道题不用  返回值-->试卷集合ArrayList<Question>方便答题遍历
    public ArrayList<Question> getPaper(){
        System.out.println("考试机正在随机生成试卷,请耐心等待!");
        try {
            Thread.sleep(5000);
        }catch(Exception e){
            e.printStackTrace();
        }

        //先用set集合存，存完变成ArrayList形式  set-->arrayList
        HashSet<Question> paper=new HashSet<>();//这是试卷
        //产生一个随机的序号   去找题目  题库set没有序号--把题库变成ArrayList
        ArrayList<Question> questionBank=new ArrayList<>(this.questionBank);//把questionBank变成有序的
        //随机抽题
        while(paper.size()!=5) {//当题目不足5个时，循环抽取
            int index = new Random().nextInt(this.questionBank.size());//[0-10)随机产生数字当做题目
            Question question = questionBank.get(index);
            paper.add(question);
        }
        return new ArrayList<Question>(paper);//按照返回值，返回ArrayList类型
    }


    //考试机中还有一个登录方法
    public String logIn(String username,String password){
        String realPassword=this.userBox.get(username);
        if(realPassword != null && realPassword.equals(password)){//说明人名字存在
            return "登录成功";
        }
        return "用户名或密码错误!";
    }


}
