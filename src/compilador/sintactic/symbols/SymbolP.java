/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.sintactic.symbols;

import compilador.sintactic.symbols.SymbolBase;
import compilador.sintactic.*;
import compilador.sintactic.ParserSym;
import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;

/**
 *
 * @author jfher
 */
public class SymbolP extends SymbolBase {
    
    public String id;
    public int valor;

    public SymbolP(String name, Integer id) {
        super(name, id);
    }

    public SymbolP(SymbolP p1, SymbolCND s1) {
        super("P", 0);
    }

    public SymbolP(SymbolCND s1) {
        super("P", 0);
    }

    public SymbolP() {
        super("P", 0);
    }

    public SymbolP(Symbolinstr s1) {
        super("P", 0);
        this.id = s1.id;
        this.valor = s1.valor;
    }

}
