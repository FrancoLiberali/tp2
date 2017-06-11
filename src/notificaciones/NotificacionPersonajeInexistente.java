package notificaciones;


public class NotificacionPersonajeInexistente extends NotificadorDeError{
	private String mje;

	protected void notificarError(String mje) {
		System.out.println(mje);

	}

}