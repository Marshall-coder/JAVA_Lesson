package Exercises.Cointains;

public class ContainsMain {
    public static void main(String[] args) {
       /* //创建ComputerRoom对象
        ComputerRoom room=new ComputerRoom();
        Computer computer=room.ProduceComputer(501,1);
        Computer computer1=room.ProduceComputer(501,2);
        //Computer computer2=room.ProduceComputer(501,3);
        //创建Student对象
        Student student=new Student("张三",20);
        boolean nowState=computer.checkState();
        student.open(computer,student,nowState);
        student.use(computer,student);
        String value=computer.getState();
        //System.out.println("此时电脑的状态是"+value);
        //student.close(computer,student);


        //第二位学生 使用电脑
        Student student1=new Student("张三",20);
        boolean nowState1=computer.checkState();
        student.open(computer1,student1,nowState);
        student.use(computer1,student1);
        student.close(computer1,student1);*/





        /*String str1="abcdfehg";
        String str2="abc";
        str1.compareTo(str2);
        System.out.println(str1.compareTo(str2));
        System.out.println(str1);
        str1.toString();
        char ch=str1.charAt(1);
        str1.length();
        for(int i=0;i<str1.length();i++){
            char s=str1.charAt(i);
            System.out.println(s);
        }
        str1=str1.concat("ii");
        System.out.println(str1);*/

/*
        long t1=System.currentTimeMillis();
        String str="a";
        for(int i=0;i<20000;i++){
           // str+="a";
           // str=str.concat("a");
            StringBuffer s=new StringBuffer();
        }
        long t2=System.currentTimeMillis();
        long t3=t2-t1;
        System.out.println(t3);
*/


        String str="abcd";
        boolean value=str.contains("v");
        System.out.println(value);



    }
}
