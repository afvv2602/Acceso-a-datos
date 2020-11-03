package hiloSuspendido;


public class Hilo extends Thread
{
		private GestorSuspender suspender = new GestorSuspender();

		public void suspender()
		{
			suspender.set(true);
		}
		public void reanudar()
		{
			suspender.set(false);
		}
		public void run()
		{
			try
			{
				while(true)
				{
					suspender.waitForResume();
				}
			}
			catch(InterruptedException exception)
			{
				exception.printStackTrace();
			}
		}

}
