package fixedBufferMonitor;

/**
 * A Java implementation of the "Blocking Bounded-Buffer Produce/Consumer" shown in
 * Figure 5.16 using Java Monitors.
 * 
 */
public class BlockingFiniteQueue
{
	private
		final int max = 90;
	 	String buffer[] = new String[max];
	 	int c = 0;
	 	int in = 0;
	 	int out = 0;
	 	Object nfull = new Object();
		Object nempty = new Object();

	public void append(String str) throws Exception
	{
		for(;;) {
			if (c > max) {
				synchronized (nfull) {
					nfull.wait();
				}
			}
			
			synchronized (this) {
				if (c > max) {
					continue;
				}

				buffer[in] = str;
				in = ++in % max;
				c++;
				synchronized (nempty) {
					nempty.notify();
				}
				return;
			}
		}
	}

	public String take() throws Exception
	{
		while (true) {
			if (c < 1) {
				synchronized (nempty) {
					nempty.wait();
				}
			}

			synchronized (this) {
				if (c < 1) {
					continue;
				}

				String output = buffer[out];
				out = ++out % max;
				c--;
				synchronized (nfull) {
					nfull.notify();
				}
				return output;
			}
		}
	}
}
