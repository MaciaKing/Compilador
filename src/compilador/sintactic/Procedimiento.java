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
public class Procedimiento {

    public int n;
    public String idProcedimiento;
    public int ocupacion;
    public int nParametros;
    public ArrayList<variable> Parametros;
    public tipoSub tipo;
    public Procedimiento(int nivel, String id, int o, int p) {
        this.n = nivel;
        this.idProcedimiento = id;
        this.ocupacion = o;
        this.nParametros = p;
    }

    public Procedimiento(int nivel,String id, int p) {
        this.n = nivel;
        this.idProcedimiento = id;
        this.nParametros = p;
    }
    
    public Procedimiento(String s){
        this.idProcedimiento = s;
    }
    public Procedimiento(String s,ArrayList<variable> p){
        this.idProcedimiento = s;
        this.Parametros=p;
    }
}
