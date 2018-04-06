import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Process implements Runnable{
	
	private int id;
	
	public Process(int id) {
		this.id = id;
	}
	
	public void run() {
		
		System.out.println("Starting: "  + id);
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		System.out.println("Completed: " + id);
	}
}

public class App {

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(2);

		for (int i = 0; i < 5; i++) {
			executor.submit(new Process(i));
		}
		
		executor.shutdown();
		
		System.out.println("All task submitted.");
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("All task completed.");
		
	}

}
