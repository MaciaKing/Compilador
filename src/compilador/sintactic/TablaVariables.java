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
public class TablaVariables {

    ArrayList<variable> tVar = new ArrayList<variable>();
    
    public int nv=-1; //numero de variables que tenemos
    
    public TablaVariables() {

    }

    public int addVariable(variable var) {
        nv++;
        tVar.add(var);
        return nv;
    }

    public variable obtenVariable(variable var) {
        int i = tVar.indexOf(var);
        if (i != -1) {
            variable v = tVar.get(i);
            return v;
        } else {
            return null;
        }
    }

    public variable get(int index) {
        variable v = tVar.get(index);
        return v;
    }

    public int getIdVariable(String nombre) {
        int id = -1;
        boolean trobat = false;
        for (int i = 0; i < tVar.size() && !trobat; i++) {
            if (tVar.get(i).idVariable.equals(nombre)) {
                trobat = true;
                id = i;
            }
        }
        return id;
    }

}
