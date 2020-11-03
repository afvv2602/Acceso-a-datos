
public class HiloDead extends Thread
{
	private boolean stopHilo = false;

	public void pararHilo()
	{
		stopHilo = true;
	}
	
	public void run()
	{
		while(!stopHilo)
		{
			System.out.println("En el hilo");
		}
		System.out.println("El hilo muere de forma natural");
	}
	public static void main(String[] args) 
	{
		HiloDead h = new HiloDead();
		h.start();
		for (int i = 0; i < 100000; i++)
			;
		
		h.pararHilo();

	}

}
