/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.sintactic.symbols;

import java_cup.runtime.ComplexSymbolFactory;

/**
 *
 * @author macia
 */
public class SymbolENCAP extends ComplexSymbolFactory.ComplexSymbol {

    public boolean teArgs;
    public String id;

    public SymbolENCAP(String name, int id) {
        super(name, id);
    }

    public SymbolENCAP(boolean b, String s) {
        super("ENCAP", 0);
        this.teArgs = b;
        this.id = s;
    }

    public SymbolENCAP(boolean b) {
        super("ENCAP", 0);
        this.teArgs = b;
    }
}
