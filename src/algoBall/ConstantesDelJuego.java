package algoBall;
    
public final class ConstantesDelJuego {
	private ConstantesDelJuego(){}  

    public static final int KI_INICIAL = 0;
	public static final String NOMBRE_TRANF_NORMAL = "Normal";
	public static final int KI_POR_TURNO = 5;
	public static final int REDUCCION_DE_ATAQUE = 20; //CUANDO EL PODER DE PELEA DEL ENEMIGO ES MAYOR
	
    //Goku.
	//posicion
	public static final int GOKU_FIL = 1;
	public static final int GOKU_COL = 0;
	//normal
	public static final String GOKU_NOMBRE = "Goku";
    public static final int PUNTOS_VIDA_GOKU   = 500;
    public static final int PODER_GOKU_NORMAL = 20;
    public static final int DISTANCIA_GOKU_NORMAL = 2;
    public static final int VELOCIDAD_GOKU_NORMAL = 2;
    //Goku primera transformacion.
    public static final int KI_GOKU_PRIMERA_TRANF = 20;
    public static final String NOMBRE_GOKU_PRIMERA_TRANSF = "Kaio-Ken";
    public static final int PODER_GOKU_PRIMERA_TRANSF = 40;
    public static final int DISTANCIA_GOKU_PRIMERA_TRANSF = 4;
    public static final int VELOCIDAD_GOKU_PRIMERA_TRANSF = 3;
    //Goku segunda transformacion.
    public static final int KI_SEGUNDA_TRANF_GOKU = 20;
    public static final String NOMBRE_GOKU_SEGUNDA_TRANF = "Super Sayajin";
    public static final int PODER_GOKU_SEGUNDA_TRANF = 2;
    public static final int DISTANCIA_GOKU_SEGUNDA_TRANF = 4;
    public static final int VELOCIDAD_GOKU_SEGUNDA_TRANF = 5;
    //Otros
    public static final int KI_ATQ_ESPECIAL_GOKU = 20;
    public static final int PROCENTAJE_DANIO_ATAQ_ESPECIAL_GOKU = 50;
    public static final int KI_ATQ_ESPECIAL_GOKU1 = 20;
    public static final int PORCENTAJE_TOPE_VIDA_PARA_MAYOR_DANIO_GOKU = 30;
    public static final int PORCENTAJE_AUMENTO_DANIO_GOKU = 20;
    public static final String NOMBRE_ATQ_ESPECIAL_GOKU = "Kamehameha";
    
    //Gohan
    //posicion
  	public static final int GOHAN_FIL = 2;
  	public static final int GOHAN_COL = 2;
    //Gohan normal.
	public static final String GOHAN_NOMBRE = "Gohan";
    public static final int PUNTOS_VIDA_GOHAN= 300;
    public static final int PODER_GOHAN_NORMAL = 15;
    public static final int DISTANCIA_GOHAN_NORMAL = 2;
    public static final int VELOCIDAD_GOHAN_NORMAL = 2;
    //Gohan primera transformacion.
    public static final int KI_GOHAN_PRIMERA_TRANF = 10;
    public static final String NOMBRE_GOHAN_PRIMERA_TRANSF = "Super Saiyajin fase 1";
    public static final int PODER_GOHAN_PRIMERA_TRANSF = 30;
    public static final int DISTANCIA_GOHAN_PRIMERA_TRANSF = 2;
    public static final int VELOCIDAD_GOHAN_PRIMERA_TRANSF = 2;
    //Gohan segunda transformacion.
    public static final int KI_SEGUNDA_TRANF_GOHAN = 30;
    public static final String NOMBRE_GOHAN_SEGUNDA_TRANSF = "Super Saiyajin fase 2";
    public static final int PODER_GOHAN_SEGUNDA_TRANSF = 100;
    public static final int DISTANCIA_GOHAN_SEGUNDA_TRANSF = 4;
    public static final int VELOCIDAD_GOHAN_SEGUNDA_TRANSF = 3;
    //Otros
    public static final int KI_ATQ_ESPECIAL_GOHAN = 10;
    public static final int PROCENTAJE_DANIO_ATAQ_ESPECIAL_GOHAN = 25;
    public static final int PORCENTAJE_TOPE_VIDA_ATAQ_OCULTO_GOHAN = 30;
    public static final String NOMBRE_ATQ_ESPECIAL_GOHAN = "Masenko";
    
