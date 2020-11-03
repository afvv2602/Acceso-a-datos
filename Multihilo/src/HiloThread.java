

public class HiloThread extends Thread 
{

	public HiloThread(String str)
	{
		super(str);
	}
	
	public void run()
	{
		System.out.println("Creando hilo.. "+this);
		System.out.println("\tNombre hilo\t prioridad \t grupo ");
	}
	public static void main(String[] args)
	{
		System.out.println("Creando un hilo en el main");
		new HiloThread("NombreHilo").start();
		System.out.println("Termina el hilo");
	}
	


}
