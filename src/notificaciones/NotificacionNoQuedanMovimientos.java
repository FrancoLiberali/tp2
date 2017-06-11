package notificaciones;

public class NotificacionNoQuedanMovimientos extends NotificadorDeError {
	private String mje;

	protected void notificarError(String mje) {
		System.out.println(mje);

	}
}