    //Piccolo
    //posicion
  	public static final int PICCOLO_FIL = 2;
  	public static final int PICCOLO_COL = 3;
    //Piccolo normal.
    public static final String PICCOLO_NOMBRE = "Piccolo";
    public static final int PUNTOS_VIDA_PICCOLO = 500;
    public static final int PODER_PICCOLO_NORMAL = 20;
    public static final int DISTANCIA_PICCOLO_NORMAL = 2;
    public static final int VELOCIDAD_PICCOLO_NORMAL = 2;
    //Piccolo primera transformacion.
    public static final int KI_PICCOLO_PRIMERA_TRANF = 20;
    public static final String NOMBRE_PICCOLO_PRIMERA_TRANSF = "Fortalecido";
    public static final int PODER_PICCOLO_PRIMERA_TRANSF = 40;
    public static final int DISTANCIA_PICCOLO_PRIMERA_TRANSF= 4;
    public static final int VELOCIDAD_PICCOLO_PRIMERA_TRANSF = 3;
    //Piccolo segunda transformacion.
    public static final int PORCENTAJE_VIDA_GOHAN_PRIMERA_TRANF_PICCOLO = 20;
    public static final int KI_PICCOLO_SEGUNDA_TRANF = 0;
    public static final String NOMBRE_PICCOLO_SEGUNDA_TRANSF = "Protector";
    public static final int PODER_PICCOLO_SEGUNDA_TRANSF = 60;
    public static final int DISTANCIA_PICCOLO_SEGUNDA_TRANSF = 6;
    public static final int VELOCIDAD_PICCOLO_SEGUNDA_TRANSF = 4;
    //Otros
    public static final int KI_ATQ_ESPECIAL_PICCOLO = 10;
    public static final int PROCENTAJE_DANIO_ATAQ_ESPECIAL_PICCOLO = 25;
    public static final String NOMBRE_ATQ_ESPECIAL_PICCOLO = "Makankosappo";
    
    //Cell
    //posicion
  	public static final int CELL_FIL = 3;
  	public static final int CELL_COL = 2;
    //Cell normal.
    public static final String CELL_NOMBRE = "Cell";
    public static final int PUNTOS_VIDA_CELL = 500;
    public static final int PODER_CELL_NORMAL = 20;
    public static final int DISTANCIA_CELL_NORMAL = 3;
    public static final int VELOCIDAD_CELL_NORMAL = 2;
    //Cell primera transformacion.
    public static final int KI_CELL_PRIMERA_TRANF = 0;
    public static final int CELL_CANT_ABSORVER_VIDA_PRIMERA_TRANSF = 4;
    public static final String NOMBRE_CELL_PRIMERA_TRANSF = "Semi-perfecto";
    public static final int PODER_CELL_PRIMERA_TRANSF = 40;
    public static final int DISTANCIA_CELL_PRIMERA_TRANSF = 4;
    public static final int VELOCIDAD_CELL_PRIMERA_TRANSF = 3;
    //Cell segunda transformacion.
    public static final int KI_CELL_SEGUNDA_TRANF = 0;
    public static final int CELL_CANT_ABSORVER_VIDA_SEGUNDA_TRANSF = 8;
    public static final String NOMBRE_CELL_SEGUNDA_TRANSF = "Perfecto";
    public static final int PODER_CELL_SEGUNDA_TRANSF = 80;
    public static final int DISTANCIA_CELL_SEGUNDA_TRANSF = 4;
    public static final int VELOCIDAD_CELL_SEGUNDA_TRANSF = 4;
    //Otros
    public static final int KI_ATQ_ESPECIAL_CELL = 5;
    public static final String NOMBRE_ATQ_ESPECIAL_CELL = "Absorver";
    
