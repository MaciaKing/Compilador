/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.sintactic.symbols;

import compilador.sintactic.symbols.SymbolELp;
import compilador.sintactic.symbols.SymbolBase;
import compilador.sintactic.*;
import compilador.sintactic.ParserSym;

/**
 *
 * @author jfher
 */
public class SymbolSENTS extends SymbolBase {

    int resultado;
    String identificador;

    public SymbolSENTS(String name, Integer id) {
        super(name, id);
    }

    public SymbolSENTS(int operacion, SymbolELp e1, SymbolELp e2) {
        super("EL", 0);

        switch (operacion) {
            case ParserSym.ADD:
                resultado = e1.r + e2.r;
                break;
            case ParserSym.SUB:
                resultado = e1.r - e2.r;
                break;
        }
    }

    public SymbolSENTS(int operacion, SymbolELp e1, SymbolELp e2, String id) {
        super("EL", 0);
        this.identificador = id;
//        switch (operacion) {
//            case ParserSym.ADD:
//                resultado = e1.valor + e2.valor;
//                break;
//            case ParserSym.SUB:
//                resultado = e1.valor - e2.valor;
//                break;
//            case ParserSym.MUL:
//                resultado = e1.valor * e2.valor;
//                break;
//            case ParserSym.DIV:
//                resultado = e1.valor / e2.valor;
//                break;
//            case ParserSym.MOD:
//                resultado = e1.valor + e2.valor;
//                break;
//
//        }
    }

    public SymbolSENTS(SymbolELp e1, SymbolSENTS e2) {
        super("SENTS", 0);
    }

}
