package model.personajes.elementos;

import model.tablero.Posicion;

public class Direccion {
    private static Direccion arriba;
    private static Direccion abajo;
    private static Direccion derecha;
    private static Direccion izquierda;
    private static Direccion arribaIzquierda;
    private static Direccion abajoIzquierda;
    private static Direccion arribaDerecha;
    private static Direccion abajoDerecha;
    static {
        derecha = new Direccion(0, 1);
        izquierda = new Direccion(0, -1);
        arriba = new Direccion(-1, 0);
        abajo = new Direccion(1, 0);
        arribaIzquierda = new Direccion(-1, -1);
        abajoIzquierda = new Direccion(1, -1);
        arribaDerecha = new Direccion(-1, 1);
        abajoDerecha = new Direccion(1, 1);
    }

    private int valueX;
    private int valueY;

    private Direccion(int valX, int valY) {
        this.valueX = valX;
        this.valueY = valY;
    }

    public static Direccion arriba() {
        return arriba;
    }
    
    public static Direccion abajo() {
        return abajo;
    }

    public static Direccion derecha() {
        return derecha;
    }

    public static Direccion izquierda() {
        return izquierda;
    }
    
    public static Direccion arribaDerecha() {
        return arribaDerecha;
    }
    
    public static Direccion abajoDerecha() {
        return abajoDerecha;
    }

    public static Direccion arribaIzquierda() {
        return arribaIzquierda;
    }

    public static Direccion abajoIzquierda() {
        return abajoIzquierda;
    }

    public Posicion proximaPosicion(Posicion posicion) {
        int nextF = posicion.getFila() + this.valueX;
        int nextC = posicion.getColumna() + this.valueY;

        return new Posicion(nextF, nextC);
    }

}
