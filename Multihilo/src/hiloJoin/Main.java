package hiloJoin;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Hilo h1 = new Hilo("Hilo 1", 2);
		Hilo h2 = new Hilo("Hilo 2", 5);
		Hilo h3 = new Hilo("Hilo 3", 7);
		h1.start();

		try
		{
			h1.join();
			h2.join();
			h3.join();

		}
		catch(InterruptedException e){}
		h2.start();
		h3.start();
		System.out.println("Final del programa");

	}

}
