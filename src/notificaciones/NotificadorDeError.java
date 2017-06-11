package notificaciones;


public abstract class NotificadorDeError{
	protected abstract void notificarError(String mje);
	protected String mensaje; 
	
	public void notificar()
	{
	notificarError(mensaje);
	}

}