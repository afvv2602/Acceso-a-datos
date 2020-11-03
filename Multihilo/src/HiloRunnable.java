
public class HiloRunnable implements Runnable 
{
	Thread t;
		
	public HiloRunnable() 
	{
		t = new Thread(this, "Nuevo Hilo");
		System.out.println("Creando hilo.. "+t);
		System.out.println("Nombre hilo\t prioridad \t grupo ");
		t.start();
	}
	public void run()
	{
		System.out.println("Hilo en ejecución");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		System.out.println("Creando un hilo en el main");
		new HiloRunnable();
		System.out.println("Termina el hilo");
	}

}
