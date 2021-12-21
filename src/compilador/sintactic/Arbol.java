/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.sintactic;

import compilador.sintactic.Nodo;

/**
 *
 * @author macia
 */
public class Arbol {

    private static Nodo raiz;
    
    private Nodo sol;

    public Arbol() {
        raiz = null;
    }

    public static void introducirRaiz(Nodo n) {
        raiz = n;
    }

    //Creamos un nodo hijo 'n', del nodo 'padre' en la posicion 'idx'
    public void introducirNodo(Nodo n, Nodo padre, int idx) {
        Nodo p = encontrarNodo(padre/*, raiz*/); //encontramos el nodo padre dentro de nuestra estructura
        //System.out.println("NODO PADRE ENCONTRADO = "+p);
        p.setHijo(idx, n);
        n.setPadre(padre);
    }

    //Haremos un recorrido en PREORDEN empezando desde el nodo 'raiz',
    // hasta encontrar el Nodo 'n'.
    // Encontramos el nodo 'n' dentro de nuestra estructura.
    private Nodo encontrarNodo(Nodo padre) {
      encontrarNodo(padre, raiz);
      return sol;
    }

    private void encontrarNodo(Nodo n, Nodo actual) {
        if (n.equals(actual)) {
            sol= actual;
        } else {
            for (int i = 0; i < actual.nhijos(); i++) {
                if (!(actual.getNHijo(i) == null)) {
                     encontrarNodo(n, actual.getNHijo(i));
                }
            }
        }
        
    }

    private void preorden(Nodo actual) {
        System.out.print(actual + "\n");
        if (actual.tieneHijos()) {
            for (int i = 0; i < actual.nhijos(); i++) {
//                    System.out.println(actual.getNHijo(i) == null);
                if (actual.getNHijo(i) == null) { //no fassis res
                } else {
                    preorden(actual.getNHijo(i));
                }
            }

        }
    }

    public String toString() {
        preorden(raiz);
        return "";
    }
}
