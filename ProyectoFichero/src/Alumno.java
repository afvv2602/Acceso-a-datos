
public class Alumno {

	private String id;
	private String nombre;
	private int edad;
	
	public Alumno (String id, String nombre, int edad) {
		this.nombre = nombre;
		this.id = id;
		this.edad = edad;
	}
	

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return  id + "#" + nombre + "#" + edad ;
	}
	
	
}
