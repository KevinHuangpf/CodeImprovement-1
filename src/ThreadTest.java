

public class ThreadTest 
{
	public static void main(String[] args)
	{
		MyThread1 thread1 = new MyThread1();
		Thread t1= new Thread(thread1);
		t1.start();
		MyThread2 thread2 = new MyThread2();
		thread2.start();
	}

}
