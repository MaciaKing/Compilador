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
public class TablaProcedimientos {
    private ArrayList<Procedimiento> tablaP;
    int np=-1;
    
    public TablaProcedimientos(){
        tablaP = new ArrayList();
    }
    
    public int addProcedimiento(Procedimiento p){
        np++;
        tablaP.add(p);
        return np;
    }
    
    public int getNP(){
        return np;
    }
}
