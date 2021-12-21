/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.sintactic;

/**
 *
 * @author macia
 */
public class Nodo<T> {

    private Nodo padre;
    private Nodo hijos[];
    private int id;
    public T ob;

    public Nodo(int hijosMax, int id, T ob) {
        this.id = id;
        hijos = new Nodo[hijosMax];
        for (int i = 0; i < hijos.length; i++) {
            hijos[i] = null;
        }
    }

    public void setHijo(int idx, Nodo hijo) {
        hijos[idx] = hijo;
    }

    public boolean tieneHijos() {
        for (int i = 0; i < hijos.length; i++) {
            if (hijos[i] != null) {
                return true;
            }
        }
        return false;
    }

    public int nhijos() {
        return hijos.length;
    }

    public Nodo getNHijo(int idx) {
        return hijos[idx];
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    @Override
    public String toString() {
        return "NODO:= [" + id + "] hijos  [" + nhijos() + "]";
    }

}
