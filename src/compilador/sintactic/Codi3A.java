/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.sintactic;

import java.util.ArrayList;

/**
 *
 * @author jfher
 */
public class Codi3A {

    public static ArrayList<InstrCodi3A> C3A = new ArrayList<>();
    EscritorFichero EF= new EscritorFichero("Codi3a.txt");

    public Codi3A() {

    }

    public void generaC3A(InstrCodi3A c3a) {
        C3A.add(c3a);
        int x = 0;
    }

    public void generaFicheroC3A() {
        for (int i = 0; i < C3A.size(); i++) {
            InstrCodi3A inst = C3A.get(i);
            EF.escribirFichero(inst.toString());
        }
        EF.cierraFichero();

    }

    public void imprimeC3A() {
        for (int i = 0; i < C3A.size(); i++) {
            InstrCodi3A inst = C3A.get(i);
            System.out.println(inst);
        }
    }

}
