/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.sintactic.symbols;

import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;
//import compilador.sintactic.ParserSym;

/**
 *
 * @author jfher
 */
public class SymbolBase extends ComplexSymbol {
    
    public SymbolBase(String name, Integer id) {
        super(name, id);
    }
    
}
