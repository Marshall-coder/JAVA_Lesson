package Examples.philosopher;

public class TestMain {
    public static void main(String[] args){
        Chopstick c1=new Chopstick(1);
        Chopstick c2=new Chopstick(2);
        Chopstick c3=new Chopstick(3);
        Chopstick c4=new Chopstick(4);

        Philosopher p1=new Philosopher("a",c2,c1,0);
        Philosopher p2=new Philosopher("b",c3,c2,300);
        Philosopher p3=new Philosopher("c",c4,c3,0);
        Philosopher p4=new Philosopher("d",c1,c4,300);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
    }
}
