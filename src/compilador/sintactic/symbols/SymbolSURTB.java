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
public class SymbolSURTB extends ComplexSymbolFactory.ComplexSymbol {
    
    public SymbolSURTB(String name, int id) {
        super(name, id);
    }
    
    public SymbolSURTB(){
        super("SURTB",0);
    }
    
}