package hiloSuspendido;

public class GestorSuspender 
{
	private boolean solicitudSuspender;

	public synchronized void set(boolean b)
	{
		solicitudSuspender = b;
		notifyAll();
	}
	public synchronized void waitForResume() throws InterruptedException
	{
		while(solicitudSuspender)
			wait();
	}
}
