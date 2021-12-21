/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.sintactic.symbols;

import compilador.sintactic.symbols.SymbolBase;

/**
 *
 * @author jfher
 */
public class SymbolELp extends SymbolBase{
    
    public int valor = 0;
    public String identificador;

    public SymbolELp(String name, Integer id) {
        super(name, id);
    }
    
    public SymbolELp(Integer v){
        super("ELp",0);
        this.valor = v;
    }
    
     public SymbolELp(Integer v, String id){
        super("ELp",0);
        this.valor = v;
        this.identificador = id;
    }

    public SymbolELp() {
        super("ELp",0);
    }
    
    public SymbolELp(String s) {
        super("ELp",0);
        this.identificador = s;
    }
    
}
