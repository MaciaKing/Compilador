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
     public static ArrayList<Procedimiento> tablaP;
    int np=0;
    
    public TablaProcedimientos(){
        tablaP = new ArrayList();
    }
    
    public int addProcedimiento(Procedimiento p){
        np++;
        tablaP.add(p);
        return np;
    }
    
    public Procedimiento removeProcedimiento(){
        Procedimiento p = tablaP.get(this.np-1);
        tablaP.remove(this.np-1);
        np--;
        return p;
    }
    
    public int getNP(){
        return np;
    }
    public  Procedimiento getProcedimiento(String s){
        int i=0;
    for(;i<tablaP.size();i++){
        if(tablaP.get(i).idProcedimiento.equals(s)){
            break;
        }
    }
    return tablaP.get(i);
    }
   public static Procedimiento getProcedimiento2(String s){
        int i=0;
    for(;i<tablaP.size();i++){
        if(tablaP.get(i).idProcedimiento.equals(s)){
            break;
        }
    }
    return tablaP.get(i);
    }
}
