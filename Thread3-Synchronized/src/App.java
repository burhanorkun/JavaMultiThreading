
public class App {

	private int count = 0;
	
	public static void main(String[] args) {

		App app = new App();
		app.doWork();
		
	}
	
	private synchronized void increment() {
		count++;
	}
	
	public void doWork() {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10_000; i++) {
					increment();
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10_000; i++) {
					increment();
				}
			}
			
		});
		
		t1.start();
		t2.start(); 
		
		try {
			t1.join();
			System.out.println("first thread finished");
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("second thred finished");
		
		System.out.println("count: " + count);
	}

}
