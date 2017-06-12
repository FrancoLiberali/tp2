package funcionamientoPersonaje.elementos;

public class AtaqueEspecial {
	private Ki kiNecesario;
	private String nombre;
	private int porcentaje = 0;
	
	public AtaqueEspecial(String nombre,int ki){
		this.kiNecesario = new Ki(ki);
		this.nombre = nombre;
	}
	
	public void setPorcentaje(int porcentaje){
		this.porcentaje = porcentaje;
	}
	
	public int getAtaque(int ataqueBasico, Ki kiPersonaje){
		kiPersonaje.restar(kiNecesario);
		return (ataqueBasico + (ataqueBasico * porcentaje/100));
	}
	
	public String getNombre(){
		return nombre;
	}
}
