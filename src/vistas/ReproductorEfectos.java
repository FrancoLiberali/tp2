package vistas;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.media.AudioClip;

public class ReproductorEfectos {

    private static Map<String, AudioClip> efectos;
    public static String ERROR = "error1";
    public static String ENDTURN = "endTurn";
    public static String MOVE = "moveFx";
    public static String ATTACK = "atkFx";
    private static String errorTeamResource = "src/vistas/musica/disc_fire1.mp3";
    private static String endTurnResource = "src/vistas/musica/black_hole.mp3";
    private static String moveFXResource = "src/vistas/musica/impulse_1.mp3";
    private static String atkFXResource = "src/vistas/musica/hit.mp3";
    private static Boolean isMute = false;


    public static void inicializarReproductorFX() {
        efectos = new HashMap<>();
        efectos.put(ERROR, crearAudioClip(errorTeamResource));
        efectos.put(ENDTURN, crearAudioClip(endTurnResource));
        efectos.put(MOVE, crearAudioClip(moveFXResource));
        efectos.put(ATTACK, crearAudioClip(atkFXResource));
    }


    private static AudioClip crearAudioClip(String fxFileSource) {
        return new AudioClip(new File(fxFileSource).toURI().toString());
    }


    public static void reproducirFX(String fx) {
        if (isMute)
            return;

        efectos.get(fx).play();
    }


    public static void setMute(Boolean bool) {
        isMute = bool;
    }


    public static boolean isMute() {
        return isMute;
    }
}