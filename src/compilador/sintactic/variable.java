/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.sintactic;

import compilador.sintactic.tipoSub;

/**
 *
 * @author jfher
 */
public class variable {
    /*Atributos de una variable*/
    public String idVariable;
    public tipoSub tSub;
    public int procedure;
    
    public variable(String s, tipoSub t, int p){
        this.idVariable = s;
        this.tSub = t;
        this.procedure = p;
    }

    variable(tipoSub t) {
        this.tSub = t;
    }
    
}
