package fixedBufferMonitor;

public class TrialApplication
{

	public static void main(String[] args)
	{
		BlockingFiniteQueue buffer = new BlockingFiniteQueue();

		Creator creator= new Creator(buffer, 3000);
		Thread t1 = new Thread(creator, "Creator");
		t1.start();

		for(int i = 0; i < 10; i++) {
			Punter punter = new Punter(buffer);
			Thread t2 = new Thread(punter, "Punter"  + i);
			t2.start();
		}

	}
}
