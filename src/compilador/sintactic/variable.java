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
    static int nvar=0;
    /*Atributos de una variable*/
    public int idV;
    public String idVariable;// se puede quitar
    public tipoSub tSub;
    public int procedure;
    
    public variable(String s, tipoSub t, int p){
        this.idV=nvar;
        nvar++;
        this.idVariable = s; 
        this.tSub = t;
        this.procedure = p;
    }

    variable(tipoSub t,int p) {
        this.tSub = t;
        this.procedure = p;
    }
    
//    public String toString(){
//        return idVariable;
//    }

}
