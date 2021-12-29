/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.sintactic.symbols;

import compilador.sintactic.Etiqueta;
import java_cup.runtime.ComplexSymbolFactory;

/**
 *
 * @author macia
 */
public class SymbolMm extends ComplexSymbolFactory.ComplexSymbol {
    
    public Etiqueta ei;

    public SymbolMm(String name, int id) {
        super(name, id);
    }

    public SymbolMm() {
        super("Mm", 0);
    }

    public SymbolMm(Etiqueta ei) {
        super("Mm", 0);
        this.ei = ei;
    }
}
