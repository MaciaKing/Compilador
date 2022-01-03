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
public class SymbolGEN3A extends ComplexSymbolFactory.ComplexSymbol {

    public SymbolGEN3A(String name, int id) {
        super(name, id);
    }

    public SymbolGEN3A() {
        super("GEN3A", 0);
    }
}
