/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.sintactic.symbols;

import compilador.sintactic.Etiqueta;
import compilador.sintactic.symbols.SymbolBase;
import compilador.sintactic.symbols.SymbolEL;

/**
 *
 * @author jfher
 */
public class SymbolSCND extends SymbolBase {

    Etiqueta e;

    public SymbolSCND(String name, Integer id) {
        super(name, id);
    }

    public SymbolSCND() {
        super("SymbolSCND", 0);
    }
    
    public SymbolSCND(Etiqueta et){
        super("SymbolSCND", 0);
        this.e = et;
    }
    
    public Etiqueta getEtiqueta(){
        return e;
    }
}
