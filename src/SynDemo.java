import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.*;

public class SynDemo{

    public static void main(String[] arg){
        Runnable t1=new MyThread();
        new Thread(t1,"t1").start();


        new Thread(t1,"t2").start();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.size();
        concurrentHashMap.put(1,2);

    }

}
class MyThread implements Runnable {


   // private Lock lock=new ReentrantLock();
    ReentrantLock lock = new ReentrantLock();
    public void run() {
        lock.lock();
        try{
            for(int i=0;i<5;i++)
                System.out.println(Thread.currentThread().getName()+":"+i);
        }finally{
            lock.unlock();
        }
    }

}