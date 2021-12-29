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
public class SymbolCCND extends SymbolBase {

    public boolean booleano;
    int resultado;
    String identificador;
    Etiqueta e;

    public SymbolCCND(String name, Integer id) {
        super(name, id);
    }

    public SymbolCCND() {
        super("SymbolCCND", 0);
    }

    public SymbolCCND(Etiqueta et) {
        super("SymbolCCND", 0);
        this.e = et;
    }
    
    public Etiqueta getEtiqueta(){
        return e;
    }
}
