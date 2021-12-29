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
public class Etiqueta {
    
    ArrayList<Etiqueta> tET = new ArrayList<>();
    String etiqueta;
    int numET;
    
    public Etiqueta(){
        
    }
    
    public Etiqueta(String s){
        this.etiqueta = s;
    }
    
    public String novaET(){
        String et = "";
        if(tET.isEmpty()){
            et += "E_0";
            tET.add(new Etiqueta(et));
            numET++;
        }else{
            Integer i = tET.size();
            et += "E_" + Integer.toString(i);
            tET.add(new Etiqueta(et));
            numET++;
        }
        return et;
    }
    
    public String getEtiqueta(){
        return etiqueta;
    }
}
