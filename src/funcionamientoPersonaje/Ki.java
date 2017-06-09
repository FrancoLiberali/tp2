package funcionamientoPersonaje;

import exceptions.KiInsuficienteException;

public class Ki {
	private int ki;
	
	public Ki(int kiInicial){
		this.ki = kiInicial;
	}
	
	public void sumar(int cantidad){
		ki = ki + cantidad;
	}
	
	public int getKi(){
		return ki;
	}
	
	public void restar(Ki kiARestar){
		this.esMayor(kiARestar);
		
		ki = ki - (kiARestar.getKi());
	}
	
	private void esMayor(Ki otroKi){
		if (ki < otroKi.getKi()){
			throw new KiInsuficienteException();
		}
	}
	

}
