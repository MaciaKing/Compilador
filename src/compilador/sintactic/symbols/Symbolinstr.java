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
public class Symbolinstr extends SymbolBase {
    public String id;
    public int valor;
    public Symbolinstr(String name, Integer id) {
        super(name, id);
    }

    public Symbolinstr() {
        super("instr", 0);
    }

    public Symbolinstr(SymbolCND e1, SymbolSENTS e2) {
        super("instr", 0);
        if (!e1.booleano) {
            System.out.println("NO SE CUMPLE EL SI, ENTRA EN EL SINO "
                    + "Y EL RESULTADO ES: " + e2.identificador + " = " + e2.resultado);
        }
    }

    public Symbolinstr(Symbolinstr e1, SymbolSENTS e2) {
        super("instr", 0);
    }

    public Symbolinstr(SymbolCND e1) {
        super("instr", 0);
    }

    public Symbolinstr(SymbolCND e1, SymbolP p) {
        super("instr", 0);
    }

    public Symbolinstr(SymbolELp e1) {
        super("instr", 0);
    }

    public Symbolinstr(SymbolEL e1, Symbolinstr e2) {
        super("instr", 0);
    }

    public Symbolinstr(SymbolEL e1) {
        super("instr", 0);
    }

    public Symbolinstr(SymbolSENTS e1) {
        super("instr", 0);
    }

}
