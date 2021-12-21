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
public class SymbolI extends SymbolBase {

    public SymbolI(String name, Integer id) {
        super(name, id);
    }

    public SymbolI() {
        super("I", 0);
    }

}