    //Freezer
    //posicion
  	public static final int FREEZER_FIL = 3;
  	public static final int FREEZER_COL = 0;
    //Freezer Normal
    public static final String FREEZER_NOMBRE = "Freezer";
	public static final int PUNTOS_VIDA_FREEZER = 400;
    public static final int PODER_FREEZER_NORMAL = 20;
    public static final int DISTANCIA_FREEZER_NORMAL = 2;
    public static final int VELOCIDAD_FREEZER_NORMAL = 4;
    //Freezer primera transformacion.
    public static final int KI_FREEZER_PRIMERA_TRANF = 20;
    public static final int FREEZER_CANT_ABSORVER_VIDA_PRIMERA_TRANSF = 4;
    public static final String NOMBRE_FREEZER_PRIMERA_TRANSF = "Segunda Forma";
    public static final int PODER_FREEZER_PRIMERA_TRANSF = 40;
    public static final int DISTANCIA_FREEZER_PRIMERA_TRANSF = 3;
    public static final int VELOCIDAD_FREEZER_PRIMERA_TRANSF = 4;
    //Freezer segunda transformacion.
    public static final int KI_FREEZER_SEGUNDA_TRANF = 50;
    public static final String NOMBRE_FREEZER_SEGUNDA_TRANSF = "Definitivo";
    public static final int PODER_FREEZER_SEGUNDA_TRANSF = 50;
    public static final int DISTANCIA_FREEZER_SEGUNDA_TRANSF = 3;
    public static final int VELOCIDAD_FREEZER_SEGUNDA_TRANSF = 6;
    //Otros
    public static final int KI_ATQ_ESPECIAL_FREEZER = 20;
    public static final int PROCENTAJE_DANIO_ATAQ_ESPECIAL_FREEZER = 50;
    public static final String NOMBRE_ATQ_ESPECIAL_FREEZER = "Rayo Mortal";
     
    //MAJIN_BOO
    //posicion
  	public static final int MAJIN_BOO_FIL = 3;
  	public static final int MAJIN_BOO_COL = 1;
    //MAJIN_BOO Normal
    public static final String MAJIN_BOO_NOMBRE = "Majin Boo";
	public static final int PUNTOS_VIDA_MAJIN_BOO = 300;
    public static final int PODER_MAJIN_BOO_NORMAL = 30;
    public static final int DISTANCIA_MAJIN_BOO_NORMAL = 2;
    public static final int VELOCIDAD_MAJIN_BOO_NORMAL = 2;
    //MAJIN_BOO primera transformacion.
    public static final int KI_MAJIN_BOO_PRIMERA_TRANF = 20;
    public static final String NOMBRE_MAJIN_BOO_PRIMERA_TRANSF = "Boo Malo";
    public static final int PODER_MAJIN_BOO_PRIMERA_TRANSF = 50;
    public static final int DISTANCIA_MAJIN_BOO_PRIMERA_TRANSF = 2;
    public static final int VELOCIDAD_MAJIN_BOO_PRIMERA_TRANSF = 3;
    //MAJIN_BOO segunda transformacion.
    public static final int KI_MAJIN_BOO_SEGUNDA_TRANF = 50;
    public static final String NOMBRE_MAJIN_BOO_SEGUNDA_TRANSF = "Boo Original";
    public static final int PODER_MAJIN_BOO_SEGUNDA_TRANSF = 60;
    public static final int DISTANCIA_MAJIN_BOO_SEGUNDA_TRANSF= 3;
    public static final int VELOCIDAD_MAJIN_BOO_SEGUNDA_TRANSF = 4;
    //Otros
    public static final int KI_ATQ_ESPECIAL_MAJIN_BOO = 30;
    public static final String NOMBRE_ATQ_ESPECIAL_MAJIN_BOO = "Conviertete en Chocolate";
    
    
    //Consumibles
    public static final String SEMILLA_HERMITANEO_NOMBRE = "Semilla del Hermitaneo";
    public static final String ESFERA_DEL_DRAGON_NOMBRE = "Esfera del Dragon";
    public static final String NUBE_VOLADORA_NOMBRE = "Nube Voladora";
    public static final int SEMILLA_HERMITANEO_PLUS_VIDA = 100;
    public static final int ESFERA_DEL_DRAGON_PORCENTAJE_PLUS_DANIO = 25;
    public static final int ESFERA_DEL_DRAGON_TURNOS = 2;
    public static final int NUBE_VOLADORA_MULTIPLICADOR_VELOCIDAD = 2;
    public static final int NUBE_VOLADORA_TURNOS = 2;

}
    
