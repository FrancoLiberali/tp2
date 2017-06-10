package funcionamientoPersonaje;

public class AtaqueEspecial {
	private Ki kiNecesario;
	private String nombre;
	private double porcentaje = 0;
	
	public AtaqueEspecial(String nombre,int ki){
		this.kiNecesario = new Ki(ki);
		this.nombre = nombre;
	}
	
	public void setPorcentaje(double porcentaje){
		this.porcentaje = porcentaje;
	}
	
	public int getAtaque(int ataqueBasico, Ki kiPersonaje){
		kiPersonaje.restar(kiNecesario);
		return (int)((double)ataqueBasico + ((double)ataqueBasico * porcentaje));
	}
	
	public String getNombre(){
		return nombre;
	}
}
