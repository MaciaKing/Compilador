/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.sintactic.symbols;

import java.util.ArrayList;

/**
 *
 * @author jfher
 */
public class SymbolTE_ARGS1 extends SymbolBase {

    public String id;
    public ArrayList tArg = new ArrayList(); //indices de el ambito actual

    public SymbolTE_ARGS1(String name, Integer id) {
        super(name, id);
    }

    public SymbolTE_ARGS1() {
        super("TE_ARGS", 0);
    }

    public SymbolTE_ARGS1(String s, int i) {
        super("SymbolTE_ARGS1", 0);
        this.id = s;
        tArg.add(i);
    }

    public SymbolTE_ARGS1(String s, int i, ArrayList a) {
        super("SymbolTE_ARGS1", 0);
        this.id = s;
        this.tArg = a;
        tArg.add(i);
    }
}