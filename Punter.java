package fixedBufferMonitor;

public class Punter implements Runnable
{
	private BlockingFiniteQueue buffer;
	static long count = 0;
	
	public Punter(BlockingFiniteQueue buffer)
	{
		this.buffer = buffer;
	}

	
	public void run()
	{
		while (true) {
			try {
				String item = buffer.take();
				if(item == null) {
					System.out.println("*** Should Never Be Null");
					break;
				}
				consume(item);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void consume(String item) throws Exception
    {
		count++;
		System.out.println(count + ":" + Thread.currentThread().getName() + " Consumed " + item);
    }

}
