/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.sintactic;

/**
 *
 * @author jfher
 */
public class OperandoC3A {
    
    TiposOperandoC3A type;
    String operando;
    
    public OperandoC3A(String s, TiposOperandoC3A tipo){
        this.operando = s;
        this.type = tipo;
    }
    
    @Override
    public String toString(){
        //String s = "OP{"+operando+" tipo: "+type.toString()+"}";
        //return s;
        String s = operando; //+" tipo: "+type.toString()+"}";
        return s;
    } 
    
    
}
