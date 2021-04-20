package Examples.exam_system;


public class Question {
    //题类有两个属性，题目和答案
    private String title;//题干
    private String answer;//答案
    //默认有参的构造方法
    public Question(String title,String answer){
        this.title=title;
        this.answer=answer;
    }

    //重写方法 将默认的比较题目对象的地址规则  改写为 比较题干  题干一致则认为是同一个题目
    //所以重写hashcode和equals方法
    public boolean equals(Object obj){
       if(this==obj){//先比较地址，如果地址一样，就是一个对象 返回true
           return true;
       }
       if(obj instanceof Question){//如果类型属于
          //如果obj属于Question类型,则先造型
          Question anotherquestion=(Question)obj;
          if(this.title.equals(anotherquestion.title)){//并且String类型的题目相同 则判断题目相同
              return true;
          }
       }
       return false;//如果obj不属于Question类型,则类型不同无法比较,直接返回false
    }



    public int hashCode(){
        return this.title.hashCode();//调用String重写过的hashcide方法
    }

    public String getTitle(){//获得题干
        return this.title;
    }
    public String getAnswer(){//获得答案
        return this.answer;
    }


}
