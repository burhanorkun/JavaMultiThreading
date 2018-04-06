package O_01starting.demo1;

public class demo1 {

	public static void main(String[] arg) {
		Runner runner1 = new Runner();
		runner1.run();
		Runner runner2 = new Runner();
		runner2.run();
	}
}

class Runner extends Thread{

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Hello " + i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
}
