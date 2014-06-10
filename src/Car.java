import java.util.concurrent.*;

public class Car implements Runnable{
	private final Semaphore s;
	private final String brand;
	
	Car(Semaphore s, String brand){
		this.brand=brand;
		this.s=s;
	}
	
	@Override
	public void run() {
		try{
			s.acquire();
			System.out.println("The semaphore for the car "+brand+" is green!");
			Thread.sleep(1000);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			s.release();
		}
	}

}
