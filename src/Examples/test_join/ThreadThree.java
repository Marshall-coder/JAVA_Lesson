package Examples.test_join;

public class ThreadThree extends Thread{

        private ThreadTwo two;
        public ThreadThree(ThreadTwo two){
            this.two=two;
        }

       public void run(){
            //在two执行的过程中  one等待的过程中   three将two对象锁定  会发生什么?
           System.out.println("thread-three start");
            //锁定two对象
           synchronized (two){
               System.out.println("thread two is locked");
               try {
                   Thread.sleep(10000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println("two is free");
           }
           System.out.println("thread three end");
        }



    }

