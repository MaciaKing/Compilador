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
public class SymbolCRIDAS extends SymbolBase {

    public String id;

    public SymbolCRIDAS(String name, Integer id) {
        super(name, id);
    }

    public SymbolCRIDAS() {
        super("CRIDAS", 0);
    }

    public SymbolCRIDAS(String s) {
        super("CRIDAS", 0);
        this.id = s;
    }

}
