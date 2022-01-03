/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.sintactic.symbols;

/**
 *
 * @author jfher
 */
public class SymbolTE_ARGS1 extends SymbolBase {
    
    public String id;

    public SymbolTE_ARGS1(String name, Integer id) {
        super(name, id);
    }

    public SymbolTE_ARGS1() {
        super("TE_ARGS", 0);
    }

    public SymbolTE_ARGS1(String s) {
        super("SymbolTE_ARGS1", 0);
        this.id = s;
    }
}
